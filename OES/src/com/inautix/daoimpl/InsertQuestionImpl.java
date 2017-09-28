package com.inautix.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.inautix.dao.InsertQuestion;
import com.inautix.jdbc.connection.DatabaseConnection;
import com.inautix.model.Question;

public class InsertQuestionImpl implements InsertQuestion{

	private DatabaseConnection databasecon;
	private Connection con;
	
	public InsertQuestionImpl()
	{
		con = databasecon.getConnection();
	}
	
	
	@Override
	public boolean insertQuestion(String question,int topicid) {
	
		String query = "insert into questions_16189(ques,topic_id) values(?,?)";
		try {
			PreparedStatement prep = con.prepareStatement(query);
			prep.setString(1,question);
			prep.setInt(2,topicid);
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

	@Override
	public boolean insertTopic(String topic,int marks) {
	
		String query = "insert into topics_16189(topic_name,topic_marks) values(?,?)";
		try {
			PreparedStatement prep = con.prepareStatement(query);
			prep.setString(1,topic);
			prep.setInt(2,marks);
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



	@Override
	public boolean insertOption(int questionid, ArrayList<String> options) {
		
		
		String query = "insert into options_16189(opt,ques_id) values(?,?)";
		try {
			int insertcount=0;
			for(int i=0;i<options.size();i++)
			{
				PreparedStatement prep = con.prepareStatement(query);
				prep.setString(1,options.get(i));
				prep.setInt(2,questionid);
				int count=prep.executeUpdate();
				if (count>0)
				{
					insertcount++;
				}
			}
			if(insertcount==options.size())
				return true;
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}


	@Override
	public boolean insertQuestionOptions(Question question) {
		// TODO Auto-generated method stub
		
		if(insertQuestion(question.getQues(), question.getTopic().getTopicid())&&insertOption(question.getQues_id(),question.getOpt()))
		{
			return true;
		}
		return false;
	}

	
	
}
