package com.shop.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.shop.dao.ProductDao;
import com.shop.entity.Product;
import com.shop.utils.pageBean;

/**
 * 商品信息业务层
 * 
 * @author Administrator
 *
 */

@Transactional
public class ProductService {

	// 注入dao

	private ProductDao productDao;

	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	// 显示热门商品
	public List<Product> findHot() {

		return productDao.findHot();
	}

	// 显示最新商品
	public List<Product> findNew() {

		return productDao.findNew();
	}

	// 根据商品ID查询商品
	public Product findBypid(Integer pid) {

		return productDao.findBypid(pid);
	}

	// 根据一级分类cid分页查询商品
	public pageBean<Product> findByPageCid(Integer cid, int page) {

		pageBean<Product> pageBean = new pageBean<Product>();
		// 设置当前页数
		pageBean.setPage(page);
		// 设置每一页显示的记录数
		int limit = 12;
		pageBean.setLimit(limit);
		// 显示总记录数
		int totalCount = 0;
		totalCount = productDao.findCountCid(cid);
		pageBean.setTotalCount(totalCount);
		// 设置总页数
		int totalPage = 0;

		// Math.ceil(totalCount/limit);

		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);

		// 从哪开始
		int begin = (page - 1) * limit;

		// 每页显示的数据集合
		List<Product> list = productDao.findbyPageCid(cid, begin, limit);
		pageBean.setList(list);

		return pageBean;
	}

	//根据二级分类csid查询商品
	public pageBean<Product> findByCsid(Integer csid, int page) {
		
		pageBean<Product> pageBean=new pageBean<Product>();
		//设置当前的页数
		pageBean.setPage(page);
		//设置每页显示的数量
		int limit=12;
		pageBean.setLimit(limit);
		//显示总的记录数
		int totalCount=0;
		productDao.findCountCsid(csid);
		pageBean.setTotalCount(totalCount);
		//显示总的页数
		int totalPage=0;
		totalPage=(int) Math.ceil(totalCount/limit);
		pageBean.setTotalPage(totalPage);
		
		//页面从哪开始
		int begin=(page-1)* limit;
		
		//每页显示的数据集合
		List<Product> list=productDao.findbyPageCsid(csid, begin, limit);
		pageBean.setList(list);
		
		return pageBean;
	}

}
