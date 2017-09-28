package com.inautix.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inautix.model.User;
import com.inautix.serviceimpl.LoginServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private LoginServiceImpl loginService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
        loginService=new LoginServiceImpl();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		boolean auth=loginService.authenticate(username, password);
		RequestDispatcher rd=request.getRequestDispatcher("OES.jsp");
		RequestDispatcher rd2=request.getRequestDispatcher("error.jsp");
		if(auth)
		{
			User user=loginService.userDetails(loginService.userId(username, password));
			System.out.println(user.getName());
			request.setAttribute("user", user);
			rd.forward(request, response);
		}
		else
			rd2.forward(request, response);
		
	}

}
