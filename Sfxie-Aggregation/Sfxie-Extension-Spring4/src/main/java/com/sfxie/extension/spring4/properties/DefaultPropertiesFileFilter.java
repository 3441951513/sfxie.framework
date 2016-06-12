package com.sfxie.extension.spring4.properties;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Properties;

import org.springframework.util.StringUtils;

import com.sfxie.extension.spring4.mvc.context.Context;

public class DefaultPropertiesFileFilter implements IPropertiesFileFilter {

	@Override
	public boolean filter(Properties preProperties,String fName) throws IOException {
		String enviroment = "."+Context.enviroment+".properties";
		String fileName = fName;
		fileName = fileName.substring(0,fileName.indexOf("."));

		String ignoreEnviroment = preProperties.getProperty("ignoreEnviromentFiles");
		String[] ignoreEnviroments = null;
		if(!StringUtils.isEmpty(ignoreEnviroment)){
			ignoreEnviroments = ignoreEnviroment.split(",");
		}
		//需要分不同环境的配置文件和不需要分不同环境的配置文件
		if(fName.contains(enviroment) || arrayContains(fileName,ignoreEnviroments)){
			return true;
		}
		return false;
	}


	@Override
	public String loadPrePropertiesPath() {
		// TODO Auto-generated method stub
		return "config/enviroment.properties";
	}


	@Override
	public void validate(Properties preProperties)  throws IOException{
		if(StringUtils.isEmpty(preProperties.getProperty("enviroment"))){
			throw new IOException("请配置classpath:config/enviroment.properties目录下的enviroment属性.");
		}
		String os = System.getProperty("os.name");  
        if (os != null && os.startsWith("Windows") && Context.enviroment.equals("product")) { 
        	throw new IOException("您不能在windows环境下启动生产环境配置,请切换到开发或测试环境,谢谢.");
		}
	}
	
	private boolean arrayContains(String search,String[] ignoreEnviroments){
		if(null==ignoreEnviroments)
			return false;
		for(String key : ignoreEnviroments){
			if(key.equals(search))
				return true;
		}
		return false;
	}

}
