package com.sfxie.test.business.api3.mongodb;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.sfxie.base.BaseTest;
import com.sfxie.website.modules.api3.common.mongodb.pojo.MongodbAnnotationTestPojo;

public class MongodbAnnotationPojoTest extends BaseTest{

	@Test
	public void testInsertPojo(){
		getMongoTemplate().save(getMongodbAnnotationTestPojo());
	}
//	@Test
	public void testGetPojo(){
		List<MongodbAnnotationTestPojo> list = getMongoTemplate().findAll(MongodbAnnotationTestPojo.class);
		System.out.println(list.size());
	}
	private MongodbAnnotationTestPojo getMongodbAnnotationTestPojo(){
		MongodbAnnotationTestPojo mongodbAnnotationTestPojo = new MongodbAnnotationTestPojo();
		mongodbAnnotationTestPojo.setAge(12);
		mongodbAnnotationTestPojo.setName("谢声锋");
		mongodbAnnotationTestPojo.setDate(new Date());
		mongodbAnnotationTestPojo.setIndex1("index1");
		mongodbAnnotationTestPojo.setIndex2("20150112");
		mongodbAnnotationTestPojo.setTime(System.currentTimeMillis());
		mongodbAnnotationTestPojo.setTransientField("ddd");
		return mongodbAnnotationTestPojo;
	}
	
	private MongoTemplate getMongoTemplate(){
//		PartitionMongoTemplate mongoTemplate = (PartitionMongoTemplate) getBeanByName("mongoTemplate");
		MongoTemplate mongoTemplate = (MongoTemplate) getBeanByName("mongoTemplate");
		return mongoTemplate;
	}
}
