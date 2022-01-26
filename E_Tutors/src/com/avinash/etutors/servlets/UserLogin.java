package com.avinash.etutors.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.avinash.etutors.daos.UsersDaos;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email;
		String password;
		int userId;
		
		HttpSession session = request.getSession();
		
		email = request.getParameter("email");
		password = request.getParameter("password");
		
		if(email != null && password != null) {
			UsersDaos usersDaos = new UsersDaos();
			userId = usersDaos.verify(email, password);
			if(userId == -1) {
				RequestDispatcher rd = request.getRequestDispatcher("JSP-PAGES/UserRegistration.jsp");
				rd.forward(request, response);
			}
			else {
				session.setAttribute("userId", userId); 
				RequestDispatcher rd = request.getRequestDispatcher("JSP-PAGES/UserHome.jsp");
				rd.forward(request, response);
			}
			
		}
		else {
			
			RequestDispatcher rd = request.getRequestDispatcher("JSP-PAGES/UserLogin.jsp");
			rd.forward(request, response);

		}
		
	}

}
