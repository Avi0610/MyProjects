package com.avinash.etutors.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.avinash.etutors.daos.CoachingTeachingDetailsDaos;
import com.avinash.etutors.daos.TutorTeachingDetailsDao;
import com.avinash.etutors.pojos.CoachingTeachingDetails;
import com.avinash.etutors.pojos.TutorTeachingDetails;

/**
 * Servlet implementation class AddCoachingTeachingDet
 */
@WebServlet("/AddCoachingTeachingDet")
public class AddCoachingTeachingDet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCoachingTeachingDet() {
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
		
		
		int coachingId;
		int coachingDetId = 0;
		
		coachingId = (int) request.getSession().getAttribute("coachingId");
		if(request.getParameter("coachingDetId") != null  && request.getParameter("coachingDetId").length() > 0)
			coachingDetId = Integer.parseInt(request.getParameter("coachingDetId"));
		
		String coachingClass = request.getParameter("coachingClass");
		if (coachingClass == null) {
			coachingClass = new String();
		}
		String coachingSubject = request.getParameter("coachingSubject");
		if (coachingSubject == null) {
			coachingSubject = new String();
		}
		String operation = request.getParameter("operation");
		if (operation == null) {
			operation = new String();
		}
		
		CoachingTeachingDetailsDaos coachingTeachingDetailsDaos = new CoachingTeachingDetailsDaos();

		if (operation.equals("create")) {
			
			CoachingTeachingDetails coachingTeachingDetails = new CoachingTeachingDetails();
			coachingTeachingDetails.setCoachingId(coachingId);
			coachingTeachingDetails.setCoachingClass(coachingClass);
			coachingTeachingDetails.setcoachingSubject(coachingSubject);
			coachingTeachingDetailsDaos.createTeachingDet(coachingTeachingDetails);
			
		} else if (operation.equals("edit")) {
			CoachingTeachingDetails coachingTeachingDetails = new CoachingTeachingDetails();
			coachingTeachingDetails.setCaochingTeachDetId(coachingDetId);
			coachingTeachingDetails.setCoachingClass(coachingClass);
			coachingTeachingDetails.setcoachingSubject(coachingSubject);
			coachingTeachingDetailsDaos.edit(coachingTeachingDetails);
		} else if (operation.equals("remove")) {
			coachingTeachingDetailsDaos.remove(coachingDetId);
		}
		
		
//		if(request.getParameter("tutorClass") != null && request.getParameter("tutorClass").trim().length() > 0) {
//			
//			String tutorClass = request.getParameter("tutorClass");
//			String tutorSubject = request.getParameter("tutorSubject");
//			
//			TutorTeachingDetails tutorTeachingDetails = new TutorTeachingDetails();
//			tutorTeachingDetails.setTutorId((int) ( request.getSession().getAttribute("tutorId")));
//			tutorTeachingDetails.setTeachingClass(tutorClass);
//			tutorTeachingDetails.setTeachingSubject(tutorSubject);
//			TutorTeachingDetailsDao tutorTeachingDetailsDaos = new TutorTeachingDetailsDao();
//			tutorTeachingDetailsDaos.createTeachingDet(tutorTeachingDetails);
//		}
		
		
		
		//TutorTeachingDetailsDao tutorTeachingDetailsDaos = new TutorTeachingDetailsDao();
		ArrayList<CoachingTeachingDetails> listCoaching = new ArrayList<CoachingTeachingDetails>();
		listCoaching = coachingTeachingDetailsDaos.findTeachingDetailsById(coachingId);
		request.setAttribute("coachingList", listCoaching);

		RequestDispatcher rd = request.getRequestDispatcher("JSP-PAGES/AddCoachingTeachingDet.jsp");
		rd.forward(request, response);

	}

}
