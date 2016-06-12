package com.sfxie.algorithm.tree.btree.test;

import com.sfxie.algorithm.tree.btree.BTree;

public class MyComparable implements Comparable<MyComparable> {

	private String id; 
	
	
	public MyComparable(String id){
		this.id = id;
	}
	
	@Override
	public int compareTo(MyComparable o) {
		if(this.id.indexOf(o.getId())>=0){
			return -1;
		}
		return 0;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public static void main(String[] args) {
		BTree btree = new BTree();
		btree.add(new MyComparable("0"));
		btree.add(new MyComparable("01"));
		btree.add(new MyComparable("02"));
		System.out.println(11);
	}
	
}
