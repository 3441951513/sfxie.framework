package com.sfxie.extension.jedis.entity.test;

import java.util.List;

import com.sfxie.extension.jedis.annotation.RedisKey;
import com.sfxie.extension.jedis.annotation.RedisTransient;
import com.sfxie.extension.jedis.entity.JedisPersistentObject;
import com.sfxie.extension.jedis.entity.SaveType;

public class Parent extends JedisPersistentObject{

	
	@RedisKey
	private Long id;
	
	private String name;
	
	@RedisTransient
	private transient List<Children> children;

	
	
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

	public List<Children> getChildren() {
		return children;
	}

	public void setChildren(List<Children> children) {
		this.children = children;
	}
	
	
}
