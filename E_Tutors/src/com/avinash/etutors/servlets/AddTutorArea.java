package com.avinash.etutors.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.avinash.etutors.daos.TutorAreaDetailsDaos;
import com.avinash.etutors.daos.TutorTeachingDetailsDao;
import com.avinash.etutors.pojos.TutorAreaDetails;
import com.avinash.etutors.pojos.TutorTeachingDetails;

/**
 * Servlet implementation class AddTutorArea
 */
@WebServlet("/AddTutorArea")
public class AddTutorArea extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTutorArea() {
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
		int tutorId;
		int tutorAreaId = 0;
		tutorId = (int) request.getSession().getAttribute("tutorId");
		
		if(request.getParameter("tutorAreaId") != null  && request.getParameter("tutorAreaId").length() > 0)
			tutorAreaId = Integer.parseInt(request.getParameter("tutorAreaId"));
		
		String pinCode = request.getParameter("pinCode");
		if (pinCode == null) {
			pinCode = new String();
		}
		
		String operation = request.getParameter("operation");
		if (operation == null) {
			operation = new String();
		}
		
		TutorAreaDetailsDaos tutorAreaDetailsDaos = new TutorAreaDetailsDaos();

		if (operation.equals("create")) {
			
			TutorAreaDetails tutorAreaDetails = new TutorAreaDetails();
			tutorAreaDetails.setTutorId(tutorId);
			tutorAreaDetails.setPinCode(pinCode);
			tutorAreaDetails.setTutorAreaId(tutorAreaId);
			tutorAreaDetailsDaos.createTeachingDet(tutorAreaDetails);
			
		} else if (operation.equals("edit")) {
			TutorAreaDetails tutorAreaDetails = new TutorAreaDetails();
			tutorAreaDetails.setTutorAreaId(tutorAreaId);
			tutorAreaDetails.setPinCode(pinCode);
			tutorAreaDetailsDaos.updateArea(tutorAreaDetails);
		} else if (operation.equals("remove")) {
			tutorAreaDetailsDaos.remove(tutorAreaId);
		}
		
		
		//TutorAreaDetailsDaos tutorAreaDetailsDaos = new TutorAreaDetailsDaos();
		ArrayList<TutorAreaDetails> listArea = new ArrayList<TutorAreaDetails>();
		listArea = tutorAreaDetailsDaos.findAllByTutorId(tutorId);
		
		request.setAttribute("tutorArea", listArea);
		
		RequestDispatcher rd = request.getRequestDispatcher("JSP-PAGES/AddTutorArea.jsp");
		rd.forward(request, response);

		
		

	}

}
