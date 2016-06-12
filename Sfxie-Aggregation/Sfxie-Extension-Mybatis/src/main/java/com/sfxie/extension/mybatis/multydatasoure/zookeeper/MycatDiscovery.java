package com.sfxie.extension.mybatis.multydatasoure.zookeeper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.framework.recipes.cache.PathChildrenCache.StartMode;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.apache.curator.x.discovery.details.JsonInstanceSerializer;


public class MycatDiscovery {
	
	private static final String     PATH = "/discovery/example";
	
	private static final String serviceName = "mycat";
	
	private static ServiceDiscovery<ZookeeperDatasourceEntity>               serviceDiscovery = null;
	
	public static void initDiscovery(CuratorFramework client,IZookeeperWatchChangeAction action) throws Exception{
        try
        {
//            client.start();
            JsonInstanceSerializer<ZookeeperDatasourceEntity> serializer = new JsonInstanceSerializer<ZookeeperDatasourceEntity>(ZookeeperDatasourceEntity.class);
            serviceDiscovery = ServiceDiscoveryBuilder.builder(ZookeeperDatasourceEntity.class).client(client).basePath(PATH).serializer(serializer).build();
            serviceDiscovery.start();
            watchChange(client,action);
        }
        finally
        {
           /* for ( ServiceProvider<ZookeeperDatasourceEntity> cache : providers.values() )
            {
                CloseableUtils.closeQuietly(cache);
            }

            CloseableUtils.closeQuietly(serviceDiscovery);
            CloseableUtils.closeQuietly(client);*/
        }
	}
	
	public static List<ZookeeperDatasourceEntity> listInstances() throws Exception{
        // This shows how to query all the instances in service discovery
		List<ZookeeperDatasourceEntity>  list = new ArrayList<ZookeeperDatasourceEntity>();
        try
        {
            Collection<String>  serviceNames = serviceDiscovery.queryForNames();
            System.out.println(serviceNames.size() + " type(s)");
            for ( String sName : serviceNames )
            {
            	if(sName.equals(serviceName)){
            		
            	}
                Collection<ServiceInstance<ZookeeperDatasourceEntity>> instances = serviceDiscovery.queryForInstances(serviceName);
                System.out.println(serviceName);
                for ( ServiceInstance<ZookeeperDatasourceEntity> instance : instances )
                {
                	list.add(instance.getPayload());
                	System.out.println(instance.getPayload().getUrl());
                }
            }
        }
        finally
        {
//            CloseableUtils.closeQuietly(serviceDiscovery);
        }
        return list;
    }
	public static void watchChange(CuratorFramework client,final IZookeeperWatchChangeAction action){
		/**
         * 监听子节点的变化情况
         */
		final PathChildrenCache childrenCache = new PathChildrenCache(client,PATH+"/"+serviceName, true);
		childrenCache.getListenable().addListener(
				new PathChildrenCacheListener() {

					@Override
					public void childEvent(CuratorFramework client,
							PathChildrenCacheEvent event) throws Exception {
						List<ZookeeperDatasourceEntity> list1 = listInstances();
						action.execute(event.getData().getPath(),event.getType(), list1);
					}
				});
        try {
            childrenCache.start(StartMode.POST_INITIALIZED_EVENT);
        } catch (Exception e) {
        	e.printStackTrace();
//            LoggerUtil.error("Start NodeCache error for path:"+PATH+"/"+serviceName+", error info: "+e.getMessage());
        }
	}
}
