package com.sfxie.soa.common.response;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;



/**
 * 购买模块(purchase)返回基类
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午5:42:43 2015年9月2日
 * @example		
 *
 */
@XmlRootElement
@XmlSeeAlso({
})
@XmlAccessorType(XmlAccessType.NONE)
public abstract class Response<T>  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Header header;
	
	protected Data<T> data;
	
	protected Data<T> entity;
	
	private Error error;
	
	

	@XmlElement(name="error")
	public Error getError() {
		if(null==error){
			Error e = new Error();
			e.setCode("");
			e.setNote("");
			e.setType("false");
			return e;
		}
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}
	/**
	 * 获取数据节点(实现此方法,生成具体的数据类型节点)
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	上午9:19:10 2016年3月4日
	 * @example
	 * @return	
	 *
	 */
	public abstract Data<T> getData();
	
	public abstract  Data<T> getEntity();

	public void setData(Data<T> data){
		this.data = data;
	}

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}
	
	
}
