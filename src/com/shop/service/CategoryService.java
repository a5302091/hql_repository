package com.shop.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.shop.dao.CategoryDao;
import com.shop.entity.Category;

/**
 * һ������˵� 
 * @author Administrator
 *
 */

@Transactional
public class CategoryService {
	
	//ע��dao
	private CategoryDao categoryDao;

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	
	//��ѯ����һ���˵�
	public List<Category> findAll() {
		
		return categoryDao.findAll();
		
		
	}
	
	

}
