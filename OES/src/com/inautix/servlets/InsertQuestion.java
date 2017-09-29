package com.inautix.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inautix.daoimpl.InsertQuestionImpl;

/**
 * Servlet implementation class InsertQuestion
 */
@WebServlet("/InsertQuestion")
public class InsertQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	InsertQuestionImpl insertquestion;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertQuestion() {
        super();
        insertquestion=new InsertQuestionImpl();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<String> list=new ArrayList<>();
		for(char i='A';i<='Z';i++)
		{
			System.out.println("opt"+i);
			String opt=request.getParameter("opt"+i);
			if(opt!=null)
				list.add(opt);
		}
		
	}

}
