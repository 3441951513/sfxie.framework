package com.sfxie.algorithm.probability.cycle;

/**
 * 圆盘区域块实体类
 * @author huangxing
 * @date 2016年3月3日 下午1:52:27
 * @parameter
 * @since
 * @return
 */
public class CycleEntity<E> implements Comparable<CycleEntity<E>>, ICycleEntity {

	private E data;

	// private Integer goodId;

	// private int angleStart;

	// private int angleEnd;

	private double probability;

	private double probabilityStart;

	private double probabilityEnd;

	// private String name;

	private int order;

	/*
	 * public Integer getGoodId() { return goodId; }
	 * 
	 * public void setGoodId(Integer goodId) { this.goodId = goodId; }
	 * 
	 * 
	 * public int getAngleStart() { return angleStart; }
	 * 
	 * public void setAngleStart(int angleStart) { this.angleStart = angleStart;
	 * }
	 * 
	 * public int getAngleEnd() { return angleEnd; }
	 * 
	 * public void setAngleEnd(int angleEnd) { this.angleEnd = angleEnd; }
	 */
	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
	}

	public double getProbabilityStart() {
		return probabilityStart;
	}

	public void setProbabilityStart(double probabilityStart) {
		this.probabilityStart = probabilityStart;
	}

	public double getProbabilityEnd() {
		return probabilityEnd;
	}

	public void setProbabilityEnd(double probabilityEnd) {
		this.probabilityEnd = probabilityEnd;
	}

	// public String getName() {
	// return name;
	// }
	//
	// public void setName(String name) {
	// this.name = name;
	// }

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	@Override
	public int compareTo(CycleEntity<E> o) {
		return this.order - o.order;
	}

	public boolean equals(Object obj) {
		CycleEntity<E> def = (CycleEntity<E>) obj;
		return (this.order == def.order);
	}

	public int hashCode() {
		return this.order;
	}

}
