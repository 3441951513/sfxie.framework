package com.sfxie.extension.mybatis.multydatasoure.zookeeper;

import java.util.List;

import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent.Type;

public interface IZookeeperWatchChangeAction {

	public void execute(String path,Type eventType,List<ZookeeperDatasourceEntity> list1) throws Exception;
}
