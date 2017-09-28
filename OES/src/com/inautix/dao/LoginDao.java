package com.inautix.dao;

import com.inautix.model.User;

public interface LoginDao {
	
	public boolean authenticate(String userid,String password);
	
	public int userId(String username,String password);
	
	public User userDetails(int userid);
	
	
}
