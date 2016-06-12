package com.sfxie.extension.mycat;

import java.io.Closeable;
import java.io.IOException;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.utils.CloseableUtils;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.apache.curator.x.discovery.details.JsonInstanceSerializer;

import com.sfxie.extension.datasource.multydatasoure.zookeeper.ZookeeperDatasourceEntity;


public class MycatServer  implements Closeable {
	     private final ServiceDiscovery<ZookeeperDatasourceEntity> serviceDiscovery;
	     private final ServiceInstance<ZookeeperDatasourceEntity> thisInstance;

	     public MycatServer(CuratorFramework client, String path, String serviceName,ZookeeperDatasourceEntity zookeeperDatasourceEntity) throws Exception
	     {
	         // in a real application, you'd have a convention of some kind for the URI layout
//	         UriSpec     uriSpec = new UriSpec("{scheme}://foo.com:{port}");

	         thisInstance = ServiceInstance.<ZookeeperDatasourceEntity>builder()
	             .name(serviceName)
	             .payload(zookeeperDatasourceEntity)
//	             .port((int)(65535 * Math.random())) // in a real application, you'd use a common port
//	             .uriSpec(uriSpec)
	             .build();
	         // if you mark your payload class with @JsonRootName the provided JsonInstanceSerializer will work
	         JsonInstanceSerializer<ZookeeperDatasourceEntity> serializer = new JsonInstanceSerializer<ZookeeperDatasourceEntity>(ZookeeperDatasourceEntity.class);

	         serviceDiscovery = ServiceDiscoveryBuilder.builder(ZookeeperDatasourceEntity.class)
	             .client(client)
	             .basePath(path)
	             .serializer(serializer)
	             .thisInstance(thisInstance)
	             .build();
	     }

	     public ServiceInstance<ZookeeperDatasourceEntity> getThisInstance()
	     {
	         return thisInstance;
	     }

	     public void start() throws Exception
	     {
	         serviceDiscovery.start();
	     }

	     @Override
	     public void close() throws IOException
	     {
	         CloseableUtils.closeQuietly(serviceDiscovery);
	     }
}
