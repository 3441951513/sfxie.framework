package com.sfxie.extension.jedis.utli;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


import com.sfxie.extension.jedis.client.IJedisOperator;
import com.sfxie.extension.jedis.client.JedisClusterOperator;
import com.sfxie.extension.jedis.entity.JedisPersistentObject;
import com.sfxie.extension.jedis.query.JedisVagueQuyerEnum;
import com.sfxie.utils.DateHelper;
import com.sfxie.utils.LoggerUtil;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.SortingParams;
import redis.clients.jedis.BinaryClient.LIST_POSITION;
import redis.clients.jedis.exceptions.JedisMovedDataException;

/**
 * @author Mr.hu
 * @version crateTime：2013-10-30 下午5:41:30 Class Explain:JedisUtil
 */
public class JedisUtil implements IJedisOperator {
	
	private static ThreadLocal<Jedis> currentJedis = new ThreadLocal<Jedis>();
	
	private String oneOfClusterIpAndPort;

	private JedisPool jedisPool;
	
	private static ThreadPoolExecutor threadPool;
	/** 集群单例	 */
	private static JedisCluster jedisCluster;
	/** 集群桶大小	*/
	private static int SLOTS = 16384;
	/**	集群所有主节点集合	*/
	private static Map<String,Jedis> masterJedisMap = new HashMap<String,Jedis> ();
	/**	集群所有从节点集合	*/
	private static Map<String,Jedis> slaveJedisMap = new HashMap<String,Jedis> ();

	/**
	 * 缓存生存时间
	 */
	private final int expire = 60000;
	/** 操作Key的方法 */
	public Keys KEYS = new Keys();
	/** 对存储结构为String类型的操作 */
	public Strings STRINGS = new Strings();
	/** 对存储结构为List类型的操作 */
	public Lists LISTS = new Lists();
	/** 对存储结构为Set类型的操作 */
	public Sets SETS = new Sets();
	/** 对存储结构为HashMap类型的操作 */
	public Hash HASH = new Hash();
	/** 对存储结构为Set(排序的)类型的操作 */
	public SortSet SORTSET = new SortSet();

	private JedisUtil() {

	}
	
	@Override
	public Object getJedisCommands() {
		JedisPool jedisPool = getJedisPool();
//		jedisCluster
		if(null!=jedisPool){
			if(null==currentJedis.get())
				currentJedis.set(jedisPool.getResource());
			return currentJedis.get();
		}else{
			return jedisCluster;
		}
	}
	
	@SuppressWarnings("unused")
	/**	初始化方法	*/
	private void initCluster(){
		LoggerUtil.instance(JedisClusterOperator.class).info(this.getClass().getName()+"[开始初始化redis集群类型的操作类]");
		Date startTime = new Date();
		Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
		//Jedis Cluster will attempt to discover cluster nodes automatically
		//只需要添加服务器端集群中的任意一个节点就可以,其它的节点API会自动获取.
		String[] ipAndPort = oneOfClusterIpAndPort.split(":");
		jedisClusterNodes.add(new HostAndPort(ipAndPort[0],Integer.parseInt(ipAndPort[1])));
		jedisCluster = new JedisCluster(jedisClusterNodes);
		initParseJedisCluster();
		//初始化线程池大小
		int initThreadPoolSize = masterJedisMap.size();
		int maxThreadPoolSize = initThreadPoolSize * 2;
		threadPool =  new ThreadPoolExecutor(initThreadPoolSize, maxThreadPoolSize, 3, TimeUnit.SECONDS, 
												new ArrayBlockingQueue<Runnable>(initThreadPoolSize/2),  
								                new ThreadPoolExecutor.DiscardOldestPolicy());  
		Date endTime = new Date();
		LoggerUtil.instance(JedisClusterOperator.class).info(this.getClass().getName()+"[结束初始化redis集群类型的操作类]");
		LoggerUtil.instance(JedisClusterOperator.class).info(this.getClass().getName()+"[初始化redis集群类型的操作类总共花费的时间: "+DateHelper.getCompareString(startTime,endTime)+"]");
	}
	/**
	 * 初始化集群节点信息,获取主节点集合和从节点集合
	 */
	private static void initParseJedisCluster(){
		for(Integer i=0;i<SLOTS;i++){
			jedisCluster.set("INITDATA"+i, i.toString());
		}
		parseJedisCluster();
	}
	/**
	 * 分析主节点集合和从节点集合
	 */
	private static void parseJedisCluster(){
		Map<String, JedisPool> jMap = jedisCluster.getClusterNodes();
		for(String key : jMap.keySet()){
			String keyPojo = "INITDATA*";
			Jedis jedis = jMap.get(key).getResource();
			Set<String> setsT = jedis.keys(keyPojo);
			for(String keddy : setsT){
				try{
					jedis.get(keddy);
					if(null==masterJedisMap.get(key))
						masterJedisMap.put(key, jedis);
				}catch(JedisMovedDataException e){
					if(null==slaveJedisMap.get(key))
						slaveJedisMap.put(key, jedis);
				}
			}
		}
	}
	public JedisPool getJedisPool() {
		return jedisPool;
	}

	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}

	/**
	 * 从jedis连接池中获取获取jedis对象
	 * 
	 * @return
	 */
	/*public Jedis getJedis() {
		return getJedisPool().getResource();
	}*/

	/**
	 * 回收jedis
	 * 
	 * @param jedis
	 */
	public void returnJedis(Object command) {
		// jedisPool.getResource();
		if(JedisCluster.class.isAssignableFrom(command.getClass())){
			JedisCluster jedisCluster = (JedisCluster)command;
			try {
				jedisCluster.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//对Jedis操作类的处理
		else{
			Jedis jedis = (Jedis)command;
			jedis.close();
		}
	}

	/**
	 * 设置过期时间
	 * 
	 * @author ruan 2013-4-11
	 * @param key
	 * @param seconds
	 */
	public void expire(String key, int seconds) {
		if (seconds <= 0) {
			return;
		}
		/*Object command = getJedisCommands();
		if(JedisCluster.class.isAssignableFrom(command.getClass())){
			JedisThreadLocalSnapshot.toOldCacheMap(key, ((JedisCluster)command).get(key));
		}
		//对Jedis操作类的处理
		else{
			JedisThreadLocalSnapshot.toOldCacheMap(key, ((Jedis)command).get(key));
		}*/
		Object command = getJedisCommands();
		if(JedisCluster.class.isAssignableFrom(command.getClass())){
			JedisCluster cluster = (JedisCluster)command;
			cluster.expire(key, seconds);
		}
		//对Jedis操作类的处理
		else{
			Jedis jedis = (Jedis)command;
			jedis.expire(key, seconds);
		}
		returnJedis(command);
	}

	/**
	 * 设置默认过期时间
	 * 
	 * @author ruan 2013-4-11
	 * @param key
	 */
	public void expire(String key) {
		expire(key, expire);
	}

	// *******************************************Keys*******************************************//
	public class Keys {

		/**
		 * 清空所有key
		 */
		public String flushAll() {
			String stata = null;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				stata = jedis.flushAll();
			}
			returnJedis(command);
			return stata;
		}

		/**
		 * 更改key
		 * 
		 * @param String
		 *            oldkey
		 * @param String
		 *            newkey
		 * @return 状态码
		 * */
		public String rename(String oldkey, String newkey) {
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			String  status;
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				status = cluster.rename(oldkey, newkey);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				status = jedis.rename(oldkey, newkey);
			}
			returnJedis(command);
			return status;
		}

		/**
		 * 更改key
		 * 
		 * @param String
		 *            oldkey
		 * @param String
		 *            newkey
		 * @return 状态码
		 * */
		public String rename(byte[] oldkey, byte[] newkey) {
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			String  status;
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				status = cluster.rename(oldkey, newkey);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				status = jedis.rename(oldkey, newkey);
			}
			returnJedis(command);
			return status;
		}
		/**
		 * 更改key,仅当新key不存在时才执行
		 * 
		 * @param String
		 *            oldkey
		 * @param String
		 *            newkey
		 * @return 状态码
		 * */
		public long renamenx(String oldkey, String newkey) {
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			long  status;
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				status = cluster.renamenx(oldkey, newkey);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				status = jedis.renamenx(oldkey, newkey);
			}
			returnJedis(command);
			return status;
		}
		/**
		 * 更改key,仅当新key不存在时才执行
		 * 
		 * @param byte[]
		 *            oldkey
		 * @param byte[]
		 *            newkey
		 * @return 状态码
		 * */
		public long renamenx(byte[] oldkey, byte[] newkey) {
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			long  status;
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				status = cluster.renamenx(oldkey, newkey);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				status = jedis.renamenx(oldkey, newkey);
			}
			returnJedis(command);
			return status;
		}
		/**
		 * 设置key的过期时间，以秒为单位
		 * 
		 * @param String
		 *            key
		 * @param 时间
		 *            ,已秒为单位
		 * @return 影响的记录数
		 * */
		public long expired(String key, int seconds) {
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			long  count;
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				count = cluster.expire(key, seconds);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				count = jedis.expire(key, seconds);
			}
			returnJedis(command);
			return count;
		}
		/**
		 * 设置key的过期时间，以秒为单位
		 * 
		 * @param byte[]
		 *            key
		 * @param 时间
		 *            ,已秒为单位
		 * @return 影响的记录数
		 * */
		public long expired(byte[] key, int seconds) {
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			long  count;
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				count = cluster.expire(key, seconds);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				count = jedis.expire(key, seconds);
			}
			returnJedis(command);
			return count;
		}
		/**
		 * 设置key的过期时间,它是距历元（即格林威治标准时间 1970 年 1 月 1 日的 00:00:00，格里高利历）的偏移量。
		 * 
		 * @param String
		 *            key
		 * @param 时间
		 *            ,已秒为单位
		 * @return 影响的记录数
		 * */
		public long expireAt(String key, long timestamp) {
			
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			long  count;
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				count = cluster.expireAt(key, timestamp);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				count = jedis.expireAt(key, timestamp);
			}
			returnJedis(command);
			return count;
		}
		/**
		 * 设置key的过期时间,它是距历元（即格林威治标准时间 1970 年 1 月 1 日的 00:00:00，格里高利历）的偏移量。
		 * 
		 * @param byte[]
		 *            key
		 * @param 时间
		 *            ,已秒为单位
		 * @return 影响的记录数
		 * */
		public long expireAt(byte[] key, long timestamp) {
			
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			long  count;
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				count = cluster.expireAt(key, timestamp);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				count = jedis.expireAt(key, timestamp);
			}
			returnJedis(command);
			return count;
		}
		/**
		 * 查询key的过期时间
		 * 
		 * @param String
		 *            key
		 * @return 以秒为单位的时间表示
		 * */
		public long ttl(String key) {
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			long  len;
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				len = cluster.ttl(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				len = jedis.ttl(key);
			}
			returnJedis(command);
			return len;
		}
		/**
		 * 查询key的过期时间
		 * 
		 * @param byte[]
		 *            key
		 * @return 以秒为单位的时间表示
		 * */
		public long ttl(byte[] key) {
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			long  len;
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				len = cluster.ttl(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				len = jedis.ttl(key);
			}
			returnJedis(command);
			return len;
		}
		/**
		 * 取消对key过期时间的设置
		 * 
		 * @param key
		 * @return 影响的记录数
		 * */
		public long persist(String key) {
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			long  count;
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				count = cluster.persist(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				count = jedis.persist(key);
			}
			returnJedis(command);
			return count;
		}
		/**
		 * 取消对key过期时间的设置
		 * 
		 * @param byte[]
		 * 			key
		 * @return 影响的记录数
		 * */
		public long persist(byte[] key) {
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			long  count;
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				count = cluster.persist(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				count = jedis.persist(key);
			}
			returnJedis(command);
			return count;
		}
		/**
		 * 删除keys对应的记录,可以是多个key
		 * 
		 * @param String
		 *            ... keys
		 * @return 删除的记录数
		 * */
		public long del(String... keys) {
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			long  count;
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				count = cluster.del(keys);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				count = jedis.del(keys);
			}
			returnJedis(command);
			return count;
		}

		/**
		 * 删除keys对应的记录,可以是多个key
		 * 
		 * @param byte[]
		 *            ... keys
		 * @return 删除的记录数
		 * */
		public long del(byte[]... keys) {
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			long  count;
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				count = cluster.del(keys);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				count = jedis.del(keys);
			}
			returnJedis(command);
			return count;
		}

		/**
		 * 判断key是否存在
		 * 
		 * @param String
		 *            key
		 * @return boolean
		 * */
		public boolean exists(String key) {
			boolean exis;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				exis = cluster.exists(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				exis = jedis.exists(key);
			}
			returnJedis(command);
			return exis;
		}
		/**
		 * 判断key是否存在
		 * 
		 * @param byte[]
		 *            key
		 * @return boolean
		 * */
		public boolean exists(byte[] key) {
			boolean exis;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				exis = cluster.exists(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				exis = jedis.exists(key);
			}
			returnJedis(command);
			return exis;
		}
		/**
		 * 对List,Set,SortSet进行排序,如果集合数据较大应避免使用这个方法
		 * 
		 * @param String
		 *            key
		 * @return List<String> 集合的全部记录
		 * **/
		public List<String> sort(String key) {
			List<String> list = null;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				list = cluster.sort(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				list = jedis.sort(key);
			}
			returnJedis(command);
			return list;
		}
		/**
		 * 对List,Set,SortSet进行排序,如果集合数据较大应避免使用这个方法
		 * 
		 * @param byte[]
		 *            key
		 * @return List<byte[]> 集合的全部记录
		 * **/
		public List<byte[]> sort(byte[] key) {
			List<byte[]> list = null;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				list = cluster.sort(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				list = jedis.sort(key);
			}
			returnJedis(command);
			return list;
		}
		/**
		 * 对List,Set,SortSet进行排序或limit
		 * 
		 * @param String
		 *            key
		 * @param SortingParams
		 *            parame 定义排序类型或limit的起止位置.
		 * @return List<String> 全部或部分记录
		 * **/
		public List<String> sort(String key, SortingParams parame) {
			List<String> list = null;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				list = cluster.sort(key, parame);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				list = jedis.sort(key, parame);
			}
			returnJedis(command);
			return list;
		}
		/**
		 * 对List,Set,SortSet进行排序或limit
		 * 
		 * @param byte[]
		 *            key
		 * @param SortingParams
		 *            parame 定义排序类型或limit的起止位置.
		 * @return List<String> 全部或部分记录
		 * **/
		public List<byte[]> sort(byte[] key, SortingParams parame) {
			List<byte[]> list = null;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				list = cluster.sort(key, parame);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				list = jedis.sort(key, parame);
			}
			returnJedis(command);
			return list;
		}
		/**
		 * 返回指定key存储的类型
		 * 
		 * @param String
		 *            key
		 * @return String string|list|set|zset|hash
		 * **/
		public String type(String key) {
			String type ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				type = cluster.type(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				type = jedis.type(key);
			}
			returnJedis(command);
			return type;
		}
		/**
		 * 返回指定key存储的类型
		 * 
		 * @param byte[]
		 *            key
		 * @return String string|list|set|zset|hash
		 * **/
		public String type(byte[] key) {
			String type ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				type = cluster.type(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				type = jedis.type(key);
			}
			returnJedis(command);
			return type;
		}
		/**
		 * 查找所有匹配给定的模式的键
		 * 
		 * @param String
		 *            key的表达式,*表示多个，？表示一个
		 * */
		public Set<String> keys(String pattern) {
			Set<String> set = null;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
//				set = cluster.keys(pattern);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				set = jedis.keys(pattern);
			}
			returnJedis(command);
			return set;
		}
		/**
		 * 查找所有匹配给定的模式的键
		 * 
		 * @param byte[]
		 *            key的表达式,*表示多个，？表示一个
		 */
		public Set<byte[]> keys(byte[] pattern) {
			Set<byte[]> set = null;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
//				set = cluster.keys(pattern);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				set = jedis.keys(pattern);
			}
			returnJedis(command);
			return set;
		}
	}

	// *******************************************Sets*******************************************//
	public class Sets {

		/**
		 * 向Set添加一条记录，如果member已存在返回0,否则返回1
		 * 
		 * @param String
		 *            key
		 * @param String
		 *            member
		 * @return 操作码,0或1
		 * */
		public long sadd(String key, String member) {
			long s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.sadd(key, member);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.sadd(key, member);
			}
			returnJedis(command);
			return s;
		}
		/**
		 * 向Set添加一条记录，如果member已存在返回0,否则返回1
		 * 
		 * @param byte[]
		 *            key
		 * @param byte[]
		 *            member
		 * @return 操作码,0或1
		 * */
		public long sadd(byte[] key, byte[] member) {
			long s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.sadd(key, member);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.sadd(key, member);
			}
			returnJedis(command);
			return s;
		}

		/**
		 * 获取给定key中元素个数
		 * 
		 * @param String
		 *            key
		 * @return 元素个数
		 * */
		public long scard(String key) {
			long len ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				len = cluster.scard(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				len = jedis.scard(key);
			}
			returnJedis(command);
			return len;
		}
		/**
		 * 获取给定key中元素个数
		 * 
		 * @param byte[]
		 *            key
		 * @return 元素个数
		 * */
		public long scard(byte[] key) {
			long len ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				len = cluster.scard(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				len = jedis.scard(key);
			}
			returnJedis(command);
			return len;
		}
		/**
		 * 返回从第一组和所有的给定集合之间的差异的成员
		 * 
		 * @param String
		 *            ... keys
		 * @return 差异的成员集合
		 * */
		public Set<String> sdiff(String... keys) {
			Set<String> set ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				set = cluster.sdiff(keys);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				set = jedis.sdiff(keys);
			}
			returnJedis(command);
			return set;
		}
		/**
		 * 返回从第一组和所有的给定集合之间的差异的成员
		 * 
		 * @param byte[]
		 *            ... keys
		 * @return 差异的成员集合
		 * */
		public Set<byte[]> sdiff(byte[]... keys) {
			Set<byte[]> set ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				set = cluster.sdiff(keys);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				set = jedis.sdiff(keys);
			}
			returnJedis(command);
			return set;
		}
		/**
		 * 这个命令等于sdiff,但返回的不是结果集,而是将结果集存储在新的集合中，如果目标已存在，则覆盖。
		 * 
		 * @param String
		 *            newkey 新结果集的key
		 * @param String
		 *            ... keys 比较的集合
		 * @return 新集合中的记录数
		 * **/
		public long sdiffstore(String newkey, String... keys) {
			long s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.sdiffstore(newkey, keys);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.sdiffstore(newkey, keys);
			}
			returnJedis(command);
			return s;
		}
		/**
		 * 这个命令等于sdiff,但返回的不是结果集,而是将结果集存储在新的集合中，如果目标已存在，则覆盖。
		 * 
		 * @param byte[]
		 *            newkey 新结果集的key
		 * @param byte[]
		 *            ... keys 比较的集合
		 * @return 新集合中的记录数
		 * **/
		public long sdiffstore(byte[] newkey, byte[]... keys) {
			long s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.sdiffstore(newkey, keys);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.sdiffstore(newkey, keys);
			}
			returnJedis(command);
			return s;
		}
		/**
		 * 返回给定集合交集的成员,如果其中一个集合为不存在或为空，则返回空Set
		 * 
		 * @param String
		 *            ... keys
		 * @return 交集成员的集合
		 * **/
		public Set<String> sinter(String... keys) {
			Set<String> set;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				set = cluster.sinter(keys);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				set = jedis.sinter(keys);
			}
			returnJedis(command);
			return set;
		}
		/**
		 * 返回给定集合交集的成员,如果其中一个集合为不存在或为空，则返回空Set
		 * 
		 * @param byte[]
		 *            ... keys
		 * @return 交集成员的集合
		 * **/
		public Set<byte[]> sinter(byte[]... keys) {
			Set<byte[]> set;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				set = cluster.sinter(keys);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				set = jedis.sinter(keys);
			}
			returnJedis(command);
			return set;
		}
		/**
		 * 这个命令等于sinter,但返回的不是结果集,而是将结果集存储在新的集合中，如果目标已存在，则覆盖。
		 * 
		 * @param String
		 *            newkey 新结果集的key
		 * @param String
		 *            ... keys 比较的集合
		 * @return 新集合中的记录数
		 * **/
		public long sinterstore(String newkey, String... keys) {
			long s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.sinterstore(newkey, keys);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.sinterstore(newkey, keys);
			}
			returnJedis(command);
			return s;
		}
		/**
		 * 这个命令等于sinter,但返回的不是结果集,而是将结果集存储在新的集合中，如果目标已存在，则覆盖。
		 * 
		 * @param byte[]
		 *            newkey 新结果集的key
		 * @param byte[]
		 *            ... keys 比较的集合
		 * @return 新集合中的记录数
		 * **/
		public long sinterstore(byte[] newkey, byte[]... keys) {
			long s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.sinterstore(newkey, keys);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.sinterstore(newkey, keys);
			}
			returnJedis(command);
			return s;
		}
		/**
		 * 确定一个给定的值是否存在
		 * 
		 * @param String
		 *            key
		 * @param String
		 *            member 要判断的值
		 * @return 存在返回1，不存在返回0
		 * **/
		public boolean sismember(String key, String member) {
			boolean s;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.sismember(key, member);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.sismember(key, member);
			}
			returnJedis(command);
			return s;
		}
		/**
		 * 确定一个给定的值是否存在
		 * 
		 * @param byte[]
		 *            key
		 * @param byte[]
		 *            member 要判断的值
		 * @return 存在返回1，不存在返回0
		 * **/
		public boolean sismember(byte[] key, byte[] member) {
			boolean s;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.sismember(key, member);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.sismember(key, member);
			}
			returnJedis(command);
			return s;
		}
		/**
		 * 返回集合中的所有成员
		 * 
		 * @param String
		 *            key
		 * @return 成员集合
		 */
		public Set<String> smembers(String key) {
			Set<String> set ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				set = cluster.smembers(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				set = jedis.smembers(key);
			}
			returnJedis(command);
			return set;
		}
		/**
		 * 返回集合中的所有成员
		 * 
		 * @param byte[]
		 *            key
		 * @return 成员集合
		 */
		public Set<byte[]> smembers(byte[] key) {
			// ShardedJedis sjedis = getShardedJedis();
			Set<byte[]> set ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				set = cluster.smembers(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				set = jedis.smembers(key);
			}
			returnJedis(command);
			return set;
		}

		/**
		 * 将成员从源集合移出放入目标集合 <br/>
		 * 如果源集合不存在或不包哈指定成员，不进行任何操作，返回0<br/>
		 * 否则该成员从源集合上删除，并添加到目标集合，如果目标集合中成员已存在，则只在源集合进行删除
		 * 
		 * @param String
		 *            srckey 源集合
		 * @param String
		 *            dstkey 目标集合
		 * @param String
		 *            member 源集合中的成员
		 * @return 状态码，1成功，0失败
		 * */
		public long smove(String srckey, String dstkey, String member) {
			long s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.smove(srckey, dstkey, member);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.smove(srckey, dstkey, member);
			}
			returnJedis(command);
			return s;
		}
		/**
		 * 将成员从源集合移出放入目标集合 <br/>
		 * 如果源集合不存在或不包哈指定成员，不进行任何操作，返回0<br/>
		 * 否则该成员从源集合上删除，并添加到目标集合，如果目标集合中成员已存在，则只在源集合进行删除
		 * 
		 * @param byte[]
		 *            srckey 源集合
		 * @param byte[]
		 *            dstkey 目标集合
		 * @param byte[]
		 *            member 源集合中的成员
		 * @return 状态码，1成功，0失败
		 * */
		public long smove(byte[] srckey, byte[] dstkey, byte[] member) {
			long s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.smove(srckey, dstkey, member);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.smove(srckey, dstkey, member);
			}
			returnJedis(command);
			return s;
		}
		/**
		 * 从集合中删除成员
		 * 
		 * @param String
		 *            key
		 * @return 被删除的成员
		 * */
		public String spop(String key) {
			String s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.spop(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.spop(key);
			}
			returnJedis(command);
			return s;
		}
		/**
		 * 从集合中删除成员
		 * 
		 * @param byte[]
		 *            key
		 * @return 被删除的成员
		 * */
		public byte[] spop(byte[] key) {
			byte[] s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.spop(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.spop(key);
			}
			returnJedis(command);
			return s;
		}
		/**
		 * 从集合中删除指定成员
		 * 
		 * @param String
		 *            key
		 * @param String
		 *            member 要删除的成员
		 * @return 状态码，成功返回1，成员不存在返回0
		 * */
		public long srem(String key, String member) {
			long s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.srem(key, member);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.srem(key, member);
			}
			returnJedis(command);
			return s;
		}
		/**
		 * 从集合中删除指定成员
		 * 
		 * @param byte[]
		 *            key
		 * @param byte[]
		 *            member 要删除的成员
		 * @return 状态码，成功返回1，成员不存在返回0
		 * */
		public long srem(byte[] key, byte[] member) {
			long s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.srem(key, member);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.srem(key, member);
			}
			returnJedis(command);
			return s;
		}
		/**
		 * 合并多个集合并返回合并后的结果，合并后的结果集合并不保存<br/>
		 * 
		 * @param String
		 *            ... keys
		 * @return 合并后的结果集合
		 * @see sunionstore
		 * */
		public Set<String> sunion(String... keys) {
			Set<String> set ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				set = cluster.sunion(keys);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				set = jedis.sunion(keys);
			}
			returnJedis(command);
			return set;
		}
		/**
		 * 合并多个集合并返回合并后的结果，合并后的结果集合并不保存<br/>
		 * 
		 * @param byte[]
		 *            ... keys
		 * @return 合并后的结果集合
		 * @see sunionstore
		 * */
		public Set<byte[]> sunion(byte[]... keys) {
			Set<byte[]> set ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				set = cluster.sunion(keys);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				set = jedis.sunion(keys);
			}
			returnJedis(command);
			return set;
		}
		/**
		 * 合并多个集合并将合并后的结果集保存在指定的新集合中，如果新集合已经存在则覆盖
		 * 
		 * @param String
		 *            newkey 新集合的key
		 * @param String
		 *            ... keys 要合并的集合
		 * **/
		public long sunionstore(String newkey, String... keys) {
			long s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.sunionstore(newkey, keys);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.sunionstore(newkey, keys);
			}
			returnJedis(command);
			return s;
		}
		/**
		 * 合并多个集合并将合并后的结果集保存在指定的新集合中，如果新集合已经存在则覆盖
		 * 
		 * @param byte[]
		 *            newkey 新集合的key
		 * @param byte[]
		 *            ... keys 要合并的集合
		 * **/
		public long sunionstore(byte[] newkey, byte[]... keys) {
			long s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.sunionstore(newkey, keys);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.sunionstore(newkey, keys);
			}
			returnJedis(command);
			return s;
		}
	}

	// *******************************************SortSet*******************************************//
	public class SortSet {

		/**
		 * 向集合中增加一条记录,如果这个值已存在，这个值对应的权重将被置为新的权重
		 * 
		 * @param String
		 *            key
		 * @param double score 权重
		 * @param String
		 *            member 要加入的值，
		 * @return 状态码 1成功，0已存在member的值
		 * */
		public long zadd(String key, double score, String member) {
			long s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.zadd(key, score, member);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.zadd(key, score, member);
			}
			returnJedis(command);
			return s;
		}
		/**
		 * 向集合中增加一条记录,如果这个值已存在，这个值对应的权重将被置为新的权重
		 * 
		 * @param String
		 *            key
		 * @param double score 权重
		 * @param String
		 *            member 要加入的值，
		 * @return 状态码 1成功，0已存在member的值
		 * */
		public long zadd(byte[] key, double score, byte[] member) {
			long s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.zadd(key, score, member);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.zadd(key, score, member);
			}
			returnJedis(command);
			return s;
		}
		/**
		 * 向集合中增加一条记录,如果这个值已存在，这个值对应的权重将被置为新的权重
		 * 
		 * @param String
		 *            key
		 * @param Map<String, Double>
		 *            scoreMembers 要加入的值和权重，
		 * @return 状态码 1成功，0已存在member的值
		 * 
		 */
		public long zadd(String key, Map<String, Double> scoreMembers) {
			long s ;
			
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.zadd(key, scoreMembers);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.zadd(key, scoreMembers);
			}
			returnJedis(command);
			return s;
		}
		/**
		 * 向集合中增加一条记录,如果这个值已存在，这个值对应的权重将被置为新的权重
		 * 
		 * @param byte[]
		 *            key
		 * @param Map<byte[], Double>
		 *            scoreMembers 要加入的值和权重，
		 * @return 状态码 1成功，0已存在member的值
		 * 
		 */
		public long zadd(byte[] key, Map<byte[], Double> scoreMembers) {
			long s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.zadd(key, scoreMembers);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.zadd(key, scoreMembers);
			}
			returnJedis(command);
			return s;
		}

		/**
		 * 获取集合中元素的数量
		 * 
		 * @param String
		 *            key
		 * @return 如果返回0则集合不存在
		 * */
		public long zcard(String key) {
			long len ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				len = cluster.zcard(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				len = jedis.zcard(key);
			}
			returnJedis(command);
			return len;
		}
		/**
		 * 获取集合中元素的数量
		 * 
		 * @param byte[]
		 *            key
		 * @return 如果返回0则集合不存在
		 * */
		public long zcard(byte[] key) {
			long len ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				len = cluster.zcard(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				len = jedis.zcard(key);
			}
			returnJedis(command);
			return len;
		}
		/**
		 * 获取指定权重区间内集合的数量
		 * 
		 * @param String
		 *            key
		 * @param double min 最小排序位置
		 * @param double max 最大排序位置
		 * */
		public long zcount(String key, double min, double max) {
			// ShardedJedis sjedis = getShardedJedis();
			long len ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				len = cluster.zcount(key, min, max);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				len = jedis.zcount(key, min, max);
			}
			returnJedis(command);
			return len;
		}
		/**
		 * 获取指定权重区间内集合的数量
		 * 
		 * @param byte[]
		 *            key
		 * @param double min 最小排序位置
		 * @param double max 最大排序位置
		 * */
		public long zcount(byte[] key, double min, double max) {
			// ShardedJedis sjedis = getShardedJedis();
			long len ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				len = cluster.zcount(key, min, max);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				len = jedis.zcount(key, min, max);
			}
			returnJedis(command);
			return len;
		}
		/**
		 * 获得set的长度
		 * 
		 * @param String
		 * 		key
		 * @return
		 */
		public long zlength(String key) {
			long len = 0;
			Set<String> set ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				set = cluster.zrange(key, 0, -1);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				set = jedis.zrange(key, 0, -1);
			}
			len = set.size();
			returnJedis(command);
			return len;
		}
		/**
		 * 获得set的长度
		 * 
		 * @param byte[] 
		 * 			key
		 * @return
		 */
		public long zlength(byte[] key) {
			long len = 0;
			Set<byte[]> set ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				set = cluster.zrange(key, 0, -1);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				set = jedis.zrange(key, 0, -1);
			}
			len = set.size();
			returnJedis(command);
			return len;
		}
		/**
		 * 权重增加给定值，如果给定的member已存在
		 * 
		 * @param String
		 *            key
		 * @param double score 要增的权重
		 * @param String
		 *            member 要插入的值
		 * @return 增后的权重
		 * */
		public double zincrby(String key, double score, String member) {
			double s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.zincrby(key, score, member);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.zincrby(key, score, member);
			}
			returnJedis(command);
			return s;
		}
		/**
		 * 权重增加给定值，如果给定的member已存在
		 * 
		 * @param byte[]
		 *            key
		 * @param double score 要增的权重
		 * @param byte[]
		 *            member 要插入的值
		 * @return 增后的权重
		 * */
		public double zincrby(byte[] key, double score, byte[] member) {
			double s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.zincrby(key, score, member);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.zincrby(key, score, member);
			}
			returnJedis(command);
			return s;
		}
		/**
		 * 返回指定位置的集合元素,0为第一个元素，-1为最后一个元素
		 * 
		 * @param String
		 *            key
		 * @param int start 开始位置(包含)
		 * @param int end 结束位置(包含)
		 * @return Set<String>
		 * */
		public Set<String> zrange(String key, int start, int end) {
			Set<String> set ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				set = cluster.zrange(key, start, end);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				set = jedis.zrange(key, start, end);
			}
			returnJedis(command);
			return set;
		}
		/**
		 * 返回指定位置的集合元素,0为第一个元素，-1为最后一个元素
		 * 
		 * @param byte[]
		 *            key
		 * @param int start 开始位置(包含)
		 * @param int end 结束位置(包含)
		 * @return Set<String>
		 * */
		public Set<byte[]> zrange(byte[] key, int start, int end) {
			Set<byte[]> set ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				set = cluster.zrange(key, start, end);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				set = jedis.zrange(key, start, end);
			}
			returnJedis(command);
			return set;
		}
		/**
		 * 返回指定权重区间的元素集合
		 * 
		 * @param String
		 *            key
		 * @param double min 上限权重
		 * @param double max 下限权重
		 * @return Set<String>
		 * */
		public Set<String> zrangeByScore(String key, double min, double max) {
			// ShardedJedis sjedis = getShardedJedis();
			Set<String> set;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				set = cluster.zrangeByScore(key, min, max);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				set = jedis.zrangeByScore(key, min, max);
			}
			returnJedis(command);
			return set;
		}
		/**
		 * 返回指定权重区间的元素集合
		 * 
		 * @param byte[]
		 *            key
		 * @param double min 上限权重
		 * @param double max 下限权重
		 * @return Set<String>
		 * */
		public Set<byte[]> zrangeByScore(byte[] key, double min, double max) {
			// ShardedJedis sjedis = getShardedJedis();
			Set<byte[]> set;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				set = cluster.zrangeByScore(key, min, max);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				set = jedis.zrangeByScore(key, min, max);
			}
			returnJedis(command);
			return set;
		}
		/**
		 * 获取指定值在集合中的位置，集合排序从低到高
		 * 
		 * @see zrevrank
		 * @param String
		 *            key
		 * @param String
		 *            member
		 * @return long 位置
		 * */
		public long zrank(String key, String member) {
			long index ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				index = cluster.zrank(key, member);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				index = jedis.zrank(key, member);
			}
			returnJedis(command);
			return index;
		}
		/**
		 * 获取指定值在集合中的位置，集合排序从低到高
		 * 
		 * @see zrevrank
		 * @param byte[]
		 *            key
		 * @param byte[]
		 *            member
		 * @return long 位置
		 * */
		public long zrank(byte[] key, byte[] member) {
			long index ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				index = cluster.zrank(key, member);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				index = jedis.zrank(key, member);
			}
			returnJedis(command);
			return index;
		}
		/**
		 * 获取指定值在集合中的位置，集合排序从高到低
		 * 
		 * @see zrank
		 * @param String
		 *            key
		 * @param String
		 *            member
		 * @return long 位置
		 * */
		public long zrevrank(String key, String member) {
			long index ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				index = cluster.zrevrank(key, member);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				index = jedis.zrevrank(key, member);
			}
			returnJedis(command);
			return index;
		}
		/**
		 * 获取指定值在集合中的位置，集合排序从高到低
		 * 
		 * @see zrank
		 * @param byte[]
		 *            key
		 * @param byte[]
		 *            member
		 * @return long 位置
		 * */
		public long zrevrank(byte[] key, byte[] member) {
			long index ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				index = cluster.zrevrank(key, member);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				index = jedis.zrevrank(key, member);
			}
			returnJedis(command);
			return index;
		}
		/**
		 * 从集合中删除成员
		 * 
		 * @param String
		 *            key
		 * @param String
		 *            member
		 * @return 返回1成功
		 * */
		public long zrem(String key, String member) {
			long s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.zrem(key, member);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.zrem(key, member);
			}
			returnJedis(command);
			return s;
		}
		/**
		 * 从集合中删除成员
		 * 
		 * @param byte[]
		 *            key
		 * @param byte[]
		 *            member
		 * @return 返回1成功
		 * */
		public long zrem(byte[] key, byte[] member) {
			long s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.zrem(key, member);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.zrem(key, member);
			}
			returnJedis(command);
			return s;
		}
		/**
		 * 删除
		 * 
		 * @param String
		 * 			key
		 * @return
		 */
		public long zrem(String key) {
			long s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.del(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.del(key);
			}
			returnJedis(command);
			return s;
		}
		/**
		 * 删除
		 * 
		 * @param byte[]
		 * 			key
		 * @return
		 */
		public long zrem(byte[] key) {
			long s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.del(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.del(key);
			}
			returnJedis(command);
			return s;
		}
		/**
		 * 删除给定位置区间的元素
		 * 
		 * @param String
		 *            key
		 * @param int start 开始区间，从0开始(包含)
		 * @param int end 结束区间,-1为最后一个元素(包含)
		 * @return 删除的数量
		 * */
		public long zremrangeByRank(String key, int start, int end) {
			long s;
			
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.zremrangeByRank(key, start, end);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.zremrangeByRank(key, start, end);
			}
			returnJedis(command);
			return s;
		}
		/**
		 * 删除给定位置区间的元素
		 * 
		 * @param byte[]
		 *            key
		 * @param int start 开始区间，从0开始(包含)
		 * @param int end 结束区间,-1为最后一个元素(包含)
		 * @return 删除的数量
		 * */
		public long zremrangeByRank(byte[] key, int start, int end) {
			long s;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.zremrangeByRank(key, start, end);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.zremrangeByRank(key, start, end);
			}
			returnJedis(command);
			return s;
		}
		/**
		 * 删除给定权重区间的元素
		 * 
		 * @param String
		 *            key
		 * @param double min 下限权重(包含)
		 * @param double max 上限权重(包含)
		 * @return 删除的数量
		 * */
		public long zremrangeByScore(String key, double min, double max) {
			long s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.zremrangeByScore(key, min, max);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.zremrangeByScore(key, min, max);
			}
			returnJedis(command);
			return s;
		}
		/**
		 * 删除给定权重区间的元素
		 * 
		 * @param byte[]
		 *            key
		 * @param double min 下限权重(包含)
		 * @param double max 上限权重(包含)
		 * @return 删除的数量
		 * */
		public long zremrangeByScore(byte[] key, double min, double max) {
			long s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.zremrangeByScore(key, min, max);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.zremrangeByScore(key, min, max);
			}
			returnJedis(command);
			return s;
		}
		/**
		 * 获取给定区间的元素，原始按照权重由高到低排序
		 * 
		 * @param String
		 *            key
		 * @param int start
		 * @param int end
		 * @return Set<String>
		 * */
		public Set<String> zrevrange(String key, int start, int end) {
			Set<String> set ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				set = cluster.zrevrange(key, start, end);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				set = jedis.zrevrange(key, start, end);
			}
			returnJedis(command);
			return set;
		}
		/**
		 * 获取给定区间的元素，原始按照权重由高到低排序
		 * 
		 * @param byte[]
		 *            key
		 * @param int start
		 * @param int end
		 * @return Set<String>
		 * */
		public Set<byte[]> zrevrange(byte[] key, int start, int end) {
			Set<byte[]> set ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				set = cluster.zrevrange(key, start, end);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				set = jedis.zrevrange(key, start, end);
			}
			returnJedis(command);
			return set;
		}
		/**
		 * 获取给定值在集合中的权重
		 * 
		 * @param String
		 *            key
		 * @param memeber
		 * @return double 权重
		 * */
		public double zscore(String key, String memebr) {
			Double score;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				score = cluster.zscore(key, memebr);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				score = jedis.zscore(key, memebr);
			}
			returnJedis(command);
			if (score != null)
				return score;
			return 0;
		}
		/**
		 * 获取给定值在集合中的权重
		 * 
		 * @param String
		 *            key
		 * @param memeber
		 * @return double 权重
		 * */
		public double zscore(byte[] key, byte[] memebr) {
			Double score;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				score = cluster.zscore(key, memebr);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				score = jedis.zscore(key, memebr);
			}
			returnJedis(command);
			if (score != null)
				return score;
			return 0;
		}
	}

	// *******************************************Hash*******************************************//
	public class Hash {

		/**
		 * 从hash中删除指定的存储
		 * 
		 * @param String
		 *            key
		 * @param String
		 *            fieid 存储的名字
		 * @return 状态码，1成功，0失败
		 * */
		public long hdel(String key, String fieid) {
			long s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.hdel(key, fieid);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.hdel(key, fieid);
			}
			returnJedis(command);
			return s;
		}
		/**
		 * 从hash中删除指定的存储
		 * 
		 * @param byte[]
		 *            key
		 * @param byte[]
		 *            fieid 存储的名字
		 * @return 状态码，1成功，0失败
		 * */
		public long hdel(byte[] key, byte[] fieid) {
			long s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.hdel(key, fieid);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.hdel(key, fieid);
			}
			returnJedis(command);
			return s;
		}
		/**
		 * 
		 * @TODO	
		 * @author 	xieshengfeng
		 * @since 	下午2:28:35 2015-8-4
		 * @param String
		 * 			key
		 * @return	
		 *
		 */
		public long hdel(String key) {
			long s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.del(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.del(key);
			}
			returnJedis(command);
			return s;
		}
		/**
		 * 
		 * @TODO	
		 * @author 	xieshengfeng
		 * @since 	下午2:28:35 2015-8-4
		 * @param byte[]
		 * 			key
		 * @return	
		 *
		 */
		public long hdel(byte[] key) {
			long s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.del(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.del(key);
			}
			returnJedis(command);
			return s;
		}
		/**
		 * 测试hash中指定的存储是否存在
		 * 
		 * @param String
		 *            key
		 * @param String
		 *            fieid 存储的名字
		 * @return 1存在，0不存在
		 * */
		public boolean hexists(String key, String fieid) {
			boolean s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.hexists(key, fieid);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.hexists(key, fieid);
			}
			returnJedis(command);
			return s;
		}
		/**
		 * 测试hash中指定的存储是否存在
		 * 
		 * @param byte[]
		 *            key
		 * @param byte[]
		 *            fieid 存储的名字
		 * @return 1存在，0不存在
		 * */
		public boolean hexists(byte[] key, byte[] fieid) {
			boolean s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.hexists(key, fieid);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.hexists(key, fieid);
			}
			returnJedis(command);
			return s;
		}
		/**
		 * 返回hash中指定存储位置的值
		 * 
		 * @param String
		 *            key
		 * @param String
		 *            fieid 存储的名字
		 * @return 存储对应的值
		 * */
		public String hget(String key, String fieid) {
			String s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.hget(key, fieid);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.hget(key, fieid);
			}
			returnJedis(command);
			return s;
		}
		/**
		 * 返回hash中指定存储位置的值
		 * 
		 * @param byte[]
		 *            key
		 * @param byte[]
		 *            fieid 存储的名字
		 * @return 存储对应的值
		 * */
		public byte[] hget(byte[] key, byte[] fieid) {
			byte[] s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.hget(key, fieid);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.hget(key, fieid);
			}
			returnJedis(command);
			return s;
		}

		/**
		 * 以Map的形式返回hash中的存储和值
		 * 
		 * @param String
		 *            key
		 * @return Map<Strinig,String>
		 * */
		public Map<String, String> hgetAll(String key) {
			// ShardedJedis sjedis = getShardedJedis();
			Map<String, String> map;
			
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				map = cluster.hgetAll(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				map = jedis.hgetAll(key);
			}
			returnJedis(command);
			return map;
		}
		/**
		 * 以Map的形式返回hash中的存储和值
		 * 
		 * @param byte[]
		 *            key
		 * @return Map<byte[],byte[]>
		 * */
		public Map<byte[], byte[]> hgetAll(byte[] key) {
			// ShardedJedis sjedis = getShardedJedis();
			Map<byte[], byte[]> map;
			
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				map = cluster.hgetAll(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				map = jedis.hgetAll(key);
			}
			returnJedis(command);
			return map;
		}
		/**
		 * 添加一个对应关系
		 * 
		 * @param String
		 *            key
		 * @param String
		 *            fieid
		 * @param String
		 *            value
		 * @return 状态码 1成功，0失败，fieid已存在将更新，也返回0
		 * **/
		public long hset(String key, String fieid, String value) {
			long s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.hset(key, fieid, value);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.hset(key, fieid, value);
			}
			returnJedis(command);
			return s;
		}
		/**
		 * 添加一个对应关系
		 * 
		 * @param byte[]
		 *            key
		 * @param byte[]
		 *            fieid
		 * @param byte[]
		 *            value
		 * @return 状态码 1成功，0失败，fieid已存在将更新，也返回0
		 * **/
		public long hset(byte[] key, byte[] fieid, byte[] value) {
			long s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.hset(key, fieid, value);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.hset(key, fieid, value);
			}
			returnJedis(command);
			return s;
		}

		/**
		 * 添加对应关系，只有在fieid不存在时才执行
		 * 
		 * @param String
		 *            key
		 * @param String
		 *            fieid
		 * @param String
		 *            value
		 * @return 状态码 1成功，0失败fieid已存
		 * **/
		public long hsetnx(String key, String fieid, String value) {
			long s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.hsetnx(key, fieid, value);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.hsetnx(key, fieid, value);
			}
			returnJedis(command);
			return s;
		}
		/**
		 * 添加对应关系，只有在fieid不存在时才执行
		 * 
		 * @param byte[]
		 *            key
		 * @param byte[]
		 *            fieid
		 * @param byte[]
		 *            value
		 * @return 状态码 1成功，0失败fieid已存
		 * **/
		public long hsetnx(byte[] key, byte[] fieid, byte[] value) {
			long s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.hsetnx(key, fieid, value);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.hsetnx(key, fieid, value);
			}
			returnJedis(command);
			return s;
		}
		/**
		 * 获取hash中value的集合
		 * 
		 * @param String
		 *            key
		 * @return List<String>
		 * */
		public List<String> hvals(String key) {
			// ShardedJedis sjedis = getShardedJedis();
			List<String> list ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				list = cluster.hvals(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				list = jedis.hvals(key);
			}
			returnJedis(command);
			return list;
		}
		/**
		 * 获取hash中value的集合
		 * 
		 * @param byte[]
		 *            key
		 * @return List<byte[]>
		 * */
		public List<byte[]> hvals(byte[] key) {
			// ShardedJedis sjedis = getShardedJedis();
			List<byte[]> list ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				list = (List<byte[]>) cluster.hvals(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				list = jedis.hvals(key);
			}
			returnJedis(command);
			return list;
		}
		/**
		 * 在指定的存储位置加上指定的数字，存储位置的值必须可转为数字类型
		 * 
		 * @param String
		 *            key
		 * @param String
		 *            fieid 存储位置
		 * @param String
		 *            long value 要增加的值,可以是负数
		 * @return 增加指定数字后，存储位置的值
		 * */
		public long hincrby(String key, String fieid, long value) {
			long s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.hincrBy(key, fieid, value);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.hincrBy(key, fieid, value);
			}
			returnJedis(command);
			return s;
		}
		/**
		 * 在指定的存储位置加上指定的数字，存储位置的值必须可转为数字类型
		 * 
		 * @param byte[]
		 *            key
		 * @param byte[]
		 *            fieid 存储位置
		 * @param long
		 *            value 要增加的值,可以是负数
		 * @return 增加指定数字后，存储位置的值
		 * */
		public long hincrby(byte[] key, byte[] fieid, long value) {
			long s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.hincrBy(key, fieid, value);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.hincrBy(key, fieid, value);
			}
			returnJedis(command);
			return s;
		}
		/**
		 * 返回指定hash中的所有存储名字,类似Map中的keySet方法
		 * 
		 * @param String
		 *            key
		 * @return Set<String> 存储名称的集合
		 * */
		public Set<String> hkeys(String key) {
			Set<String> set;
			
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				set = cluster.hkeys(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				set = jedis.hkeys(key);
			}
			returnJedis(command);
			return set;
		}
		/**
		 * 返回指定hash中的所有存储名字,类似Map中的keySet方法
		 * 
		 * @param byte[]
		 *            key
		 * @return Set<byte[]> 存储名称的集合
		 * */
		public Set<byte[]> hkeys(byte[] key) {
			Set<byte[]> set;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				set = cluster.hkeys(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				set = jedis.hkeys(key);
			}
			returnJedis(command);
			return set;
		}
		/**
		 * 获取hash中存储的个数，类似Map中size方法
		 * 
		 * @param String
		 *            key
		 * @return long 存储的个数
		 * */
		public long hlen(String key) {
			long len ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				len = cluster.hlen(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				len = jedis.hlen(key);
			}
			returnJedis(command);
			return len;
		}
		/**
		 * 获取hash中存储的个数，类似Map中size方法
		 * 
		 * @param byte[]
		 *            key
		 * @return long 存储的个数
		 * */
		public long hlen(byte[] key) {
			long len ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				len = cluster.hlen(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				len = jedis.hlen(key);
			}
			returnJedis(command);
			return len;
		}
		/**
		 * 根据多个key，获取对应的value，返回List,如果指定的key不存在,List对应位置为null
		 * 
		 * @param String
		 *            key
		 * @param String
		 *            ... fieids 存储位置
		 * @return List<String>
		 * */
		public List<String> hmget(String key, String... fieids) {
			List<String> list;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				list = cluster.hmget(key, fieids);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				list = jedis.hmget(key, fieids);
			}
			returnJedis(command);
			return list;
		}
		/**
		 * 根据多个key，获取对应的value，返回List,如果指定的key不存在,List对应位置为null
		 * 
		 * @param byte[]
		 *            key
		 * @param byte[]
		 *            ... fieids 存储位置
		 * @return List<byte[]>
		 * */
		public List<byte[]> hmget(byte[] key, byte[]... fieids) {
			List<byte[]> list;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				list = cluster.hmget(key, fieids);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				list = jedis.hmget(key, fieids);
			}
			returnJedis(command);
			return list;
		}

		/**
		 * 添加对应关系，如果对应关系已存在，则覆盖
		 * 
		 * @param Strin
		 *            key
		 * @param Map
		 *            <String,String> 对应关系
		 * @return 状态，成功返回OK
		 * */
		public String hmset(String key, Map<String, String> map) {
			String s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.hmset(key, map);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.hmset(key, map);
			}
			returnJedis(command);
			return s;
		}

		/**
		 * 添加对应关系，如果对应关系已存在，则覆盖
		 * 
		 * @param Strin
		 *            key
		 * @param Map
		 *            <String,String> 对应关系
		 * @return 状态，成功返回OK
		 * */
		public String hmset(byte[] key, Map<byte[], byte[]> map) {
			String s ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				s = cluster.hmset(key, map);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				s = jedis.hmset(key, map);
			}
			returnJedis(command);
			return s;
		}

	}

	// *******************************************Strings*******************************************//
	public class Strings {
		/**
		 * 根据key获取记录
		 * 
		 * @param String
		 *            key
		 * @return 值
		 * */
		public String get(String key) {
			String value ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				value = cluster.get(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				value = jedis.get(key);
			}
			returnJedis(command);
			return value;
		}

		/**
		 * 根据key获取记录
		 * 
		 * @param byte[] key
		 * @return 值
		 * */
		public byte[] get(byte[] key) {
			byte[] value ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				value = cluster.get(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				value = jedis.get(key);
			}
			returnJedis(command);
			return value;
		}

		/**
		 * 添加有过期时间的记录
		 * 
		 * @param String
		 *            key
		 * @param int seconds 过期时间，以秒为单位
		 * @param String
		 *            value
		 * @return String 操作状态
		 * */
		public String setEx(String key, int seconds, String value) {
			String str ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				str = cluster.setex(key, seconds, value);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				str = jedis.setex(key, seconds, value);
			}
			returnJedis(command);
			return str;
		}

		/**
		 * 添加有过期时间的记录
		 * 
		 * @param byte[]
		 *            key
		 * @param int seconds 过期时间，以秒为单位
		 * @param byte[]
		 *            value
		 * @return String 操作状态
		 * */
		public String setEx(byte[] key, int seconds, byte[] value) {
			String str ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				str = cluster.setex(key, seconds, value);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				str = jedis.setex(key, seconds, value);
			}
			returnJedis(command);
			return str;
		}

		/**
		 * 添加一条记录，仅当给定的key不存在时才插入
		 * 
		 * @param String
		 *            key
		 * @param String
		 *            value
		 * @return long 状态码，1插入成功且key不存在，0未插入，key存在
		 * */
		public long setnx(String key, String value) {
			long str;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				str = cluster.setnx(key, value);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				str = jedis.setnx(key, value);
			}
			returnJedis(command);
			return str;
		}
		/**
		 * 添加一条记录，仅当给定的key不存在时才插入
		 * 
		 * @param byte[]
		 *            key
		 * @param byte[]
		 *            value
		 * @return long 状态码，1插入成功且key不存在，0未插入，key存在
		 * */
		public long setnx(byte[] key, byte[] value) {
			long str;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				str = cluster.setnx(key, value);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				str = jedis.setnx(key, value);
			}
			returnJedis(command);
			return str;
		}
		/**
		 * 添加记录,如果记录已存在将覆盖原有的value
		 * 
		 * @param String
		 *            key
		 * @param String
		 *            value
		 * @return 状态码
		 * */
		public String set(String key, String value) {
			String status;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				status = cluster.set(key, value);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				status = jedis.set(key, value);
			}
			returnJedis(command);
			return status;
		}
		/**
		 * 添加记录,如果记录已存在将覆盖原有的value
		 * 
		 * @param byte[] key
		 * @param byte[] value
		 * @return 状态码
		 * */
		public String set(byte[] key, byte[] value) {
			String status;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				status = cluster.set(key, value);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				status = jedis.set(key, value);
			}
			returnJedis(command);
			return status;
		}

		/**
		 * 从指定位置开始插入数据，插入的数据会覆盖指定位置以后的数据<br/>
		 * 例:String str1="123456789";<br/>
		 * 对str1操作后setRange(key,4,0000)，str1="123400009";
		 * 
		 * @param String
		 *            key
		 * @param long offset
		 * @param String
		 *            value
		 * @return long value的长度
		 * */
		public long setRange(String key, long offset, String value) {
			long len ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				len = cluster.setrange(key, offset, value);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				len = jedis.setrange(key, offset, value);
			}
			returnJedis(command);
			return len;
		}
		/**
		 * 从指定位置开始插入数据，插入的数据会覆盖指定位置以后的数据<br/>
		 * 例:String str1="123456789";<br/>
		 * 对str1操作后setRange(key,4,0000)，str1="123400009";
		 * 
		 * @param byte[]
		 *            key
		 * @param long offset
		 * @param byte[]
		 *            value
		 * @return long value的长度
		 * */
		public long setRange(byte[] key, long offset, byte[] value) {
			long len ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				len = cluster.setrange(key, offset, value);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				len = jedis.setrange(key, offset, value);
			}
			returnJedis(command);
			return len;
		}
		/**
		 * 在指定的key中追加value
		 * 
		 * @param String
		 *            key
		 * @param String
		 *            value
		 * @return long 追加后value的长度
		 * **/
		public long append(String key, String value) {
			long len ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				len = cluster.append(key, value);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				len = jedis.append(key, value);
			}
			returnJedis(command);
			return len;
		}
		/**
		 * 在指定的key中追加value
		 * 
		 * @param byte[]
		 *            key
		 * @param byte[]
		 *            value
		 * @return long 追加后value的长度
		 * **/
		public long append(byte[] key, byte[] value) {
			long len ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				len = cluster.append(key, value);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				len = jedis.append(key, value);
			}
			returnJedis(command);
			return len;
		}
		/**
		 * 将key对应的value减去指定的值，只有value可以转为数字时该方法才可用
		 * 
		 * @param String
		 *            key
		 * @param long number 要减去的值
		 * @return long 减指定值后的值
		 * */
		public long decrBy(String key, long number) {
			long len ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				len = cluster.decrBy(key, number);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				len = jedis.decrBy(key, number);
			}
			returnJedis(command);
			return len;
		}
		/**
		 * 将key对应的value减去指定的值，只有value可以转为数字时该方法才可用
		 * 
		 * @param byte[]
		 *            key
		 * @param long number 要减去的值
		 * @return long 减指定值后的值
		 * */
		public long decrBy(byte[] key, long number) {
			long len ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				len = cluster.decrBy(key, number);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				len = jedis.decrBy(key, number);
			}
			returnJedis(command);
			return len;
		}
		/**
		 * <b>可以作为获取唯一id的方法</b><br/>
		 * 将key对应的value加上指定的值，只有value可以转为数字时该方法才可用
		 * 
		 * @param String
		 *            key
		 * @param long number 要相加的值
		 * @return long 相加后的值
		 * */
		public long incrBy(String key, long number) {
			long len;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				len = cluster.incrBy(key, number);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				len = jedis.incrBy(key, number);
			}
			returnJedis(command);
			return len;
		}
		/**
		 * <b>可以作为获取唯一id的方法</b><br/>
		 * 将key对应的value加上指定的值，只有value可以转为数字时该方法才可用
		 * 
		 * @param byte[]
		 *            key
		 * @param long number 要相加的值
		 * @return long 相加后的值
		 * */
		public long incrBy(byte[] key, long number) {
			long len;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				len = cluster.incrBy(key, number);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				len = jedis.incrBy(key, number);
			}
			returnJedis(command);
			return len;
		}
		/**
		 * 对指定key对应的value进行截取
		 * 
		 * @param String
		 *            key
		 * @param long startOffset 开始位置(包含)
		 * @param long endOffset 结束位置(包含)
		 * @return String 截取的值
		 * */
		public String getrange(String key, long startOffset, long endOffset) {
			String value ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				value = cluster.getrange(key, startOffset, endOffset);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				value = jedis.getrange(key, startOffset, endOffset);
			}
			returnJedis(command);
			return value;
		}
		/**
		 * 对指定key对应的value进行截取
		 * 
		 * @param byte[]
		 *            key
		 * @param long startOffset 开始位置(包含)
		 * @param long endOffset 结束位置(包含)
		 * @return byte[] 截取的值
		 * */
		public byte[] getrange(byte[] key, long startOffset, long endOffset) {
			byte[] value ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				value = cluster.getrange(key, startOffset, endOffset);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				value = jedis.getrange(key, startOffset, endOffset);
			}
			returnJedis(command);
			return value;
		}
		/**
		 * 获取并设置指定key对应的value<br/>
		 * 如果key存在返回之前的value,否则返回null
		 * 
		 * @param String
		 *            key
		 * @param String
		 *            value
		 * @return String 原始value或null
		 * */
		public String getSet(String key, String value) {
			String str ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				str = cluster.getSet(key, value);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				str = jedis.getSet(key, value);
			}
			returnJedis(command);
			return str;
		}
		/**
		 * 获取并设置指定key对应的value<br/>
		 * 如果key存在返回之前的value,否则返回null
		 * 
		 * @param byte[]
		 *            key
		 * @param byte[]
		 *            value
		 * @return byte[] 原始value或null
		 * */
		public byte[] getSet(byte[] key, byte[] value) {
			byte[] str ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				str = cluster.getSet(key, value);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				str = jedis.getSet(key, value);
			}
			returnJedis(command);
			return str;
		}
		/**
		 * 批量获取记录,如果指定的key不存在返回List的对应位置将是null
		 * 
		 * @param String
		 *            keys
		 * @return List<String> 值得集合
		 * */
		public List<String> mget(String... keys) {
			List<String> str ;
			
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				str = cluster.mget(keys);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				str = jedis.mget(keys);
			}
			returnJedis(command);
			return str;
		}
		/**
		 * 批量获取记录,如果指定的key不存在返回List的对应位置将是null
		 * 
		 * @param byte[]
		 *            keys
		 * @return List<byte[]> 值得集合
		 * */
		public List<byte[]> mget(byte[]... keys) {
			List<byte[]> str ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				str = cluster.mget(keys);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				str = jedis.mget(keys);
			}
			returnJedis(command);
			return str;
		}
		/**
		 * 批量存储记录
		 * 
		 * @param String
		 *            keysvalues 例:keysvalues="key1","value1","key2","value2";
		 * @return String 状态码
		 * */
		public String mset(String... keysvalues) {
			String str ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				str = cluster.mset(keysvalues);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				str = jedis.mset(keysvalues);
			}
			returnJedis(command);
			return str;
		}
		/**
		 * 批量存储记录
		 * 
		 * @param String
		 *            keysvalues 例:keysvalues="key1","value1","key2","value2";
		 * @return String 状态码
		 * */
		public String mset(byte[]... keysvalues) {
			String str ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				str = cluster.mset(keysvalues);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				str = jedis.mset(keysvalues);
			}
			returnJedis(command);
			return str;
		}
		/**
		 * 获取key对应的值的长度
		 * 
		 * @param String
		 *            key
		 * @return value值得长度
		 * */
		public long strlen(String key) {
			long len ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				len = cluster.strlen(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				len = jedis.strlen(key);
			}
			returnJedis(command);
			return len;
		}
		/**
		 * 获取key对应的值的长度
		 * 
		 * @param String
		 *            key
		 * @return value值得长度
		 * */
		public long strlen(byte[] key) {
			long len ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				len = cluster.strlen(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				len = jedis.strlen(key);
			}
			returnJedis(command);
			return len;
		}
	}

	// *******************************************Lists*******************************************//
	public class Lists {
		/**
		 * List长度
		 * 
		 * @param String
		 *            key
		 * @return 长度
		 * */
		public long llen(String key) {
			long count ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				count = cluster.llen(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				count = jedis.llen(key);
			}
			returnJedis(command);
			return count;
		}
		/**
		 * List长度
		 * 
		 * @param String
		 *            key
		 * @return 长度
		 * */
		public long llen(byte[] key) {
			long count ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				count = cluster.llen(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				count = jedis.llen(key);
			}
			returnJedis(command);
			return count;
		}

		/**
		 * 覆盖操作,将覆盖List中指定位置的值
		 * 
		 * @param byte[] key
		 * @param int index 位置
		 * @param byte[] value 值
		 * @return 状态码
		 * */
		public String lset(byte[] key, int index, byte[] value) {
			String status ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				status = cluster.lset(key, index, value);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				status = jedis.lset(key, index, value);
			}
			returnJedis(command);
			return status;
		}

		/**
		 * 覆盖操作,将覆盖List中指定位置的值
		 * 
		 * @param key
		 * @param int index 位置
		 * @param String
		 *            value 值
		 * @return 状态码
		 * */
		public String lset(String key, int index, String value) {
			String status ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				status = cluster.lset(key, index, value);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				status = jedis.lset(key, index, value);
			}
			returnJedis(command);
			return status;
		}

		/**
		 * 在value的相对位置插入记录
		 * 
		 * @param key
		 * @param LIST_POSITION
		 *            前面插入或后面插入
		 * @param String
		 *            pivot 相对位置的内容
		 * @param String
		 *            value 插入的内容
		 * @return 记录总数
		 * */
		public long linsert(String key, LIST_POSITION where, String pivot,
				String value) {
			long count;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				count = cluster.linsert(key, where, pivot, value);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				count = jedis.linsert(key, where, pivot, value);
			}
			returnJedis(command);
			return count;
		}

		/**
		 * 在指定位置插入记录
		 * 
		 * @param String
		 *            key
		 * @param LIST_POSITION
		 *            前面插入或后面插入
		 * @param byte[] pivot 相对位置的内容
		 * @param byte[] value 插入的内容
		 * @return 记录总数
		 * */
		public long linsert(byte[] key, LIST_POSITION where, byte[] pivot,
				byte[] value) {
			long count;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				count = cluster.linsert(key, where, pivot, value);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				count = jedis.linsert(key, where, pivot, value);
			}
			returnJedis(command);
			return count;
		}

		/**
		 * 获取List中指定位置的值
		 * 
		 * @param String
		 *            key
		 * @param int index 位置
		 * @return 值
		 * **/
		public String lindex(String key, int index) {
			String value ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				value = cluster.lindex(key, index);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				value = jedis.lindex(key, index);
			}
			returnJedis(command);
			return value;
		}

		/**
		 * 获取List中指定位置的值
		 * 
		 * @param byte[] key
		 * @param int index 位置
		 * @return 值
		 * **/
		public byte[] lindex(byte[] key, int index) {
			byte[] value ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				value = cluster.lindex(key, index);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				value = jedis.lindex(key, index);
			}
			returnJedis(command);
			return value;
		}

		/**
		 * 将List中的第一条记录移出List
		 * 
		 * @param String
		 *            key
		 * @return 移出的记录
		 * */
		public String lpop(String key) {
			String value ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				value = cluster.lpop(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				value = jedis.lpop(key);
			}
			returnJedis(command);
			return value;
		}

		/**
		 * 将List中的第一条记录移出List
		 * 
		 * @param byte[] key
		 * @return 移出的记录
		 * */
		public byte[] lpop(byte[] key) {
			byte[] value ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				value = cluster.lpop(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				value = jedis.lpop(key);
			}
			returnJedis(command);
			return value;
		}

		/**
		 * 将List中最后第一条记录移出List
		 * 
		 * @param String key
		 * @return 移出的记录
		 * */
		public String rpop(String key) {
			String value;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				value = cluster.rpop(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				value = jedis.rpop(key);
			}
			returnJedis(command);
			return value;
		}
		/**
		 * 将List中最后第一条记录移出List
		 * 
		 * @param byte[] key
		 * @return 移出的记录
		 * */
		public byte[] rpop(byte[] key) {
			byte[] value;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				value = cluster.rpop(key);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				value = jedis.rpop(key);
			}
			returnJedis(command);
			return value;
		}
		/**
		 * 向List尾部追加记录
		 * 
		 * @param String
		 *            key
		 * @param String
		 *            value
		 * @return 记录总数
		 * */
		public long lpush(String key, String value) {
			long count ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				count = cluster.lpush(key, value);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				count = jedis.lpush(key, value);
			}
			returnJedis(command);
			return count;
		}

		/**
		 * 向List头部追加记录
		 * 
		 * @param String
		 *            key
		 * @param String
		 *            value
		 * @return 记录总数
		 * */
		public long rpush(String key, String value) {
			long count ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				count = cluster.rpush(key, value);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				count = jedis.rpush(key, value);
			}
			returnJedis(command);
			return count;
		}

		/**
		 * 向List头部追加记录
		 * 
		 * @param String
		 *            key
		 * @param String
		 *            value
		 * @return 记录总数
		 * */
		public long rpush(byte[] key, byte[] value) {
			long count ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				count = cluster.rpush(key, value);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				count = jedis.rpush(key, value);
			}
			returnJedis(command);
			return count;
		}

		/**
		 * 向List中追加记录
		 * 
		 * @param byte[] key
		 * @param byte[] value
		 * @return 记录总数
		 * */
		public long lpush(byte[] key, byte[] value) {
			long count ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				count = cluster.lpush(key, value);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				count = jedis.lpush(key, value);
			}
			returnJedis(command);
			return count;
		}

		/**
		 * 获取指定范围的记录，可以做为分页使用
		 * 
		 * @param String
		 *            key
		 * @param long start
		 * @param long end
		 * @return List
		 * */
		public List<String> lrange(String key, long start, long end) {
			List<String> list ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				list = cluster.lrange(key, start, end);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				list = jedis.lrange(key, start, end);
			}
			returnJedis(command);
			return list;
		}

		/**
		 * 获取指定范围的记录，可以做为分页使用
		 * 
		 * @param byte[] key
		 * @param int start
		 * @param int end 如果为负数，则尾部开始计算
		 * @return List
		 * */
		public List<byte[]> lrange(byte[] key, int start, int end) {
			List<byte[]> list ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				list = cluster.lrange(key, start, end);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				list = jedis.lrange(key, start, end);
			}
			returnJedis(command);
			return list;
		}

		/**
		 * 删除List中c条记录，被删除的记录值为value
		 * 
		 * @param byte[] key
		 * @param int c 要删除的数量，如果为负数则从List的尾部检查并删除符合的记录
		 * @param byte[] value 要匹配的值
		 * @return 删除后的List中的记录数
		 * */
		public long lrem(byte[] key, int c, byte[] value) {
			long count ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				count = cluster.lrem(key, c, value);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				count = jedis.lrem(key, c, value);
			}
			returnJedis(command);
			return count;
		}

		/**
		 * 删除List中c条记录，被删除的记录值为value
		 * 
		 * @param String
		 *            key
		 * @param int c 要删除的数量，如果为负数则从List的尾部检查并删除符合的记录
		 * @param String
		 *            value 要匹配的值
		 * @return 删除后的List中的记录数
		 * */
		public long lrem(String key, int c, String value) {
			long count ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				count = cluster.lrem(key, c, value);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				count = jedis.lrem(key, c, value);
			}
			returnJedis(command);
			return count;
		}

		/**
		 * 算是删除吧，只保留start与end之间的记录
		 * 
		 * @param byte[] key
		 * @param int start 记录的开始位置(0表示第一条记录)
		 * @param int end 记录的结束位置（如果为-1则表示最后一个，-2，-3以此类推）
		 * @return 执行状态码
		 * */
		public String ltrim(byte[] key, int start, int end) {
			String str ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				str = cluster.ltrim(key, start, end);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				str = jedis.ltrim(key, start, end);
			}
			returnJedis(command);
			return str;
		}

		/**
		 * 算是删除吧，只保留start与end之间的记录
		 * 
		 * @param String
		 *            key
		 * @param int start 记录的开始位置(0表示第一条记录)
		 * @param int end 记录的结束位置（如果为-1则表示最后一个，-2，-3以此类推）
		 * @return 执行状态码
		 * */
		public String ltrim(String key, int start, int end) {
			String str ;
			Object command = getJedisCommands();
			//对JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(command.getClass())){
				JedisCluster cluster = (JedisCluster)command;
				str = cluster.ltrim(key, start, end);
			}
			//对Jedis操作类的处理
			else{
				Jedis jedis = (Jedis)command;
				str = jedis.ltrim(key, start, end);
			}
			returnJedis(command);
			return str;
		}
	}

	@Override
	public void setJsonPojo(String key, Object pojo) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> T getJsonPojo(String key, Class<T> Clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSerializePojo(String key, Object pojo, Integer seconds) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> T getSerializePojo(String key, Class<T> Clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> vagueQueryPojo(Class<T> clazz, String fieldName,
			JedisVagueQuyerEnum sfxieJedisVagueQuyerEnum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void hsetPojo(String key, Object pojo, String field, Long time) {
		// TODO Auto-generated method stub

	}

	@Override
	public void savePojo(JedisPersistentObject pojo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getPojo(JedisPersistentObject pojo) {
		// TODO Auto-generated method stub

	}

}