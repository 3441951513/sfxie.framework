package com.sfxie.algorithm.probability.cycle;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author huangxing
 * @date 2016年3月3日 下午1:46:04 `
 * @parameter
 * @since
 * @return
 * @example final Cycle<CycleEntity<BusinessEntity>> cycle = new
 *          Cycle<CycleEntity<BusinessEntity>>(); <br>
 * <br>
 * <br>
 *          BusinessEntity E1 = new BusinessEntity(); <br>
 *          E1.setGoodsId(1); <br>
 *          E1.setName("goods1"); <br>
 *          BusinessEntity E2 = new BusinessEntity(); <br>
 *          E2.setGoodsId(2); <br>
 *          E2.setName("goods2"); <br>
 *          BusinessEntity E3 = new BusinessEntity(); <br>
 *          E3.setGoodsId(3); <br>
 *          E3.setName("goods3"); <br>
 *          BusinessEntity E4 = new BusinessEntity(); <br>
 *          E4.setGoodsId(4); <br>
 *          E4.setName("goods4"); <br>
 * <br>
 *          CycleEntity<BusinessEntity> cycleEntity1 = new
 *          CycleEntity<BusinessEntity>(); <br>
 *          cycleEntity1.setOrder(1); <br>
 *          cycleEntity1.setProbability(0.103); <br>
 *          cycleEntity1.setData(E1); <br>
 *          cycle.add(cycleEntity1); <br>
 * <br>
 *          CycleEntity<BusinessEntity> cycleEntity2 = new
 *          CycleEntity<BusinessEntity>(); <br>
 *          cycleEntity2.setOrder(2); <br>
 *          cycleEntity2.setProbability(0.192); <br>
 *          cycleEntity2.setData(E2); <br>
 *          cycle.add(cycleEntity2); <br>
 * <br>
 *          CycleEntity<BusinessEntity> cycleEntity4 = new
 *          CycleEntity<BusinessEntity>(); <br>
 *          cycleEntity4.setOrder(4); <br>
 *          cycleEntity4.setProbability(0.404); <br>
 *          cycleEntity4.setData(E4); <br>
 *          cycle.add(cycleEntity4); <br>
 * <br>
 *          CycleEntity<BusinessEntity> cycleEntity3 = new
 *          CycleEntity<BusinessEntity>(); <br>
 *          cycleEntity3.setOrder(3); <br>
 *          cycleEntity3.setProbability(0.301); <br>
 *          cycleEntity3.setData(E3); <br>
 *          cycle.add(cycleEntity3); <br>
 * <br>
 *          cycle.size(); <br>
 * <br>
 * <br>
 *          // CycleEntity<Object> ddd = cycle.hitTheTarget(0.222f); for(int <br>
 *          // i=0;i<100000;i++){ System.out.println(new Random().nextFloat());
 *          } <br>
 * <br>
 * <br>
 *          Random r = new Random(); <br>
 *          CycleEntity<BusinessEntity> ddd =
 *          cycle.hitTheTarget(r.nextDouble()); <br>
 * <br>
 *          cycle.restruct(new ICycleFindOrder() { <br>
 * @Override <br>
 *           public ICycleEntity findOrder() { <br>
 *           int goodsid = 1; <br>
 *           Iterator<CycleEntity<BusinessEntity>> it =
 *           (Iterator<CycleEntity<BusinessEntity>>) cycle <br>
 *           .iterator(); <br>
 *           while (it.hasNext()) { <br>
 *           CycleEntity<BusinessEntity> ce = (CycleEntity<BusinessEntity>) it <br>
 *           .next(); <br>
 *           if (ce.getData().getGoodsId() == goodsid) { <br>
 *           return ce; <br>
 * <br>
 * <br>
 *           return null; <br>
 * <br>
 *           ); <br>
 * <br>
 *           cycle.size();
 * 
 */
public class CycleUtil<E> extends TreeSet<E> {

	/**
	 * 转盘工具类
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean add(E e) {
		boolean flag = super.add(e);
		struct();
		return flag;
	}

	/**
	 * 构造圆盘区域实体
	 */
	private void struct() {
		float count = 0f;
		Iterator<E> it = (Iterator<E>) iterator();
		while (it.hasNext()) {
			CycleEntity<E> ce = (CycleEntity<E>) it.next();
			ce.setProbabilityStart(count);
			count += ce.getProbability();
			ce.setProbabilityEnd(count);
			if (!it.hasNext()) {
				ce.setProbabilityEnd(1);
			}
		}
	}

	/**
	 * 返回被命中区域
	 * 
	 * @param probability
	 *            0-1之间的任意数
	 * @return
	 */
	public E hitTheTarget(double probability) {
		Iterator<E> it = (Iterator<E>) iterator();
		while (it.hasNext()) {
			CycleEntity ce = (CycleEntity) it.next();
			if (ce.getProbabilityStart() < probability
					&& ce.getProbabilityEnd() > probability) {
				return (E) ce;
			}

		}
		return null;
	}

	/**
	 * 圆盘某区域概率清0后重新构造各区域概率分布
	 * 
	 * @param cycleFindOrder
	 *            包含概率需要清0的实体中的概率和序号实体类
	 */
	public void restruct(ICycleFindOrder cycleFindOrder) {
		double count = 0.0;
		Iterator<E> it = (Iterator<E>) iterator();
		// 获取概率需清0的区域
		CycleEntity cycleFindEntity = (CycleEntity) cycleFindOrder.findOrder();
		while (it.hasNext()) {
			CycleEntity ce = (CycleEntity) it.next();
			if (ce.getOrder() != cycleFindEntity.getOrder()) {
				double ddd = ArithUtil.div(
						ce.getProbability(),
						ArithUtil.sub(1.000000d,
								cycleFindEntity.getProbability()));
				double reprobability = (ddd);
				ce.setProbability(reprobability);
				// ce.setProbabilityStart(count);
				// count += reprobability;
				// ce.setProbabilityEnd(count);
			}
		}
		cycleFindEntity.setProbability(0.0);
		struct();
	}

}
