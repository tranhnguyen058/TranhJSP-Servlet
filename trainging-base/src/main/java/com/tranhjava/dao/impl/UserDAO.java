package com.tranhjava.dao.impl;

import java.util.List;

import com.tranhjava.dao.IUserDAO;
import com.tranhjava.mapper.UserMapper;
import com.tranhjava.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {

	@Override
	public UserModel findByUPS(String userName, String password, Integer status) {
		StringBuilder sql = new StringBuilder( "SELECT * FROM user AS u ");
		sql.append("INNER JOIN role AS r ON r.id = u.roleid ");
		sql.append("WHERE username = ? AND password = ? AND status = ?");
		List<UserModel> users = query(sql.toString(), new UserMapper(), userName, password, status);
		return users.isEmpty() ? null : users.get(0);
		
	}
	
}
