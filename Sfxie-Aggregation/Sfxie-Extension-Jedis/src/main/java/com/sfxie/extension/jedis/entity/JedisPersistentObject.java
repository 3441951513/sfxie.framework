package com.sfxie.extension.jedis.entity;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.parsers.ParserConfigurationException;

import com.sfxie.extension.jedis.entity.test.Children;
import com.sfxie.extension.jedis.entity.test.Parent;
import com.sfxie.extension.jedis.entity.test.Toy;
import com.sfxie.extension.jedis.entity.test.XmlObject;
import com.sfxie.utils.SerializeUtil;
import com.sfxie.utils.XmlUtils;

/**
 * jedis对象持久化类
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午1:40:40 2015-7-31
 * @example		
 *
 */
public abstract class JedisPersistentObject  implements JedisSerializer{

	/**
	 * 
	 */
	@XmlTransient
	private transient static final long serialVersionUID = 1L;
	/**	过期时间		*/
	private transient int timeout;
	
	/**	存储类型,默认为字节存储		*/
	private transient SaveType saveType = SaveType.BYTES;
	
	@XmlTransient
	public int getTimeout() {
		return timeout;
	}
	@XmlTransient
	public SaveType getSaveType() {
		SaveType st = setSaveType();
		if(null!=st)
			return st;
		return saveType;
	}
	/** 设置储存类型	*/
	public abstract SaveType setSaveType( );

	/**
	 * 设置过期时间
	 * @TODO	设置过期时间,如果不设置,则永久存在
	 * @author 	xieshengfeng
	 * @since 	下午1:41:39 2015-7-31
	 * @param timeout	
	 *
	 */
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
	
	public static void main(String[] args) {
		XmlObject xmlObject = new XmlObject();
		xmlObject.setAge(1);
		xmlObject.setName("谢声锋");
		try {
			System.out.println(XmlUtils.serializerXmlString(xmlObject));
			XmlObject XmlObject2 = XmlUtils.unserializer(XmlObject.class,XmlUtils.serializerBytes(xmlObject));
			System.out.println(XmlObject2.getName());
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Parent parent = new Parent();
		parent.setId(1L);
		parent.setName("parent");
		
		Children child = new Children();
		child.setId(1L);
		child.setName("children");
		child.setParent(parent);
		
		Toy toy = new Toy();
		toy.setId(1L);
		toy.setName("玩具");
		toy.setOwner(child);
		
		Toy toyObject =  SerializeUtil.unserialize(Toy.class,SerializeUtil.serialize(toy));
		System.out.println();
	}

}
