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
import com.avinash.etutors.daos.TutorSearchingConditionsDaos;
import com.avinash.etutors.pojos.TutorBasicDetails;
import com.avinash.etutors.pojos.TutorTeachingDetails;

/**
 * Servlet implementation class TutorDetailsFromId
 */
@WebServlet("/TutorDetailsFromId")
public class TutorDetailsFromId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TutorDetailsFromId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		int tutorId = Integer.parseInt(request.getParameter("tutorId"));
		TutorBasicDetailsDaos tutorBasicDetailsDaos = new TutorBasicDetailsDaos();
		TutorBasicDetails tutorBasicDetails = new TutorBasicDetails();
		tutorBasicDetails = tutorBasicDetailsDaos.findByTutorById(tutorId);
		ArrayList<TutorTeachingDetails> listTeachingDetails = new ArrayList<TutorTeachingDetails>();
		TutorSearchingConditionsDaos tutorSearchingConditionsDaos = new TutorSearchingConditionsDaos();
		listTeachingDetails = tutorSearchingConditionsDaos.findTeachingDetailsById(tutorId);
		if(tutorBasicDetails.equals(null)) {
			RequestDispatcher rd = request.getRequestDispatcher("JSP-PAGES/NoTutorsFound.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("tutorDetails", tutorBasicDetails);
			request.setAttribute("tutorTeachingDetails", listTeachingDetails);
			RequestDispatcher rd = request.getRequestDispatcher("JSP-PAGES/TutorsDetails.jsp");
			rd.forward(request, response);
		}
	}

}
