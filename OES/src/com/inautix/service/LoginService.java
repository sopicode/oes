package com.inautix.service;

import com.inautix.model.User;

public interface LoginService {
	
	public boolean authenticate(String userid,String password,String tableName);

	public int userId(String username,String password,String tableName);
	
	public User userDetails(int userid,String tableName);
	
}
