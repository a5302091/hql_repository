package com.shop.entity;

/**
 * ������
 * @author Administrator
 *
 */

public class CarItem {
	
	private Product product;//��Ʒ��Ϣ
	private int count;//�����ĳ����Ʒ����
	private double subtotal;//����ĳ����ƷС��
	
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
	//���㹺����Ʒ�����۸��
	public double getSubtotal() {
		return count * product.getShop_price();
	}
	
	

}
