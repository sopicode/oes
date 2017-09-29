package com.inautix.test;

import com.inautix.daoimpl.DeleteQuestionImpl;
import com.inautix.daoimpl.InsertQuestionImpl;
import com.inautix.model.Question;

public class TestQueries {

	public static void main(String args[])
	{
		InsertQuestionImpl o=new InsertQuestionImpl();
	//	System.out.println(o.rowCount("users_16189"));
//		System.out.println(o.insertQuestion("asasa", 1));
//		System.out.println(o.insertTopic("asas", 212));
		DeleteQuestionImpl d=new DeleteQuestionImpl();
		Question q=new Question();
		q.setQues_id(2);
		System.out.println(d.deleteQuestion(q));
		
	}
	
}
