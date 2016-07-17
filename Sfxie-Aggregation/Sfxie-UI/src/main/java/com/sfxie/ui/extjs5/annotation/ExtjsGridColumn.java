package com.sfxie.ui.extjs5.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 用于定义表格列注解
 * @author XIESHENGFENG
 * 暂时没有用到
 */
@Retention (RetentionPolicy.RUNTIME)    
@Target (ElementType.METHOD)    
public @interface ExtjsGridColumn {
	//是否使列具有提示功能
	public enum Tip { 
		TRUE(true),FALSE(false);
		private final Boolean value;
		public Boolean getValue() {
            return value;
        }
	    //构造器默认也只能是private, 从而保证构造函数只能在内部使用
		Tip(Boolean value) {
			this.value = value;
	    }
	};
	public enum Flex { 
		zero(0),one(1),tow(2),three(3),four(4),five(5),six(6),seven(7),eight(8),nigh(9),fifteen(15),thirty(30);
		
		private int value;
		public int getValue() {
            return value;
        }
	    //构造器默认也只能是private, 从而保证构造函数只能在内部使用
		Flex(int value) {
			this.value = value;
	    }
	};
	/** 是否有提示功能 	*/
	Tip tip() default Tip.FALSE;
	/** 国际化字段名 		*/
	String fieldName();
//	String order();
	Flex flex() default Flex.zero;
	int order() default -1;
	
}
