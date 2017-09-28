package com.inautix.service;

import com.inautix.model.User;

public interface LoginService {
	
	public boolean authenticate(String userid,String password);

	public int userId(String username,String password);
	
	public User userDetails(int userid);
	
}
