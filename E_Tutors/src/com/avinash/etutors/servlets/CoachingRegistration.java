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
import com.avinash.etutors.pojos.CoachingDetails;

/**
 * Servlet implementation class CoachingRegistration
 */
@WebServlet("/CoachingRegistration")
public class CoachingRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoachingRegistration() {
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
		
		HttpSession session = request.getSession(true);
		
		String email = request.getParameter("email");
		String mobile  = request.getParameter("mobileNo");
		String city = request.getParameter("city");
		String name  = request.getParameter("name");
		String det = request.getParameter("description");
		String pass = request.getParameter("password");
		
		CoachingDetails coachingDetails = new CoachingDetails();
		coachingDetails.setEmail(email);
		coachingDetails.setCity(city);
		coachingDetails.setMobile(mobile);
		coachingDetails.setInstitutionName(name);
		coachingDetails.setDetails(det);
		coachingDetails.setPassword(pass);
		
		CoachingDetailsDaos coachingDetailsDaos = new CoachingDetailsDaos();
		int id = coachingDetailsDaos.createCoachingDetails(coachingDetails);
		session.setAttribute("coachingId", id);
		if(id > 0) {
			RequestDispatcher rd = request.getRequestDispatcher("AddCoachingTeachingDet");
			rd.forward(request, response);
		}
		else {
			response.getWriter().append("Served at: ").append("User Already Exists");

		}
		
		
	}

}
