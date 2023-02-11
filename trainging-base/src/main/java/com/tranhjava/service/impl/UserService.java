package com.tranhjava.service.impl;

import javax.inject.Inject;

import com.tranhjava.dao.IUserDAO;
import com.tranhjava.model.UserModel;
import com.tranhjava.service.IUserService;

public class UserService implements IUserService{
	@Inject
	private IUserDAO userDAO;
	
	
	@Override
	public UserModel findByUPS(String userName, String password, Integer status) {
		return userDAO.findByUPS(userName, password, status);
	}

}
