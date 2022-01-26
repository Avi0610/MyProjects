package com.avinash.etutors.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.avinash.etutors.daos.TutorBasicDetailsDaos;

import com.avinash.etutors.daos.TutorTeachingDetailsDao;

import com.avinash.etutors.pojos.TutorTeachingDetails;
import com.mysql.cj.Session;

/**
 * Servlet implementation class AddTutorClass
 */
@WebServlet("/AddTutorClass")
public class AddTutorClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTutorClass() {
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
		//response.getWriter().append("Served at: ").append("");
		
		int tutorId;
		int teachingDetId = 0;
		
		tutorId = (int) request.getSession().getAttribute("tutorId");
		if(request.getParameter("teachingDetId") != null  && request.getParameter("teachingDetId").length() > 0)
			teachingDetId = Integer.parseInt(request.getParameter("teachingDetId"));
		
		String tutorClass = request.getParameter("tutorClass");
		if (tutorClass == null) {
			tutorClass = new String();
		}
		String tutorSubject = request.getParameter("tutorSubject");
		if (tutorSubject == null) {
			tutorSubject = new String();
		}
		String operation = request.getParameter("operation");
		if (operation == null) {
			operation = new String();
		}
		
		TutorTeachingDetailsDao tutorTeachingDetailsDaos = new TutorTeachingDetailsDao();

		if (operation.equals("create")) {
			
			TutorTeachingDetails tutorTeachingDetails = new TutorTeachingDetails();
			tutorTeachingDetails.setTutorId(tutorId);
			tutorTeachingDetails.setTeachingClass(tutorClass);
			tutorTeachingDetails.setTeachingSubject(tutorSubject);
			tutorTeachingDetailsDaos.createTeachingDet(tutorTeachingDetails);
			
		} else if (operation.equals("edit")) {
			TutorTeachingDetails tutorTeachingDetails = new TutorTeachingDetails();
			tutorTeachingDetails.setTechingdetId(teachingDetId);
			tutorTeachingDetails.setTeachingClass(tutorClass);
			tutorTeachingDetails.setTeachingSubject(tutorSubject);
			tutorTeachingDetailsDaos.edit(tutorTeachingDetails);
		} else if (operation.equals("remove")) {
			tutorTeachingDetailsDaos.remove(teachingDetId);
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
		ArrayList<TutorTeachingDetails> listTutorClass = new ArrayList<TutorTeachingDetails>();
		listTutorClass = tutorTeachingDetailsDaos.findTeachingDetailsById(tutorId);
		request.setAttribute("tutorClass", listTutorClass);

		RequestDispatcher rd = request.getRequestDispatcher("JSP-PAGES/AddTutorClass.jsp");
		rd.forward(request, response);

		
	}

}
