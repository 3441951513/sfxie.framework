package com.sfxie.test.framework.rabbitmq.spring.test;

public class HelloWorldHandler {
	public static int count = 0;
	
	public static String  aa = "d";

	public void handleMessage(String text) {
		System.out.println("HelloWorldHandler Received "+HelloWorldHandler.count+": " + text);
		synchronized (aa) {
			count++;
		}
	}

}
