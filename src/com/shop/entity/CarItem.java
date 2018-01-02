package com.shop.entity;

/**
 * 购物项
 * @author Administrator
 *
 */

public class CarItem {
	
	private Product product;//商品信息
	private int count;//购买的某种商品数量
	private double subtotal;//购买某种商品小计
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	//计算购买商品数量价格和
	public double getSubtotal() {
		return count * product.getShop_price();
	}
	
	

}
