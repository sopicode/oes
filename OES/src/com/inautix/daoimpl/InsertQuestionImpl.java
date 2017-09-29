package com.inautix.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.inautix.dao.InsertQuestion;
import com.inautix.jdbc.connection.DatabaseConnection;
import com.inautix.model.Question;

public class InsertQuestionImpl implements InsertQuestion {

	private DatabaseConnection databasecon;
	private Connection con;

	public InsertQuestionImpl() {
		con = databasecon.getConnection();
	}

	public int rowCount(String tableName) {
		String query = "select count(*) as rowcount from " + tableName;
		ResultSet rs;
		try {
			PreparedStatement prep = con.prepareStatement(query);
			rs = prep.executeQuery();
			if (rs.next()) {
				return rs.getInt("rowcount");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return -1;
	}

	@Override
	public boolean insertQuestion(String question, int topicid) {

		int quesid = rowCount("questions_16189") + 1;
		String query = "insert into questions_16189(ques_id,ques,topic_id) values(?,?,?)";
		try {
			PreparedStatement prep = con.prepareStatement(query);
			prep.setInt(1, quesid);
			prep.setString(2, question);
			prep.setInt(3, topicid);
			int count = prep.executeUpdate();
			if (count > 0) {
				return true;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;

	}

	@Override
	public boolean insertTopic(String topic, int marks) {

		int topicid = rowCount("topics_16189") + 1;
		String query = "insert into topics_16189 values(?,?,?)";
		try {
			PreparedStatement prep = con.prepareStatement(query);
			prep.setInt(1, topicid);
			prep.setString(2, topic);
			prep.setInt(3, marks);
			int count = prep.executeUpdate();
			if (count > 0) {
				return true;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;

	}

	@Override
	public boolean insertOption(int questionid, ArrayList<String> options) {

		int optionid = rowCount("options_16189") + 1;
		String query = "insert into options_16189 values(?,?,?)";
		try {
			int insertcount = 0;
			for (int i = 0; i < options.size(); i++) {
				PreparedStatement prep = con.prepareStatement(query);
				prep.setInt(1, optionid);
				prep.setString(2, options.get(i));
				prep.setInt(3, questionid);
				int count = prep.executeUpdate();
				if (count > 0) {
					insertcount++;
				}
			}
			if (insertcount == options.size())
				return true;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean insertQuestionOptions(Question question) {
		// TODO Auto-generated method stub

		if (insertQuestion(question.getQues(), question.getTopic().getTopicid())
				&& insertOption(question.getQues_id(), question.getOpt())) {
			return true;
		}
		return false;
	}

}
