package com.sfxie.extension.mycat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.framework.recipes.cache.PathChildrenCache.StartMode;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.apache.curator.x.discovery.ServiceProvider;
import org.apache.curator.x.discovery.details.JsonInstanceSerializer;

import com.sfxie.extension.datasource.multydatasoure.zookeeper.ZookeeperDatasourceEntity;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class MycatDiscovery {
	
	private static  String     PATH = "/discovery/example";
	
	private static  String serviceName = "mycat";
	
	private static ServiceDiscovery<ZookeeperDatasourceEntity>               serviceDiscovery = null;
	private static List<MycatServer>     servers = Lists.newArrayList();
	
	public static void initDiscovery(CuratorFramework client,String path,String serviceName1) throws Exception{
        Map<String, ServiceProvider<ZookeeperDatasourceEntity>>   providers = Maps.newHashMap();
        try
        {
        	PATH = path;
        	serviceName = serviceName1;
            JsonInstanceSerializer<ZookeeperDatasourceEntity> serializer = new JsonInstanceSerializer<ZookeeperDatasourceEntity>(ZookeeperDatasourceEntity.class);
            serviceDiscovery = ServiceDiscoveryBuilder.builder(ZookeeperDatasourceEntity.class).client(client).basePath(PATH).serializer(serializer).build();
            serviceDiscovery.start();
//            watchChange(client);
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
	
	public static void addInstance(CuratorFramework client,ZookeeperDatasourceEntity zookeeperDatasourceEntity) throws Exception{
        MycatServer   server = new MycatServer(client, PATH, serviceName,zookeeperDatasourceEntity);
        servers.add(server);
        server.start();
        System.out.println(zookeeperDatasourceEntity.getUniqueResourceName() + " has started.");
        
    }
	
	public static List<ZookeeperDatasourceEntity> listInstances() throws Exception{
        // This shows how to query all the instances in service discovery
		List<ZookeeperDatasourceEntity>  list = new ArrayList<ZookeeperDatasourceEntity>();
        try
        {
            Collection<String>  serviceNames = serviceDiscovery.queryForNames();
            for ( String serviceName : serviceNames )
            {
                Collection<ServiceInstance<ZookeeperDatasourceEntity>> instances = serviceDiscovery.queryForInstances(serviceName);
                for ( ServiceInstance<ZookeeperDatasourceEntity> instance : instances )
                {
                	list.add(instance.getPayload());
                	System.out.println(instance.getPayload().getUniqueResourceName() + " has started.");
                }
            }
        }
        finally
        {
//            CloseableUtils.closeQuietly(serviceDiscovery);
        }
        return list;
    }
	public static void watchChange(CuratorFramework client){
		/**
         * 监听子节点的变化情况
         */
		final PathChildrenCache childrenCache = new PathChildrenCache(client,PATH+"/"+serviceName, true);
		childrenCache.getListenable().addListener(
				new PathChildrenCacheListener() {

					@Override
					public void childEvent(CuratorFramework client,
							PathChildrenCacheEvent event) throws Exception {
						switch (event.getType()) {
							case CHILD_ADDED:
								List<ZookeeperDatasourceEntity> list1 = listInstances();
								break;
							case CHILD_REMOVED:
								List<ZookeeperDatasourceEntity> list2 = listInstances();
								break;
							case CHILD_UPDATED:
								break;
							default:
								break;
						}
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
