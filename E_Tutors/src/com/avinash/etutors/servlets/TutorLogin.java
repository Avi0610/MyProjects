package com.avinash.etutors.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.avinash.etutors.daos.TutorBasicDetailsDaos;
import com.avinash.etutors.daos.UsersDaos;

/**
 * Servlet implementation class TutorLogin
 */
@WebServlet("/TutorLogin")
public class TutorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TutorLogin() {
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
		int tutorId;
		
		HttpSession session = request.getSession();
		
		email = request.getParameter("email");
		password = request.getParameter("password");
		
		if(email != null && password != null) {
			TutorBasicDetailsDaos tutorBasicDetailsDaos = new TutorBasicDetailsDaos();
			tutorId = tutorBasicDetailsDaos.verify(email, password);
			if(tutorId == -1) {
				RequestDispatcher rd = request.getRequestDispatcher("JSP-PAGES/TutorRegistration.jsp");
				rd.forward(request, response);
			}
			else {
				session.setAttribute("tutorId", tutorId); 
				RequestDispatcher rd = request.getRequestDispatcher("JSP-PAGES/TutorDashBoard.jsp");
				rd.forward(request, response);
			}
			
		}
		else {
			
			RequestDispatcher rd = request.getRequestDispatcher("JSP-PAGES/TutorLogin.jsp");
			rd.forward(request, response);

		}
	}

}
