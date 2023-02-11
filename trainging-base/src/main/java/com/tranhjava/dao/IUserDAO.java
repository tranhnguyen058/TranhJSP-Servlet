package com.tranhjava.dao;

import com.tranhjava.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel> {
	UserModel findByUPS(String userName, String password, Integer status);
}
	