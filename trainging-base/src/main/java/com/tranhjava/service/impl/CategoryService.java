package com.tranhjava.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.tranhjava.dao.ICategoryDAO;
import com.tranhjava.model.CategoryModel;
import com.tranhjava.service.ICategoryService;

public class CategoryService implements ICategoryService{
	@Inject
	private ICategoryDAO categoryDao;
	
	@Override
	public List<CategoryModel> findAll(){
		return categoryDao.findAll();
	}
}
