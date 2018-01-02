package com.shop.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.shop.dao.CategoryDao;
import com.shop.entity.Category;

/**
 * 一级分类菜单 
 * @author Administrator
 *
 */

@Transactional
public class CategoryService {
	
	//注入dao
	private CategoryDao categoryDao;

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	
	//查询所有一级菜单
	public List<Category> findAll() {
		
		return categoryDao.findAll();
		
		
	}
	
	

}
