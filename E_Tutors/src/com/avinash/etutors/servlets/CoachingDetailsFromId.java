package com.avinash.etutors.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.avinash.etutors.daos.CoachingDetailsDaos;
import com.avinash.etutors.daos.CoachingSearchingConditionsDaos;
import com.avinash.etutors.daos.CoachingTeachingDetailsDaos;
import com.avinash.etutors.daos.TutorBasicDetailsDaos;
import com.avinash.etutors.daos.TutorSearchingConditionsDaos;
import com.avinash.etutors.pojos.CoachingDetails;
import com.avinash.etutors.pojos.CoachingTeachingDetails;
import com.avinash.etutors.pojos.TutorBasicDetails;
import com.avinash.etutors.pojos.TutorTeachingDetails;

/**
 * Servlet implementation class CoachingDetailsFromId
 */
@WebServlet("/CoachingDetailsFromId")
public class CoachingDetailsFromId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoachingDetailsFromId() {
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
		
		int coachingId = Integer.parseInt(request.getParameter("coachingId"));
		CoachingDetailsDaos coachingDetailsDaos = new CoachingDetailsDaos();
		CoachingDetails coachingDetails = new CoachingDetails();
		coachingDetails = coachingDetailsDaos.findByCoachingId(coachingId);
		ArrayList<CoachingTeachingDetails> listTeachingDetails = new ArrayList<CoachingTeachingDetails>();
		CoachingTeachingDetailsDaos coachingTeachingDetailsDaos = new CoachingTeachingDetailsDaos();
		listTeachingDetails = coachingTeachingDetailsDaos.findTeachingDetailsById(coachingId);
		if(coachingDetails.equals(null)) {
			RequestDispatcher rd = request.getRequestDispatcher("JSP-PAGES/NoTutorsFound.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("coachingDetails", coachingDetails);
			request.setAttribute("coachingTeachingDetails", listTeachingDetails);
			RequestDispatcher rd = request.getRequestDispatcher("JSP-PAGES/CoachingDetails.jsp");
			rd.forward(request, response);
		}
		
	}

}
