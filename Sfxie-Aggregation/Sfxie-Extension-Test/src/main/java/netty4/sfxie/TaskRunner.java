package netty4.sfxie;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

/**
 * 使用netty的EventLoopGroup类来提交运行任务<br>
 * 利用netty的线程模型<br>
 * 用于执行时间比较长的业务逻辑处理
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午1:12:59 2016年5月18日
 * @example		
 *
 */
public class TaskRunner {

	private static EventLoopGroup bossGroup = new NioEventLoopGroup(20);
	/**	加volatile关键字,可以使_instance变量改变的值其他线程立即可见	*/
	private volatile static TaskRunner _instance;

	private TaskRunner(){}
	
	/**
	 * 双重检查锁来实现单例类<br>
     * An implementation of double checked locking of Singleton.<br>
     * Intention is to minimize cost of synchronization and  improve performance,
     * by only locking critical section of code, the code which creates instance of Singleton class.
     * By the way this is still broken, if we don't make _instance volatile, as another thread can
     * see a half initialized instance of Singleton.
     */
	 
    public static TaskRunner getInstance( ) {
        if (_instance == null) {
            synchronized (TaskRunner.class) {
                if (_instance == null) {
                    _instance = new TaskRunner();
                }
            }
        }
        return _instance;
    }
	/**
	 * 提交并运行任务
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	下午1:25:58 2016年5月18日
	 * @example
	 * @param task	
	 *
	 */
	public void submitTask(Runnable task){
		bossGroup.submit(task);
	}
}
