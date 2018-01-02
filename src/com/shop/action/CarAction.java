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
 * 购物车Action
 * 
 * @author Administrator
 *
 */

public class CarAction extends ActionSupport {

	// 注入商品service
	private ProductService productService;

	// 获取商品pid
	private Integer pid;

	// 商品数量
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

		// 封装一个carItem对象
		CarItem carItem = new CarItem();

		// 购买的商品数量
		carItem.setCount(count);
		// 获取pid
		Product product = productService.findBypid(pid);

		// 获取商品
		carItem.setProduct(product);

		// 将获取的商品信息存入session
		Car car = getCar();

		car.addCar(carItem);

		return "addCar";
	}

	// 将商品信息存入session中
	private Car getCar() {

		Car car = (Car) ServletActionContext.getRequest().getAttribute("car");

		// 如果car不存在,就自己创建一个存入session中
		if (car == null) {
			car = new Car();

			ServletActionContext.getRequest().getSession().setAttribute("car", car);

		}

		return car;
	}

	// 清空购物车
	public String clean() {

		Car car = getCar();

		// 调用清空购物车的方法

		car.cleanCar();

		return "clean";
	}

	// 删除购物车商品
	public String shan() {

		
		// 获取Car对象
		Car car =	new Car();		 
		
		System.out.println();
		// 调用删除购物车方法

		car.removeCar(pid);

		return "shan";
	}

}
