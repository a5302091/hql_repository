package com.shop.dao;

import java.util.List;

/**
 * 一级菜单分类
 */

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shop.entity.Category;

public class CategoryDao extends HibernateDaoSupport {

	// 显示所有一级菜单
	public List<Category> findAll() {

		String hql = "from Category";
		List<Category> list = this.getHibernateTemplate().find(hql);
		
		if (list != null) {

			return list;
		}

		return null;
	}

}
