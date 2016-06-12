package com.sfxie.test.framework.rabbitmq.spring.test;

import org.springframework.amqp.rabbit.listener.AbstractMessageListenerContainer;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class SfxieMessageListenerContainer extends AbstractMessageListenerContainer implements ApplicationEventPublisherAware{

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher arg0) {
		
	}

	@Override
	protected void doInitialize() throws Exception {
		
	}

	@Override
	protected void doShutdown() {
		
	}

}
