package com.avinash.etutors.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.avinash.etutors.daos.CoachingDetailsDaos;
import com.avinash.etutors.daos.TutorBasicDetailsDaos;

/**
 * Servlet implementation class CoachingLogin
 */
@WebServlet("/CoachingLogin")
public class CoachingLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoachingLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String email;
		String password;
		int coachingId;
		
		HttpSession session = request.getSession();
		
		email = request.getParameter("email");
		password = request.getParameter("password");
		
		if(email != null && password != null) {
			CoachingDetailsDaos coachingDetailsDaos = new CoachingDetailsDaos();
			coachingId = coachingDetailsDaos.verify(email, password);
			if(coachingId == -1) {
				RequestDispatcher rd = request.getRequestDispatcher("JSP-PAGES/CoachingRegistration.jsp");
				rd.forward(request, response);
			}
			else {
				session.setAttribute("coachingId", coachingId); 
				RequestDispatcher rd = request.getRequestDispatcher("JSP-PAGES/CoachingDashBoard.jsp");
				rd.forward(request, response);
			}
			
		}
		else {
			
			RequestDispatcher rd = request.getRequestDispatcher("JSP-PAGES/CoachingLogin.jsp");
			rd.forward(request, response);

		}
	}

}
