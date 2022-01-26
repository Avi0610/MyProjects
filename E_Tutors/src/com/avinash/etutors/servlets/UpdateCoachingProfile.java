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
import com.avinash.etutors.daos.CoachingTeachingDetailsDaos;
import com.avinash.etutors.pojos.CoachingDetails;

/**
 * Servlet implementation class UpdateCoachingProfile
 */
@WebServlet("/UpdateCoachingProfile")
public class UpdateCoachingProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCoachingProfile() {
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
		
		HttpSession session = request.getSession();
		
		int coachingId = (int) request.getSession().getAttribute("coachingId");
		
		if(request.getParameter("name") != null && request.getParameter("name").trim().length() > 0) {
			
			String email = request.getParameter("email");
			String mobile  = request.getParameter("mobileNo");
			String city = request.getParameter("city");
			String name  = request.getParameter("name");
			String det = request.getParameter("description");
			String pass = request.getParameter("password");
			
			CoachingDetails coachingDetails = new CoachingDetails();
			coachingDetails.setCoachingDetId(coachingId);
			coachingDetails.setEmail(email);
			coachingDetails.setCity(city);
			coachingDetails.setMobile(mobile);
			coachingDetails.setInstitutionName(name);
			coachingDetails.setDetails(det);
			coachingDetails.setPassword(pass);
			
			CoachingDetailsDaos coachingDetailsDaos = new CoachingDetailsDaos();
			coachingDetailsDaos.edit(coachingDetails);
			
			RequestDispatcher rd = request.getRequestDispatcher("JSP-PAGES/CoachingDashBoard.jsp");
			rd.forward(request, response);
			
			
		}
		
		else {
			CoachingDetails coachingDetails = new CoachingDetails();
			CoachingDetailsDaos coachingDetailsDaos = new CoachingDetailsDaos();
			coachingDetails = coachingDetailsDaos.findByCoachingId(coachingId);
			request.setAttribute("coachingDet", coachingDetails);
			RequestDispatcher rd = request.getRequestDispatcher("JSP-PAGES/UpdateCoachingProfile.jsp");
			rd.forward(request, response);
		}
	}

}
