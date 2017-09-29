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
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/Admin")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginServiceImpl loginService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
      loginService=new LoginServiceImpl();
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		boolean auth=loginService.authenticate(username, password,"admin_16189");
		RequestDispatcher rd=request.getRequestDispatcher("Adminpage.jsp");
		RequestDispatcher rd2=request.getRequestDispatcher("../error.jsp");
		if(auth)
		{
			User user=loginService.userDetails(loginService.userId(username, password,"admin_16189"),"admin_16189");
			System.out.println(user.getName());
			request.setAttribute("user", user);
			rd.forward(request, response);
		}
		else
			rd2.forward(request, response);
	}

}
