package com.inautix.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inautix.serviceimpl.InsertQuestionServiceImpl;

/**
 * Servlet implementation class InsertTopic
 */
@WebServlet("/InsertTopic")
public class InsertTopic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	InsertQuestionServiceImpl inserttopic;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertTopic() {
        super();
        inserttopic=new InsertQuestionServiceImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
				if(inserttopic.insertTopic(request.getParameter("topic"), Integer.parseInt(request.getParameter("marks"))))
				{
					RequestDispatcher rd=request.getRequestDispatcher("Adminpage.jsp");
					rd.include(request, response);
				}
		
		
	}

}
