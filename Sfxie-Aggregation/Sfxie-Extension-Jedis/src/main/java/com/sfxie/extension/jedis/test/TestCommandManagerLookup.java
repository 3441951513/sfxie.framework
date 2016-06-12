package com.sfxie.extension.jedis.test;

import org.junit.Before;  
import org.junit.Test;  
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sfxie.extension.jedis.test.beans.ScopeTestBean;
  
public class TestCommandManagerLookup {  
	
    private static AnnotationConfigApplicationContext ctx;  
  
    @Before  
    public void setUp() throws Exception {  
    	ctx = new AnnotationConfigApplicationContext();
    	ctx.scan("com.sfxie.extension.jedis.test.beans");
    	ctx.refresh();
    }  
  
    @Test  
    public void testProcess() {  
    	ScopeTestBean acopeTestBean = ctx.getBean(ScopeTestBean.class);
    	acopeTestBean.printDate();
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	acopeTestBean = ctx.getBean(ScopeTestBean.class);
    	acopeTestBean.printDate();
    }  
}  
