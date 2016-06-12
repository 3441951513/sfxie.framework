package com.sfxie.extension.amqp.rabbitmq.spring.config;

public class RabbitTemplateConfig {

	private String exchangeName;
	
	private String encoding;
	
	private String topicExchangeName;

	public String getExchangeName() {
		return exchangeName;
	}

	public void setExchangeName(String exchangeName) {
		this.exchangeName = exchangeName;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public String getTopicExchangeName() {
		return topicExchangeName;
	}

	public void setTopicExchangeName(String topicExchangeName) {
		this.topicExchangeName = topicExchangeName;
	}
	
	
	
}
