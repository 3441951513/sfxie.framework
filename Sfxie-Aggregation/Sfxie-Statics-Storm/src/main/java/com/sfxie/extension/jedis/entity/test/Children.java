package com.sfxie.extension.jedis.entity.test;

//import com.sfxie.extension.jedis.annotation.RedisKey;
//import com.sfxie.extension.jedis.annotation.RedisParent;
//import com.sfxie.extension.jedis.annotation.RedisTransient;
import com.sfxie.extension.jedis.entity.JedisPersistentObject;
import com.sfxie.extension.jedis.entity.SaveType;

public class Children extends JedisPersistentObject{
	
//	@RedisKey
	private Long id;
	
	private String name;
	
//	@RedisTransient
	private transient Toy toy;
	
//	@RedisParent(parent=Parent.class)
//	@RedisTransient
	private transient Parent parent;
//	private Long parentId;
	
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

	public Toy getToy() {
		return toy;
	}

	public void setToy(Toy toy) {
		this.toy = toy;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	
	/*public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}*/

	
}
