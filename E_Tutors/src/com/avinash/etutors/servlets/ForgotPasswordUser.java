package com.avinash.etutors.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.avinash.etutors.daos.CoachingDetailsDaos;
import com.avinash.etutors.daos.UsersDaos;
import com.avinash.etutors.pojos.CoachingDetails;
import com.avinash.etutors.pojos.Users;
import com.avinash.etutors.utilities.Mailer;

/**
 * Servlet implementation class ForgotPasswordUser
 */
@WebServlet("/ForgotPasswordUser")
public class ForgotPasswordUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("email");
		Users users = new Users();
		UsersDaos usersDaos = new UsersDaos();
		users = usersDaos.findByUserEmail(email);
		if(users.getUserId() > 0) {
			String pass = users.getPassword().trim();
			String to = users.getEmail().trim();
			String name = users.getUserName().trim();
			String subject = new String("E_TUTORS SUPPORT TEAM");
			String msg = new String("hello\t"+name+"\n"+"your password is\t"+pass);
			Mailer.send(to, subject, msg);
			RequestDispatcher rd = request.getRequestDispatcher("JSP-PAGES/UserLogin.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("JSP-PAGES/NoTutorsFound.jsp");
			rd.forward(request, response);
		}
	}

}
