package com.sfxie.ui.extjs5.i18n;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

public class GetAllClassName{
	
	private IServletContextHelper servletContextHelper;
	
    public List<String> getAllClassName(String[] paths){
    	String classPath;
    	ServletContext servletContext = servletContextHelper.getServletContext();
    	if(null!=servletContext)
    		classPath = servletContext.getRealPath(File.separator);
    	else
    		classPath = GetAllClassName.class.getClassLoader().getResource("").getPath();
//    	String [] paths = new String []{"com.eastcompeace.oa.dto"};
    	List<String> classNames = new ArrayList<String> ();
    	for(String path : paths){
    		File dir;
    		if(null!=servletContext){
        		dir = new File(classPath+File.separator+"WEB-INF"+File.separator+"classes"+File.separator+path.replace(".",File.separator));
    		}
        	else{
        		dir = new File(classPath+path.replace(".", "/"));
        	}
	        getAll(dir,path,classNames);
    	}
    	return classNames;
    }
    public void getAll(File dir,String packageName,List<String> fileNames){
        File[] files = dir.listFiles();
        for(int x=0; x<files.length; x++){
            if(files[x].isDirectory()){
            	String childFilePath = files[x].getPath();
            	String childrenPath = files[x].getPath().substring(childFilePath.lastIndexOf("classes\\")+8).replace("\\", ".");
                getAll(files[x],childrenPath,fileNames);
            }
            else
            	fileNames.add(packageName+"."+files[x].getName());
        }
    }
    public IServletContextHelper getServletContextHelper() {
		return servletContextHelper;
	}
	public void setServletContextHelper(IServletContextHelper servletContextHelper) {
		this.servletContextHelper = servletContextHelper;
	}
    
}