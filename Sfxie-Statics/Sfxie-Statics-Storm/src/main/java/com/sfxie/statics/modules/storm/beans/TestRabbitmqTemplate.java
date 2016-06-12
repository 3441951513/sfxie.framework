package com.sfxie.statics.modules.storm.beans;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sfxie.extension.spring4.mvc.context.Context;

public class TestRabbitmqTemplate {
	protected static final Log logger = LogFactory.getLog(TestRabbitmqTemplate.class);
//	public static void main(String[] args) {
//		asynConsumer();
//	}
	public static ApplicationContext context = new AnnotationConfigApplicationContext(StaticsStormConfiguration.class);
	//异步消费
//	public static void asynConsumer(){
//		new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
//	}
	
	//同步消费
	public static Object synConsumer(){
//		AmqpTemplate amqpTemplate = context.getBean(AmqpTemplate.class);
		AmqpTemplate amqpTemplate =  Context.getSpringBean("rabbitTemplate");
//		Queue helloWorldQueue = (Queue) context.getBean("helloWorldQueue");
		Object obj = amqpTemplate.receiveAndConvert();
		logger.info(obj);
		return obj;
//		System.out.println("Received "+HelloWorldHandler.count+": " + amqpTemplate.receiveAndConvert());
//		System.out.println("Received: " + amqpTemplate.receiveAndConvert());
//		System.out.println("Received: " + amqpTemplate.receiveAndConvert());
//		amqpTemplate.convertAndSend("测试发送数据");
	}
}
