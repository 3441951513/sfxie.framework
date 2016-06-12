package com.sfxie.algorithm.probability.cycle;

/**
 * 获取概率需要清0区域的相关信息
 * 
 * @author huangxing
 * @date 2016年3月3日 下午7:45:12
 * @parameter
 * @since
 * @return
 */
public interface ICycleEntity {

	public double getProbability();

	public int getOrder();
}
