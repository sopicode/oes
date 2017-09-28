package com.inautix.serviceimpl;

import com.inautix.daoimpl.DeleteQuestionImpl;
import com.inautix.model.Question;
import com.inautix.service.DeleteQuestionService;

public class DeleteQuestionServiceImpl implements DeleteQuestionService {

	DeleteQuestionImpl deletequestiondao;

	public DeleteQuestionServiceImpl() {
		deletequestiondao=new DeleteQuestionImpl();
	}
	
	@Override
	public boolean deleteQuestion(Question question) {
		// TODO Auto-generated method stub
		return deletequestiondao.deleteQuestion(question);
	}

}
