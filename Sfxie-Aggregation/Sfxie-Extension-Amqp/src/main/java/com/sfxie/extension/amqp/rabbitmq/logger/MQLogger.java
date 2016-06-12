package com.sfxie.extension.amqp.rabbitmq.logger;

import com.sfxie.extension.logger.SystemLogger;

/**
 * MQ logger
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午2:09:50 2016年3月10日
 * @example		
 *
 */
public class MQLogger {
	/**
	 * 记录日志
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	下午2:10:03 2016年3月10日
	 * @example
	 * @param curentClass
	 * @param info	
	 *
	 */
	public static void log(Class<?> curentClass,Object info){
		try{
			SystemLogger.instance(curentClass).log(RabbitMQLevel.RABBITMQ, info);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
