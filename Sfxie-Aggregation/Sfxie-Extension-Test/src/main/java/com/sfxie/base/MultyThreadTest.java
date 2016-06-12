package com.sfxie.base;

import java.util.concurrent.CountDownLatch;





/**
 * 多线程测试基类
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午4:40:37 2015年9月22日
 * @example		
 *
 */
public abstract class MultyThreadTest extends BaseTest{
	
	public static int totalExecuteCount = 0;
	
	public static long startTime = 0;
	
	private CountDownLatch waitCountDownLatch = null;  
	/**	每个线程执行一次任务后的睡眠时间		*/
	private Double threadSleepSecond;
	
	/**	每个线程执行的总次数		*/
	private int threadRunCount  = 1;
	
	
	private int threadCount = 1;
	
	public int counter = 0;
	
	private MultyThreadCallback callback;
	
	
	
	/**	开始多线程测试	*/
	public  void multyThread(){
		Long start = System.currentTimeMillis();
		waitCountDownLatch = new CountDownLatch(threadCount); 
		for(;counter<threadCount;counter++){
			new MultyThread(threadRunCount).start();
		}
		try {
			waitCountDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
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

	class MultyThread extends Thread{
//		private CountDownLatch waitCountDownLatch2 = null;  
		public MultyThread(int threadRunCount){
			this.threadRunCount2 = threadRunCount;
//			waitCountDownLatch2 = new CountDownLatch (threadRunCount2);
		}
		private int threadRunCount2;
		private int threadRunCounter = 0;
		@Override
		public void run() {
			try{
				while(threadRunCounter<threadRunCount2){
//					try{
						callback.run();
						threadRunCounter++;
//						totalExecuteCount ++;
						if(null!=threadSleepSecond){
							Thread.sleep(threadSleepSecond.longValue());
						}
//					}finally{
//						waitCountDownLatch2.countDown();
//					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				waitCountDownLatch.countDown();;
			}
		}
	}
	
	public void setCallback(MultyThreadCallback callback) {
		this.callback = callback;
	}
	
	
}
