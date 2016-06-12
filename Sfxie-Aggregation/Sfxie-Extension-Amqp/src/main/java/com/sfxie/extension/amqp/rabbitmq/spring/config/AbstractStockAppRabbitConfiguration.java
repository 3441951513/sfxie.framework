/*
 * Copyright 2002-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sfxie.extension.amqp.rabbitmq.spring.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Provides shared configuration between Client and Server.  
 * <p>The abstract method configureRabbitTemplate lets the Client and Server further customize
 * the rabbit template to their specific needs.
 * 
 * @author Mark Pollack
 * @author Mark Fisher
 */
@Configuration
public abstract class AbstractStockAppRabbitConfiguration {

	/**
	 * 配置连接信息
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	下午1:03:10 2016年3月11日
	 * @example
	 * @return	
	 *
	 */
	protected abstract ConnectionFactoryConfig configConnectionFactory();

	/**
	 * 配置rabbitTemplate
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	下午1:03:20 2016年3月11日
	 * @example
	 * @param template	
	 *
	 */
	protected abstract RabbitTemplateConfig  configureRabbitTemplate();

	@Bean
	public ConnectionFactory connectionFactory() {
		//TODO make it possible to customize in subclasses.
		ConnectionFactoryConfig config = configConnectionFactory();
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory(config.getHost());
		connectionFactory.setPort(config.getPort());
		connectionFactory.setUsername(config.getUsername());
		connectionFactory.setPassword(config.getPassword());
		return connectionFactory;
	}

	@Bean 
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate template = new RabbitTemplate(connectionFactory());
		template.setMessageConverter(jsonMessageConverter());
		RabbitTemplateConfig config = configureRabbitTemplate();
		template.setExchange(config.getExchangeName());
		template.setEncoding(config.getEncoding());
		return template;
	}

	@Bean
	public MessageConverter jsonMessageConverter() {
		return new JsonMessageConverter();
	}
	
	@Bean
	public TopicExchange topicExchange() {
		RabbitTemplateConfig config = configureRabbitTemplate();
		return new TopicExchange(config.getTopicExchangeName());
	}

	/**
	 * @return the admin bean that can declare queues etc.
	 */
	@Bean
	public AmqpAdmin amqpAdmin() {
		RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory());
		return rabbitAdmin ;
	}

}
