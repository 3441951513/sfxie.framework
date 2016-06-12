package com.sfxie.extension.redis.redisson;

import java.util.List;

import org.redisson.ClusterServersConfig;
import org.redisson.Config;
import org.redisson.MasterSlaveServersConfig;
import org.redisson.MyRedisson;
import org.redisson.SentinelServersConfig;
import org.redisson.connection.RandomLoadBalancer;

/**
 * redis的Redisson客户端管理类<br>
  <p>
 		Redisson有四种模式:单节点模式/集群模式/主从节点模式/哨兵模式<br>
 		这四种模式分别对应着redis的单节点服务模式/集群服务模式/主从节点服务模式/哨兵服务模式
  </p>
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午3:05:14 2015-8-13
 * @example		
   <p>
 		集群模式配置如下:<br>
 		<code>
 			<bean class="com.sfxie.extension.redisson.RedissonManager" init-method="createRedisson">
		    	<property name="serverType" value="Cluster"/>
		    	<property name="addressList">
		    		<list>
		    			<value>192.168.10.74:7000</value>
		    		</list>
		    	</property>
		    </bean>
 		</code>
 		<br>
 		单节点模式配置如下:<br>
 		<code>
 			<bean class="com.sfxie.extension.redisson.RedissonManager" init-method="createRedisson">
		    	<property name="serverType" value="Single"/>
		    	<property name="addressList">
		    		<list>
		    			<value>192.168.10.74:7000</value>
		    		</list>
		    	</property>
		    </bean>
 		</code>
 		<br>
 		主从节点模式配置如下:<br>
 		<code>
 			<bean class="com.sfxie.extension.redisson.RedissonManager" init-method="createRedisson">
		    	<property name="serverType" value="Master/Slave"/>
		    	<property name="masterAddress" value="192.168.10.74:7000"/>
		    	<property name="addressList">
		    		<list>
		    			<value>192.168.10.74:7001</value>
		    			<value>192.168.10.74:7002</value>
		    		</list>
		    	</property>
		    </bean>
 		</code>
 		<br>
 		哨兵模式配置如下:<br>
 		<code>
 			<bean class="com.sfxie.extension.redisson.RedissonManager" init-method="createRedisson">
		    	<property name="serverType" value="Sentinel"/>
		    	<property name="masterName" value="server3-master"/>
		    	<property name="addressList">
		    		<list>
		    			<value>192.168.10.74:7000</value>
		    			<value>192.168.10.74:7001</value>
		    			<value>192.168.10.74:7002</value>
		    		</list>
		    	</property>
		    </bean>
 		</code>
 		<br>
  </p>
 *
 */
public class RedissonManager {

	private MyRedisson redisson;
	/**	地址列表(主从模式的从节点列表,Sentinel模式的所有Sentinel地址,集群模式的所有节点-集群模式可以只配置一个节点)	*/
	private List<String> addressList;
	/**	redis服务类型	*/
	private String serverType;
	/**	主从节点中的主节点套接字(地址)	*/
	private String masterAddress;
	/**	哨兵模式的master-name*/
	private String masterName;

	/**
	 * 初始化方法
	 * @TODO	
	 * @author 	xieshengfeng
	 * @since 	下午3:05:53 2015-8-13	
	 *
	 */
	private void createRedisson() {
		if(null==serverType || serverType.equals("Single")){
			initSingleServer();
		}else if(serverType.equals("Cluster")){
			initCluster();
		}else if(serverType.equals("Master/Slave")){
			initMasterSlave();
		}else if(serverType.equals("Sentinel")){
			initSentinel();
		}
	}

	/***
	 * 单节点模式
	 * @TODO	
	 * @author 	xieshengfeng
	 * @since 	下午5:22:59 2015-8-7	
	 *  
	 */
	private void initSingleServer(){
		String hostUrl = addressList.get(0);
		Config config = new Config();
		config.useSingleServer().setAddress(hostUrl);
		redisson = MyRedisson.create(config);
	}
	/**
	 * 集群模式
	 * @TODO	
	 * @author 	xieshengfeng
	 * @since 	下午5:26:06 2015-8-7	
	 *
	 */
	private void initCluster(){
		Config config = new Config();
		ClusterServersConfig serversConfig = config.useClusterServers().setScanInterval(2000); // sets cluster state scan interval
		serversConfig.addNodeAddress(addressList.toArray(new String[]{}));
		redisson = MyRedisson.create(config);
	}
	/**
	 * 主从节点模式
	 * @TODO	
	 * @author 	xieshengfeng
	 * @since 	下午5:25:29 2015-8-7	
	 *
	 */
	private void initMasterSlave(){
		Config config = new Config();
		MasterSlaveServersConfig  serversConfig  = config.useMasterSlaveConnection()
		    .setMasterAddress(masterAddress)
		    .setLoadBalancer(new RandomLoadBalancer()); // RoundRobinLoadBalancer used by default
		serversConfig .addSlaveAddress(addressList.toArray(new String[]{}));

		redisson = MyRedisson.create(config);
	}
	/**
	 * 哨兵模式
	 * @TODO	
	 * @author 	xieshengfeng
	 * @since 	下午5:26:44 2015-8-7	
	 *
	 */
	private void initSentinel(){
		Config config = new Config();
		SentinelServersConfig serversConfig = config.useSentinelConnection().setMasterName(masterName);
		serversConfig.addSentinelAddress(addressList.toArray(new String[]{}));
		redisson = MyRedisson.create(config);
	}
	public MyRedisson getRedisson() {
		return redisson;
	}


	public void setRedisson(MyRedisson redisson) {
		this.redisson = redisson;
	}


	public List<String> getAddressList() {
		return addressList;
	}


	public void setAddressList(List<String> addressList) {
		this.addressList = addressList;
	}

	public String getMasterAddress() {
		return masterAddress;
	}

	public void setMasterAddress(String masterAddress) {
		this.masterAddress = masterAddress;
	}

	public String getServerType() {
		return serverType;
	}

	public void setServerType(String serverType) {
		this.serverType = serverType;
	}

	public String getMasterName() {
		return masterName;
	}

	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}
	
	
}
