package com.sfxie.test.framework.rabbitmq.spring.test;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestRabbitmqTemplate {
	public static void main(String[] args) {
		asynConsumer();
	}
	//异步消费
	public static void asynConsumer(){
		new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
	}
	
	//同步消费
	public static void synConsumer(){
		ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
//		AmqpTemplate amqpTemplate = context.getBean(AmqpTemplate.class);
		AmqpTemplate amqpTemplate = (AmqpTemplate) context.getBean("rabbitTemplate");
//		AbstractMessageListenerContainer
		Queue helloWorldQueue = (Queue) context.getBean("helloWorldQueue");
		amqpTemplate.receiveAndConvert();
//		System.out.println("Received "+HelloWorldHandler.count+": " + amqpTemplate.receiveAndConvert());
//		System.out.println("Received: " + amqpTemplate.receiveAndConvert());
//		System.out.println("Received: " + amqpTemplate.receiveAndConvert());
//		amqpTemplate.convertAndSend("测试发送数据");
	}
}
