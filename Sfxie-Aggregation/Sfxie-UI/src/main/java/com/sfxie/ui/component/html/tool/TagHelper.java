package com.sfxie.ui.component.html.tool;

public class TagHelper {

	public static void appendTagStartName(StringBuffer sb,String tagName){
		sb.append("<").append(tagName).append(">");
	}
	public static void appendTagStartName(StringBuffer sb,String tagName,String attributes){
		sb.append("<").append(tagName).append(" ").append(attributes).append(">");
	}
	public static void appendTagEndName(StringBuffer sb,String tagName){
		sb.append("</").append(tagName).append(">");
	}
}
