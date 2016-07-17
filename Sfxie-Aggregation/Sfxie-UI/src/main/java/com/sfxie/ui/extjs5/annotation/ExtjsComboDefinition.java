package com.sfxie.ui.extjs5.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于组合框定义注解
 * @author XIESHENGFENG
 *
 */
@Retention (RetentionPolicy.RUNTIME)    
@Target ({ElementType.METHOD,ElementType.TYPE})    
public @interface ExtjsComboDefinition {
	/** 组合框的类型 		*/
	ComboType comboType();
	/** 关联的组合框名称	 */
	Class<?> comboName();
	/** 是否为多标题 */
	boolean isMultyTitle() default false;
	
	
	public enum ComboType { 
		combo("combo"),combogrid_Tree("combogrid_Tree"),combotree("combotree");
		private final String value;
		public String getValue() {
            return value;
        }
	    //构造器默认也只能是private, 从而保证构造函数只能在内部使用
		ComboType(String value) {
			this.value = value;
	    }
	};
}
