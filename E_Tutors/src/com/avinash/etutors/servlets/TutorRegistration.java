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
import com.avinash.etutors.pojos.TutorBasicDetails;
import com.avinash.etutors.utilities.DateUtils;

/**
 * Servlet implementation class TutorRegistration
 */
@WebServlet("/TutorRegistration")
public class TutorRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TutorRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(true);
		TutorBasicDetails tutorBasicDetails = new TutorBasicDetails();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobileNo");
		String originalCity = request.getParameter("originalCity");
		String currentCity = request.getParameter("currentCity");
		String profession = request.getParameter("profession");
		String gender = request.getParameter("gender");
		String dob = request.getParameter("dob");
		String desc = request.getParameter("description");
		String pass  = request.getParameter("password");
		
		
		tutorBasicDetails.setTutorName(name);
		tutorBasicDetails.setEmail(email);
		tutorBasicDetails.setMobile(mobile);
		tutorBasicDetails.setOriginalCity(originalCity);
		tutorBasicDetails.setPresentCity(currentCity);
		tutorBasicDetails.setProfession(profession);
		tutorBasicDetails.setGender(gender);
		tutorBasicDetails.setDob(DateUtils.convertDate(dob));
		tutorBasicDetails.setDetails(desc);
		tutorBasicDetails.setPassword(pass);
		
		TutorBasicDetailsDaos tutorBasicDetailsDaos = new TutorBasicDetailsDaos();
		int id = tutorBasicDetailsDaos.createTutorBasicDetails(tutorBasicDetails);
		session.setAttribute("tutorId", id);
		if(id > 0) {
			RequestDispatcher rd = request.getRequestDispatcher("AddTutorClass");
			rd.forward(request, response);
		}
		else {
			response.getWriter().append("Served at: ").append("User Already Exists");

		}
		
		
		
	
		
		
		
	}

}
