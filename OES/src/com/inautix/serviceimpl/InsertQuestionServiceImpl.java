package com.inautix.serviceimpl;

import java.util.ArrayList;


import com.inautix.daoimpl.InsertQuestionImpl;
import com.inautix.model.Question;
import com.inautix.service.InsertQuestionService;

public class InsertQuestionServiceImpl implements InsertQuestionService {

	InsertQuestionImpl insertquestiondao;

	public InsertQuestionServiceImpl() {
		insertquestiondao=new InsertQuestionImpl();
	}
	
	
	@Override
	public boolean insertQuestion(String question, int topicid) {
		// TODO Auto-generated method stub
		return insertquestiondao.insertQuestion(question, topicid);
	}

	@Override
	public boolean insertOption(int questionid, ArrayList<String> options) {
		// TODO Auto-generated method stub
		return insertquestiondao.insertOption(questionid, options);
	}

	@Override
	public boolean insertQuestionOptions(Question question) {
		// TODO Auto-generated method stub
		return insertquestiondao.insertQuestionOptions(question);
	}

	@Override
	public boolean insertTopic(String topic, int marks) {
		// TODO Auto-generated method stub
		return insertquestiondao.insertTopic(topic, marks);
	}

}
