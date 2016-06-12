package com.sfxie.extension.mycat;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.log4j.Logger;
import org.opencloudb.config.model.SystemConfig;

import com.sfxie.extension.datasource.multydatasoure.zookeeper.ZookeeperDatasourceEntity;

public class CuratorHandler {

	private static final Logger LOGGER = Logger.getLogger("MycatServer");
	
	private  CuratorFramework zkClient;
	
	public void zookeeperInit(){
		
		Properties properties = loadClusterProps();
		
		String zkConnectionString =  properties.getProperty("zkConnectionString");
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
		String zkPath = properties.getProperty("zkPath");
		String serviceName = properties.getProperty("serviceName");
		String url = (String) properties.get("url");
		String uniqueResourceName = properties.getProperty("uniqueResourceName");
		String userName = properties.getProperty("userName");
		String password = properties.getProperty("password");
//		String zookeeperPath = (String) properties.get("name");
//		String host = (String) properties.get("host");
//		int port = Integer.parseInt((String) properties.get("port"));
		ZookeeperDatasourceEntity zkEntity = new ZookeeperDatasourceEntity(uniqueResourceName,url,userName,password);
        zkClient = createWithOptions(zkConnectionString, retryPolicy, 2000, 10000);
        zkClient.start();
        try {
        	MycatDiscovery.initDiscovery(zkClient,zkPath,serviceName);
			MycatDiscovery.addInstance(zkClient,zkEntity);
//			if(null == zkClient.checkExists().forPath(zookeeperPath)){
//				zkClient.create().withMode(CreateMode.EPHEMERAL).forPath(zookeeperPath,hostAndPort.getBytes());
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	/**
     * 通过自定义参数创建
     */
    private CuratorFramework  createWithOptions(String connectionString, RetryPolicy retryPolicy, int connectionTimeoutMs, int sessionTimeoutMs)
    {
        return CuratorFrameworkFactory.builder()
                .connectString(connectionString)
                .retryPolicy(retryPolicy)
                .connectionTimeoutMs(connectionTimeoutMs)
                .sessionTimeoutMs(sessionTimeoutMs)
                .build();
    } 
	private Properties loadClusterProps() {
		Properties prop = new Properties();
		System.out.println(SystemConfig.getHomePath());
		File file = new File(SystemConfig.getHomePath(), "/conf"
				+ File.separator + "cluster.properties");
		if (!file.exists()) {
			return prop;
		}
		FileInputStream filein = null;
		try {
			filein = new FileInputStream(file);
			prop.load(filein);
		} catch (Exception e) {
			LOGGER.warn("load DataNodeIndex err:" + e);
		} finally {
			if (filein != null) {
				try {
					filein.close();
				} catch (IOException e) {
				}
			}
		}
		return prop;
	}
	
}
