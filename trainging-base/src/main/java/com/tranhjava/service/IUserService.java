package com.tranhjava.service;

import com.tranhjava.model.UserModel;

public interface IUserService {
	UserModel findByUPS(String userName, String password, Integer status);
}
