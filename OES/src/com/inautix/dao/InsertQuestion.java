package com.inautix.dao;

import java.util.ArrayList;

import com.inautix.model.Question;

public interface InsertQuestion {


	public boolean insertQuestion(String question,int topicid);
	
	public boolean insertOption(int questionid,ArrayList<String> options);
	
	public boolean insertQuestionOptions(Question question);
	
	public boolean insertTopic(String topic,int marks);

	
	
	
}
