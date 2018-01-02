package com.shop.entity;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ���ﳵ����
 * @author Administrator
 *
 */

public class Car {

	// ���Ｏ�ϵĹ����� key:��ƷID value:������
	private Map<Integer, CarItem> map = new LinkedHashMap<Integer, CarItem>();
	
	
	public Collection<CarItem> getCarItems() {
		return map.values();
	}

	// ��ȡ�����ܼ�
	private double total;

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	// �����Ʒ
	public void addCar(CarItem carItem) {

		/**
		 * ���ﳵ���Ƿ��Ѿ����ڸ���Ʒ
		 */

		// ��ȡ��ƷID
		Integer pid = carItem.getProduct().getPid();

		// �ж���Ʒ�Ƿ��Ѿ�����
		if (map.containsKey(pid)) {
			CarItem carItem2 = map.get(pid);

			carItem2.setCount(carItem2.getCount() + carItem.getCount());

		} else {
			map.put(pid, carItem);
		}

		// ����ܼ�
		total += carItem.getSubtotal();

	}

	// ɾ����Ʒ
	public void removeCar(Integer pid) {
		
		CarItem carItem = map.remove(pid);

		total -= carItem.getSubtotal();
	}

	// ��չ��ﳵ
	public void cleanCar() {
		map.clear();

		total = 0;
	}

}
