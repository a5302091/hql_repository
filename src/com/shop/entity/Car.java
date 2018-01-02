package com.shop.entity;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车对象
 * @author Administrator
 *
 */

public class Car {

	// 购物集合的购物项 key:商品ID value:购物项
	private Map<Integer, CarItem> map = new LinkedHashMap<Integer, CarItem>();
	
	
	public Collection<CarItem> getCarItems() {
		return map.values();
	}

	// 获取购物总计
	private double total;

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	// 添加商品
	public void addCar(CarItem carItem) {

		/**
		 * 购物车中是否已经存在该商品
		 */

		// 获取商品ID
		Integer pid = carItem.getProduct().getPid();

		// 判断商品是否已经存在
		if (map.containsKey(pid)) {
			CarItem carItem2 = map.get(pid);

			carItem2.setCount(carItem2.getCount() + carItem.getCount());

		} else {
			map.put(pid, carItem);
		}

		// 设计总计
		total += carItem.getSubtotal();

	}

	// 删除商品
	public void removeCar(Integer pid) {
		
		CarItem carItem = map.remove(pid);

		total -= carItem.getSubtotal();
	}

	// 清空购物车
	public void cleanCar() {
		map.clear();

		total = 0;
	}

}
