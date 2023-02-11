package com.tranhjava.dao.impl;
	
import java.util.List;

import com.tranhjava.dao.ICategoryDAO;
import com.tranhjava.mapper.CategoryMapper;
import com.tranhjava.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {
	
	
	public List<CategoryModel> findAll() {
		String sql="SELECT * FROM category";
		return query(sql, new CategoryMapper());
	}

	@Override
	public CategoryModel findOne(long id) {
		String sql = "SELECT * FROM category WHERE id =?";
		List<CategoryModel> category = query(sql, new CategoryMapper(), id);
		return category.isEmpty() ? null : category.get(0);
	}

	@Override
	public CategoryModel findOneByCode(String code) {
		String sql = "SELECT * FROM category WHERE code =?";
		List<CategoryModel> category = query(sql, new CategoryMapper(), code);
		return category.isEmpty() ? null : category.get(0);
	}
}
