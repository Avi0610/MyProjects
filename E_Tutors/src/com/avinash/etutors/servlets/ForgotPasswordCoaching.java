package com.avinash.etutors.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.avinash.etutors.daos.CoachingDetailsDaos;
import com.avinash.etutors.daos.CoachingTeachingDetailsDaos;
import com.avinash.etutors.pojos.CoachingDetails;
import com.avinash.etutors.utilities.Mailer;

/**
 * Servlet implementation class ForgotPasswordCoaching
 */
@WebServlet("/ForgotPasswordCoaching")
public class ForgotPasswordCoaching extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordCoaching() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		CoachingDetails coachingDetails = new CoachingDetails();
		CoachingDetailsDaos coachingDetailsDaos = new CoachingDetailsDaos();
		coachingDetails = coachingDetailsDaos.findByCoachingEmail(email);
		if(coachingDetails.getCoachingDetId() > 0) {
			String pass = coachingDetails.getPassword().trim();
			String to = coachingDetails.getEmail().trim();
			String name = coachingDetails.getInstitutionName().trim();
			String subject = new String("E_TUTORS SUPPORT TEAM");
			String msg = new String("hello\t"+name+"\n"+"your password is\t"+pass);
			Mailer.send(to, subject, msg);
			RequestDispatcher rd = request.getRequestDispatcher("JSP-PAGES/CoachingLogin.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("JSP-PAGES/NoTutorsFound.jsp");
			rd.forward(request, response);
		}
		
	}

}
