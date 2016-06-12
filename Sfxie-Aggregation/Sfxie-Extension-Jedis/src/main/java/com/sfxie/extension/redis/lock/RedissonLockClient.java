package com.sfxie.extension.redis.lock;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.redisson.Config;
import org.redisson.Redisson;
import org.redisson.connection.RandomLoadBalancer;
import org.redisson.core.RAtomicLong;
import org.redisson.core.RBucket;
import org.redisson.core.RLock;
import org.redisson.core.RMap;


/**
 *分布式锁客户端
 * @author 
 *
 */
public class RedissonLockClient {

		private static RedissonLockClient instance;
		private RedissonLockClient(String filename) throws FileNotFoundException, IOException{
			init(filename);
	 	}
		public static synchronized RedissonLockClient getInstance(String filename){
			if(instance==null){
				try {
					 instance=new  RedissonLockClient(filename);
				 } catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
	  				e.printStackTrace();
				} catch (IOException e) {
					 // TODO Auto-generated catch block
					 e.printStackTrace();
				}
	 		}
	 		return instance;	
		 }
		 public static void main(String[] args){
			RedissonLockClient client= RedissonLockClient.getInstance("resources/redis.properties");
	 		Redisson redisson=client.getSingleClient("ip:6379");
			/*
			RMap<String, String> map = redisson.getMap("anyMap");
			String prevObject = map.put("123", new String());
			String currentObject = map.putIfAbsent("323", new String());
			String obj = map.remove("123");

			map.fastPut("321", new String());
			map.fastRemove("321");

			Future<String> putAsyncFuture = map.putAsync("321");
			Future<Void> fastPutAsyncFuture = map.fastPutAsync("321");

			map.fastPutAsync("321", new String());
			map.fastRemoveAsync("321");
			redisson.shutdown();
			*/
			
			/**
			 * Distributed Object storage example
			 * Redisson redisson = Redisson.create();

				RBucket<AnyObject> bucket = redisson.getBucket("anyObject");
				bucket.set(new AnyObject());
				bucket.setAsync(new AnyObject());
				AnyObject obj = bucket.get();
				
				redisson.shutdown();
			 */
			
			/**Distributed Set example
			 Redisson redisson = Redisson.create();

	 		RSet<SomeObject> set = redisson.getSet("anySet");
			set.add(new SomeObject());
			set.remove(new SomeObject());

			set.addAsync(new SomeObject());

			redisson.shutdown();
			**/
	                final RAtomicLong atomicLong = redisson.getAtomicLong("anyAtomicLong");
			//atomicLong.set(1000);//初始化余量为1000，可以通过redis linux客户端设置1000
			for(int i=0;i<2000;i++){//开始扣减余量，每次扣1.共计扣2000次。
				new Runnable(){
		
					@Override
					public void run() {
						
						try {
							Thread.currentThread().sleep(5);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						if(atomicLong.get()==0) {//当余量为0时，系统提示余量不够并退出
							System.out.println(" error less than 0");
							return ;
						}
						long r=atomicLong.decrementAndGet();
						System.out.println("get "+r);
						
					}
					
				}.run();;
		    }
			
		
		}
		private static Redisson redisson=null;
		public Redisson  getClient(){
			return  redisson;
		}
		public  void  init(String filename) throws FileNotFoundException, IOException
		{
			//RedissonLockClient client=new RedissonLockClient();
			PropertyReader propReader=PropertyReader.getInstance(filename);
			Properties props=propReader.getProperties(filename);
			String masterName=props.getProperty("redis.masterName");
			String masteAddress=props.getProperty("redis.masteAddress");
			int deployment_model=Integer.valueOf(props.getProperty("redis.deploymentModel")).intValue();
			String hosts=props.getProperty("redis.hosts");
			//redis部署模式 SingleHost 1 MasterSlave 2 Sentinel 3  Cluster 4 
			switch(deployment_model){
				case 1:
					redisson=getSingleClient(hosts);//单机
					break;
				case 2:
					redisson=getMasterSlaveClient(masteAddress,hosts);
					break;
				case 3:
					redisson=getSentinelClient(masterName,hosts);
					break;
				case 4:
					redisson=getClusterClient(hosts);
					break;
			}
			
		}
		public Redisson getSingleClient(String host){
			//Single server connection:
			// connects to default Redis server 127.0.0.1:6379
			//edisson redisson = Redisson.create();
			
			// connects to single Redis server via Config
			Config config = new Config();
			    config.useSingleServer()
			          .setAddress(host)
			          .setConnectionPoolSize(1000)
			          ;

			Redisson redisson = Redisson.create(config);
			return redisson;
		}
		//Master/Slave servers connection:
		public Redisson getMasterSlaveClient(String add,String hosts){
			Config config = new Config();
			String[] hostarr=hosts.split(",");
			config.useMasterSlaveConnection()
			    .setMasterAddress(add)
			    .setLoadBalancer(new RandomLoadBalancer()) // RoundRobinLoadBalancer used by default
			   
			    .addSlaveAddress(hostarr)
			    .setMasterConnectionPoolSize(10000)
			    .setSlaveConnectionPoolSize(10000);

			Redisson redisson = Redisson.create(config);
			return redisson;
		}
		//Sentinel servers connection:
		public Redisson getSentinelClient(String masterName,String hosts){
			String[] hostarr=hosts.split(",");
			Config config = new Config();
			config.useSentinelConnection()
			    .setMasterName(masterName)
			    .addSentinelAddress(hostarr)
			    .setMasterConnectionPoolSize(10000)
			    .setSlaveConnectionPoolSize(10000);

			Redisson redisson = Redisson.create(config);
			return redisson;
		}
		//Cluster nodes connections:
		public Redisson getClusterClient(String hosts){
			Config config = new Config();
			config.useClusterServers()
			    .setScanInterval(2000) // sets cluster state scan interval
			    .addNodeAddress("127.0.0.1:7000", "127.0.0.1:7001")
			    .setMasterConnectionPoolSize(10000)
			    .setSlaveConnectionPoolSize(10000);

			Redisson redisson = Redisson.create(config);
			return redisson;
		}
		
		/**
		 * 扣取现金账本
		 * @param actid  账户id
		  * @return
		  * @throws FileNotFoundException
		 * @throws IOException
		  * @throws InterruptedException 
		 */
		private boolean deductCashAccount(String actid,int amount) throws FileNotFoundException, IOException, InterruptedException{
			/**扣余额直接操作redis缓存数据库，key由账户ID，-字符，字符串balance组成*/
			 long start=System.currentTimeMillis();
			 if(redisson==null) {
				 logger.error("Redisson is NULL");
				 return false;
			}
			String key="CASH_"+actid;
			String lock_point="LOCK_CASH_"+actid;
			RLock lock=redisson.getLock(lock_point);//获取账户锁对象
			logger.info("get lock "+lock_point);
			boolean locked=lock.tryLock(10,60, TimeUnit.SECONDS);//尝试锁住账户对象,waitTime第一个参数获取锁超时时间30毫秒,leaseTime第二参数,锁自动释放时间
			if(!locked) {
				logger.info("cann't get lock ,id="+actid);
				return false;
			}
			//lock.lock();
			logger.info("get lock "+lock_point+" ok");
			RBucket<Integer> atomicbalance = redisson.getBucket(key);//获取原子余量
			boolean result_flag=true;
			if(atomicbalance.get()==0) {
				logger.error(" error ,balance less than  or equal to 0");
				
				result_flag=false;
			}
			else{
				atomicbalance.set(atomicbalance.get().intValue()-amount);//扣除余量
				logger.info("balance is  "+atomicbalance.get());
				result_flag=true;
			}
			lock.unlock();//解锁
			 logger.info("debut cash , cost time:"+(System.currentTimeMillis()-start));
			return result_flag;
		}
}
