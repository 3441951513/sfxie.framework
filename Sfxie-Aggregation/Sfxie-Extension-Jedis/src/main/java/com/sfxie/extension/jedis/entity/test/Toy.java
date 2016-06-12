package com.sfxie.extension.jedis.entity.test;

import com.sfxie.extension.jedis.annotation.RedisKey;
import com.sfxie.extension.jedis.annotation.RedisParent;
import com.sfxie.extension.jedis.annotation.RedisTransient;
import com.sfxie.extension.jedis.entity.JedisPersistentObject;
import com.sfxie.extension.jedis.entity.SaveType;

/**
 * 玩具
 * @author xieshengfeng
 * @email  xsfcy@126.com
 * @since 2015年7月22日上午9:32:01
 */
public class Toy extends JedisPersistentObject{

	@RedisKey
	private Long id;
	
	@RedisParent(parent=Children.class)
	@RedisTransient
	private transient Children owner;
//	private Long childrenId;
	
	private String name;
	
	@RedisParent(parent=Parent.class)
	private Long parentId;

	@Override
	public SaveType setSaveType( ) {
		return SaveType.BYTES;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Children getOwner() {
		return owner;
	}

	public void setOwner(Children owner) {
		this.owner = owner;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}


	/*public Long getChildrenId() {
		return childrenId;
	}

	public void setChildrenId(Long childrenId) {
		this.childrenId = childrenId;
	}*/
	
	
}
