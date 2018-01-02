package com.shop.dao;

import java.util.List;

/**
 * һ���˵�����
 */

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shop.entity.Category;

public class CategoryDao extends HibernateDaoSupport {

	// ��ʾ����һ���˵�
	public List<Category> findAll() {

		String hql = "from Category";
		List<Category> list = this.getHibernateTemplate().find(hql);
		
		if (list != null) {

			return list;
		}

		return null;
	}

}
