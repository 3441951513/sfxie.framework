package org.cniemp.core.exception;

/**
 * eniemp基础异常类
 * @author xieshengfeng
 * @email  xsfcy@126.com
 * @since  2015年5月16日 下午8:59:17
 * @todo   
 *
 */
public class CniempException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CniempException(){
		super();
	}
	
	public CniempException(String msg){
		super(msg);
	}
}
