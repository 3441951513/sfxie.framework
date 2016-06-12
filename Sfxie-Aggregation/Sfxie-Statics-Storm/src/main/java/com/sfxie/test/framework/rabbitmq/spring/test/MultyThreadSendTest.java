package com.sfxie.test.framework.rabbitmq.spring.test;

import org.junit.Test;

import com.sfxie.base.MultyThreadCallback;
import com.sfxie.base.MultyThreadTest;
import com.sfxie.extension.amqp.rabbitmq.logger.MQLogger;

public class MultyThreadSendTest extends MultyThreadTest{
	
	@Test
	public void testPurchaseTypeController(){
		MultyThreadSendTest testRabbitmqSendPerfomer = new MultyThreadSendTest();
		testRabbitmqSendPerfomer.setCallback(new MultyThreadCallback(){
			@Override
			public void run() {
				MQLogger.log(MultyThreadSendTest.class, "测试发送数据压力");
			}
		});
		MultyThreadTest.startTime = System.currentTimeMillis();
		testRabbitmqSendPerfomer.setThreadCount(1);
		testRabbitmqSendPerfomer.setThreadRunCount(2);
		testRabbitmqSendPerfomer.multyThread();
		
		try {
			Thread.sleep(200000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
