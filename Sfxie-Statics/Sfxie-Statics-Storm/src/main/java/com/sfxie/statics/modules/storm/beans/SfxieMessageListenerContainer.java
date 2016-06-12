package com.sfxie.statics.modules.storm.beans;

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
