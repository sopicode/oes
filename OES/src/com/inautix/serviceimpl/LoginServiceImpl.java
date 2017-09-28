package com.inautix.serviceimpl;

import com.inautix.daoimpl.LoginDaoImpl;
import com.inautix.model.User;
import com.inautix.service.LoginService;

public class LoginServiceImpl implements LoginService {

	LoginDaoImpl logindao;

	public LoginServiceImpl() {
		logindao=new LoginDaoImpl();
	}
	
	@Override
	public boolean authenticate(String userid, String password) {
		// TODO Auto-generated method stub
		return logindao.authenticate(userid, password);
	}

	@Override
	public int userId(String username, String password) {
		// TODO Auto-generated method stub
		return logindao.userId(username, password);
	}

	@Override
	public User userDetails(int userid) {
		// TODO Auto-generated method stub
		return logindao.userDetails(userid);
	}
	

}
