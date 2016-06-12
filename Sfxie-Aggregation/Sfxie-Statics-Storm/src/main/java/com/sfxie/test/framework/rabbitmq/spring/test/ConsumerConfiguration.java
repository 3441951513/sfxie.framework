package com.sfxie.test.framework.rabbitmq.spring.test;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerConfiguration extends HelloWorldConfiguration {

	@Bean
	public SimpleMessageListenerContainer listenerContainer() {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory());
		container.setQueueNames(this.helloWorldQueueName);
//		container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
		container.setMessageListener(new MessageListenerAdapter(new HelloWorldHandler()));
		return container;
	}

}
