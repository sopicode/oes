package com.inautix.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.inautix.dao.DeleteQuestion;
import com.inautix.jdbc.connection.DatabaseConnection;
import com.inautix.model.Question;

public class DeleteQuestionImpl implements DeleteQuestion {

	private DatabaseConnection databasecon;
	private Connection con;
	
	public DeleteQuestionImpl()
	{
		con = databasecon.getConnection();
	}
	
	@Override
	public boolean deleteQuestion(Question question) {
	
		String query = "delete from questions_16189 where ques_id=?";
		try {
			PreparedStatement prep = con.prepareStatement(query);
			prep.setInt(1,question.getQues_id());
			 int count=prep.executeUpdate();
			if (count>0)
			{
				return true;
			}
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	

}
