package com.sfxie.extension.jedis.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisMovedDataException;

import com.sfxie.extension.jedis.query.JedisVagueQuyerEnum;
import com.sfxie.utils.DateHelper;
import com.sfxie.utils.LoggerUtil;
import com.sfxie.utils.jacson.codehaus.JsonUtil;

/**
 * redis集群客户端操作类
 * masterJedisMap成员变量只限于模糊查询
 * slaveJedisMap成员变量暂时还未用
 * @author xieshengfeng
 * @since 20150701
 *
 */
@SuppressWarnings("unchecked")
public class JedisClusterOperator extends AbstractJedisOperator{
	
	
	
	private static ThreadPoolExecutor threadPool;
	/** 集群单例	 */
	private static JedisCluster jedisCluster;
	/** 集群桶大小	*/
	private static int SLOTS = 16384;
	/**	集群所有主节点集合	*/
	private static Map<String,Jedis> masterJedisMap = new HashMap<String,Jedis> ();
	/**	集群所有从节点集合	*/
	private static Map<String,Jedis> slaveJedisMap = new HashMap<String,Jedis> ();
	/**	redis集群的其中一个插口地址,格式为:192.168.10.74:7000*/
	private String oneOfClusterIpAndPort;
	
	private JedisClusterOperator(){
	}
	
	@SuppressWarnings("unused")
	/**	初始化方法	*/
	private void init(){
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
	@Override
	public Object getJedisCommands(){
		return jedisCluster;
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
	
//	@Test
	public void testCalculateConnectionPerSlot() {
		jedisCluster.set("age", "11");
		String value = jedisCluster.get("age");
		System.out.println(value);
	}
	
//	@Test
	public void testHash(){
		
		jedisCluster.hset("ID001", "xsf1", "xsf11");
		jedisCluster.hset("ID001", "xsf2", "xsf21");
		
		Map<String, String> map = jedisCluster.hgetAll("ID001");
		System.out.println(map.toString());
	}
	
//	@Test
	public void testList(){
		/*GAdPlan plan = new GAdPlan();
		plan.setId(1L);
		plan.setName("看戏");
		plan.setCreateTime(new Date());*/
		/*for(int i=0;i<10000;i++){
			jc.lpush("plan"+i, JsonUtils.toJson(plan));
		}*/
//		jc.lpush("plan111", JsonUtils.toJson(plan));
//		Long planStr = jc.llen("plan111");
	}
	@Test
	public void testSavePojo(){
		/*GAdPlan plan = new GAdPlan();
		plan.setId(1L);
		plan.setName("看戏1");
		plan.setCreateTime(new Date());
		
		
		setSerializePojo(plan,"id",null);
		GAdPlan pojo = getSerializePojo(GAdPlan.class,"id",plan.getId());
		System.out.println(pojo.getName());
		
		
		setJsonPojo(plan,"name");
		plan.setName("看戏2");
		setJsonPojo(plan,"name");
		pojo = getJsonPojo(GAdPlan.class,"name",plan.getName());
		System.out.println(pojo.getName());
		
		plan.setName("看戏3");
		setJsonPojo(plan,"name");
		plan.setName("看戏4");
		setJsonPojo(plan,"name");*/
	}
	
	//测试模糊查询集群存储数据
	@Test
	public void testClusterVagueQuery(){
		/*Long start = System.currentTimeMillis();
		List<GAdPlan> list1 = vagueQueryPojo(GAdPlan.class,"name","看戏",JedisVagueQuyerEnum.RIGHT);
		LoggerUtil.instance(GoliveJedisCluster.class).debug("list1.size: "+list1.size());
		List<GAdPlan> list2 = vagueQueryPojo(GAdPlan.class,"name","4",JedisVagueQuyerEnum.BOTH);
		LoggerUtil.instance(GoliveJedisCluster.class).debug("list2.size: "+list2.size());
		LoggerUtil.instance(GoliveJedisCluster.class).debug("*******************************************testClusterVagueQuery****************************************");
		LoggerUtil.instance(GoliveJedisCluster.class).debug("consume time: "+(System.currentTimeMillis()-start));
		LoggerUtil.instance(GoliveJedisCluster.class).debug("*******************************************testClusterVagueQuery****************************************");*/
	}
	@Test
	public void testSort(){
		
	}
	
	/**
	 * 存储对象的序列化值
	 * xsf
	 * 2015年7月1日下午2:37:59
	 * TODO
	 * void
	 */
	@Override
	public void setSerializePojo(String fieldName,Object pojo, Integer seconds){
		/*String tempKey = pojo.getClass().getName()+"."+fieldName+":"+ReflectUtils.getFieldValue(fieldName, pojo);
		if(null==seconds){
			jc.set(tempKey.getBytes(), SerializeUtil.serialize(pojo));
		}else{ 
			jc.setex(tempKey.getBytes(), seconds, SerializeUtil.serialize(pojo));
		}*/
	}
	/**
	 * 获取序列化对象
	 * xsf
	 * 2015年7月1日下午2:38:18
	 * TODO
	 * Object
	 */
	@Override
	public <T> T getSerializePojo(String key ,Class<T> Clazz){
		return null;
		/*byte[] pojo = jc.get((Clazz.getName()+"."+fieldName+":"+keyValue).getBytes());
		return (T) SerializeUtil.unserialize(pojo);*/
	}
	
	/**
	 * 从集群中模糊查询所有符合条件的结果
	 * xsf
	 * 2015年7月1日下午4:06:21
	 * TODO
	 * List<T>
	 */
	@Override
	public <T> List<T> vagueQueryPojo(Class<T> clazz ,String key ,JedisVagueQuyerEnum sfxieJedisVagueQuyerEnum){
		LoggerUtil.instance(JedisClusterOperator.class).info("vagueQueryPojo : parameter["+key+"]");
		String searchKey ;
		if(sfxieJedisVagueQuyerEnum.getValue()==2){
			searchKey = "*"+key+"*";
		}else{
			searchKey = (sfxieJedisVagueQuyerEnum.getValue()==0?"*":"")+key+(sfxieJedisVagueQuyerEnum.getValue()==1?"*":"");
		}	
		LoggerUtil.instance(JedisClusterOperator.class).info("vagueQueryPojo : searchKey["+searchKey+"]");
		List<T> result = new ArrayList<T>();
		//设置此次查询启动的线程总数
		CountDownLatch mergeSignal = new CountDownLatch(masterJedisMap.size());
		for(String jedisKey : masterJedisMap.keySet()){
			JedisClusterMasterTask<T> JedisClusterMasterTask = new JedisClusterMasterTask<T>(jedisKey,searchKey,clazz,result,mergeSignal);
			threadPool.execute(JedisClusterMasterTask);
		}
		try {
			//等待所有启动的线程执行结束
			mergeSignal.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		LoggerUtil.instance(JedisClusterOperator.class).info("vagueQueryPojo : list.size["+result.size()+"]");
		return result;
	}
	@Override
	public void hsetPojo(String key, Object pojo, String field, Long time) {
		// TODO Auto-generated method stub
		
	}
	
	
	public String getOneOfClusterIpAndPort() {
		return oneOfClusterIpAndPort;
	}

	public void setOneOfClusterIpAndPort(String oneOfClusterIpAndPort) {
		this.oneOfClusterIpAndPort = oneOfClusterIpAndPort;
	}


	/**
	 * 主节点模糊查询数据任务
	 * @author xsf
	 *
	 * @param <T>
	 */
	static class JedisClusterMasterTask<T> implements Runnable {
		/**	jedis主机ip地址	*/
		private String jedisKey;
		/**	查询条件字符串	*/
		private String searchKey;
		/** 结果类型	*/
		private Class<?> clazz;
		/**	结果集合	*/
		private List<T> result;
		
		private CountDownLatch mergeSignal;
		
		public JedisClusterMasterTask(String jedisKey,String searchKey,Class<?> clazz,List<T> result,CountDownLatch mergeSignal){
			this.jedisKey = jedisKey;
			this.searchKey = searchKey;
			this.clazz = clazz;
			this.mergeSignal = mergeSignal;
			this.result = result;
		}

		public void run() {
//			System.out.println(Thread.currentThread());
			boolean endFlag = false;
			while(!endFlag){
				try{
					Jedis jedis = masterJedisMap.get(jedisKey);
					Set<String> sets = new HashSet<String>();
					Set<String> setsT = jedis.keys(searchKey);
					for(String keddy : setsT){
						sets.add(jedis.get(keddy));
					}
					for(String p : sets){
						result.add((T) JsonUtil.fromJSON(p,clazz));
					}
					endFlag = true;
					if(null!=mergeSignal)
						mergeSignal.countDown();
				}catch(Exception e){
				}
			}
		}
	}

}

/*


通过监视线程池中结果：

package com.journaldev.threadpool;

import java.util.concurrent.ThreadPoolExecutor;

public class MyMonitorThread implements Runnable
{
    private ThreadPoolExecutor executor;

    private int seconds;

    private boolean run=true;

    public MyMonitorThread(ThreadPoolExecutor executor, int delay)
    {
        this.executor = executor;
        this.seconds=delay;
    }

    public void shutdown(){
        this.run=false;
    }

    @Override
    public void run()
    {
        while(run){
                System.out.println(
                    String.format('[monitor] [%d/%d] Active: %d, Completed: %d, Task: %d, isShutdown: %s, isTerminated: %s',
                        this.executor.getPoolSize(),
                        this.executor.getCorePoolSize(),
                        this.executor.getActiveCount(),
                        this.executor.getCompletedTaskCount(),
                        this.executor.getTaskCount(),
                        this.executor.isShutdown(),
                        this.executor.isTerminated()));
                try {
                    Thread.sleep(seconds*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }

    }
}*/