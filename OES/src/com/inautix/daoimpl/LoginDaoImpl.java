package com.inautix.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.inautix.dao.LoginDao;
import com.inautix.jdbc.connection.DatabaseConnection;
import com.inautix.model.User;

public class LoginDaoImpl implements LoginDao {

	private DatabaseConnection databasecon;
	private Connection con;
	
	public LoginDaoImpl()
	{
		con = databasecon.getConnection();
	}

	public boolean authenticate(String userid, String password) {
		
		String query = "select * from users_16189 where username=? and password=?";
		ResultSet rs;
		try {
			PreparedStatement prep = con.prepareStatement(query);
			prep.setString(1, userid);
			prep.setString(2, password);
			rs = prep.executeQuery();
			if (rs.next())
				return true;
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}



	@Override
	public int userId(String username, String password) {
		String query = "select user_id from users_16189 where username=? and password=?";
		ResultSet rs;
		int userid=0;
		try {
			PreparedStatement prep = con.prepareStatement(query);
			prep.setString(1, username);
			prep.setString(2, password);
			rs = prep.executeQuery();
			
			while(rs.next())
			{
				userid=rs.getInt(1);
			}
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return userid;
	
	}


	@Override
	public User userDetails(int userid) {
		
		
		String query = "select * from users_16189 where user_id=?";
		ResultSet rs;
		User user=new User();
		try {
			PreparedStatement prep = con.prepareStatement(query);
			prep.setInt(1, userid);
			rs = prep.executeQuery();
			
			while(rs.next())
			{
				user.setName(rs.getString(2));
				user.setUsername(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setEmail(rs.getString(5));
			}
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return user;
		
		
	}
	
}
