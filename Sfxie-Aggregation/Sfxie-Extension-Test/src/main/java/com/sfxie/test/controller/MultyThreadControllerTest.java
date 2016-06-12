package com.sfxie.test.controller;

import java.io.File;
import java.io.IOException;



import java.util.HashMap;
import java.util.Map;

import com.sfxie.utils.FileUtils;
import com.sfxie.utils.LoggerUtil;


/**
 * 多线程测试基类
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午4:40:37 2015年9月22日
 * @example		
 *
 */
public class MultyThreadControllerTest extends BaseControllerTest {
	
	/**	每个线程执行一次任务后的睡眠时间		*/
	private double threadSleepSecond;
	
	/**	每个线程执行的总次数		*/
	private int threadRunCount  = 1;
	
	
	
	
	private int threadCount = 1;
	
	private MultyThreadCallback callback;
	
	
	/**	开始多线程测试	*/
	public  void multyThreadPostXML(){
		int count = getThreadCount();
		for(int i=0;i<count;i++){
			new MultyThreadController().start();
		}
	}
	public int getThreadCount() {
		return threadCount;
	}
	/**	设置线程数量	*/
	public void setThreadCount(int threadCount) {
		this.threadCount = threadCount;
	}
	
	

	/**
	 * 设置每个线程执行一次任务后的睡眠时间(单位：秒)
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	下午4:27:40 2015年9月23日
	 * @param threadSleepSecond	
	 *
	 */
	public void setThreadSleepSecond(double threadSleepSecond) {
		this.threadSleepSecond = threadSleepSecond;
	}
	/**
	 * 设置每个线程执行的总次数
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	下午4:27:54 2015年9月23日
	 * @param threadRunCount	
	 *
	 */
	public void setThreadRunCount(int threadRunCount) {
		this.threadRunCount = threadRunCount;
	}

	class MultyThreadController extends Thread{
		@Override
		public void run() {
			int runCount = 0;
			String rootUrl = getRootUrl();
			String contollerName = getContollerName();
			Object jaxbObject = getJaxbObject();
			String contollerMethod = getContollerMethod();
			String xmlParam = getXmlParam();
			String stringParam = getStringParam();
			while(runCount<threadRunCount){
				try {
					if(null==getXmlParam()){
						if(null!=getXmlParamFilePath()){
							String p = FileUtils.loadAFileToStringDE3(new File(null!=getXmlParamFileRootPath()?getXmlParamFileRootPath():""+getXmlParamFilePath()));
							if(null!=getParameterMap() && getParameterMap().size() > 0){
								for(String key : getParameterMap().keySet()){
									p = p.replaceAll("#"+key+"#", getParameterMap().get(key));
								}
							}
							setXmlParam(p);
						}
					}
					String response = postXML();
					if(null!=callback){
						callback.callback(response);
					}
//					LoggerUtil.instance(MultyThreadControllerTest.class).info("返回: "+response);
					System.out.println(response);
					runCount++;
					if(threadSleepSecond > 0){
						try {
							sleep(Math.round(threadSleepSecond*1000));
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					setRootUrl(rootUrl);
					setContollerName(contollerName);
					setJaxbObject(jaxbObject);
					setContollerMethod(contollerMethod);
					setXmlParam(getXmlParam());
					setStringParam(stringParam);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public MultyThreadCallback getCallback() {
		return callback;
	}
	public void setCallback(MultyThreadCallback callback) {
		this.callback = callback;
	}
	
	public static void main(String[] args) {
		String p = "dddd#parameter#";
		System.out.println(p.replaceAll("#parameter#", ""));
	}
	
	
}
