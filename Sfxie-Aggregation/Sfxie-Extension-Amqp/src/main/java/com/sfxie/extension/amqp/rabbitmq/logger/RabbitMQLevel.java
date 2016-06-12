package com.sfxie.extension.amqp.rabbitmq.logger;

import org.apache.log4j.Level;


/**
 * 
 * @description 自定义RABBITMQ级别(INFO级别)，将日志信息推送到Rabbitmq服务器中.<br>
 * 				
 * 
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	上午13:19:39 2016年3月10日
 * @example		
 *
 */
public class RabbitMQLevel extends Level {
	
	private static final long serialVersionUID = 7288304330257085144L;

	/** 数字小的级别高 (日志打印的时候,级别低的打印输出一般会同时输出到级别高的日志文件上,但是可以通过配置 filter 来过滤不需要的级别打印)*/
	static private final int RABBITMQ_INT = Level.INFO_INT + 5; 		//20005
//	error:40000, info:20000 ,debug:10000 

	/**	RABBITMQ级别	*/
	private static String RABBITMQ_STR = "RABBITMQ";
	
	/**	rabbitmq级别	*/
	public static final RabbitMQLevel RABBITMQ = new RabbitMQLevel(RABBITMQ_INT, RABBITMQ_STR,15);

	protected RabbitMQLevel(int level, String strLevel, int syslogEquiv) {
		super(level, strLevel, syslogEquiv);
	}

	public static Level toLevel(String sArg) {
		return (Level) toLevel(sArg, RabbitMQLevel.RABBITMQ);
	}

	public static Level toLevel(String sArg, Level defaultValue) {
		if (sArg == null) {
			return defaultValue;
		}
		String stringVal = sArg.toUpperCase();
		
		if(stringVal.equals(RABBITMQ_STR)) {
			return RabbitMQLevel.RABBITMQ;
		}

		return Level.toLevel(sArg, (Level) defaultValue);
	}
	public static Level toLevel(int i) throws IllegalArgumentException {
		switch (i) {
			case RABBITMQ_INT:
				return RabbitMQLevel.RABBITMQ;
		}
		return Level.toLevel(i);
	}

}
