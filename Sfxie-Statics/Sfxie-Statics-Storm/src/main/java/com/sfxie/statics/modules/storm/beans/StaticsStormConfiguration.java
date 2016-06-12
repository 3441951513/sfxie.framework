package com.sfxie.statics.modules.storm.beans;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:config/extension/spring/xml/applicationContext.xml") 
public class StaticsStormConfiguration {

	protected final String helloWorldQueueName = "app.log4j.demo";

	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory("192.168.10.86");
		connectionFactory.setUsername("guest");
		connectionFactory.setPassword("guest");
		// 关键所在，指定线程池  
		ExecutorService service = Executors.newFixedThreadPool(200);  
		connectionFactory.setExecutor(service);
//		connectionFactory.setAutomaticRecoveryEnabled(true);  
//		connectionFactory.setRequestedHeartbeat(60);  
		return connectionFactory;
	}
	
	@Bean
	public AmqpAdmin amqpAdmin() {
		return new RabbitAdmin(connectionFactory());
	}

	@Bean
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate template = new RabbitTemplate(connectionFactory());
		//The routing key is set to the name of the queue by the broker for the default exchange.
		template.setRoutingKey("#.RABBITMQ");
		//Where we will synchronously receive messages from
		template.setQueue(this.helloWorldQueueName);
		return template;
	}

//	@Bean
//	 Every queue is bound to the default direct exchange
//	public Queue helloWorldQueue() {
//		return new Queue(this.helloWorldQueueName);
//	}

	/*
	@Bean 
	public Binding binding() {
		return declare(new Binding(helloWorldQueue(), defaultDirectExchange()));
	}*/
	
	/*	
	@Bean
	public TopicExchange helloExchange() {
		return declare(new TopicExchange("hello.world.exchange"));
	}*/
	
	/*
	public Queue declareUniqueQueue(String namePrefix) {
		Queue queue = new Queue(namePrefix + "-" + UUID.randomUUID());
		rabbitAdminTemplate().declareQueue(queue);
		return queue;
	}
	
	// if the default exchange isn't configured to your liking....
	@Bean Binding declareP2PBinding(Queue queue, DirectExchange exchange) {
		return declare(new Binding(queue, exchange, queue.getName()));
	}
	
	@Bean Binding declarePubSubBinding(String queuePrefix, FanoutExchange exchange) {
		return declare(new Binding(declareUniqueQueue(queuePrefix), exchange));
	}
	
	@Bean Binding declarePubSubBinding(UniqueQueue uniqueQueue, TopicExchange exchange) {
		return declare(new Binding(uniqueQueue, exchange));
	}
	
	@Bean Binding declarePubSubBinding(String queuePrefix, TopicExchange exchange, String routingKey) {
		return declare(new Binding(declareUniqueQueue(queuePrefix), exchange, routingKey));
	}*/

}
