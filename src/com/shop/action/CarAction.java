package com.shop.action;

import java.util.List;

import org.apache.log4j.lf5.viewer.categoryexplorer.CategoryImmediateEditor;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.entity.Car;
import com.shop.entity.CarItem;
import com.shop.entity.Product;
import com.shop.service.ProductService;

/**
 * ���ﳵAction
 * 
 * @author Administrator
 *
 */

public class CarAction extends ActionSupport {

	// ע����Ʒservice
	private ProductService productService;

	// ��ȡ��Ʒpid
	private Integer pid;

	// ��Ʒ����
	private Integer count;

	public void setCount(Integer count) {
		this.count = count;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	
	

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String addCar() {

		// ��װһ��carItem����
		CarItem carItem = new CarItem();

		// �������Ʒ����
		carItem.setCount(count);
		// ��ȡpid
		Product product = productService.findBypid(pid);

		// ��ȡ��Ʒ
		carItem.setProduct(product);

		// ����ȡ����Ʒ��Ϣ����session
		Car car = getCar();

		car.addCar(carItem);

		return "addCar";
	}

	// ����Ʒ��Ϣ����session��
	private Car getCar() {

		Car car = (Car) ServletActionContext.getRequest().getAttribute("car");

		// ���car������,���Լ�����һ������session��
		if (car == null) {
			car = new Car();

			ServletActionContext.getRequest().getSession().setAttribute("car", car);

		}

		return car;
	}

	// ��չ��ﳵ
	public String clean() {

		Car car = getCar();

		// ������չ��ﳵ�ķ���

		car.cleanCar();

		return "clean";
	}

	// ɾ�����ﳵ��Ʒ
	public String shan() {

		
		// ��ȡCar����
		Car car =	new Car();		 
		
		System.out.println();
		// ����ɾ�����ﳵ����

		car.removeCar(pid);

		return "shan";
	}

}
