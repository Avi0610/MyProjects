package com.avinash.etutors.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.avinash.etutors.daos.TutorSearchingConditionsDaos;
import com.avinash.etutors.pojos.TutorBasicDetails;

/**
 * Servlet implementation class SearchTutorByPincode
 */
@WebServlet("/SearchTutorByPincode")
public class SearchTutorByPincode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchTutorByPincode() {
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
		//doGet(request, response);
		String pinCode;
		if(request.getParameter("SearchedPinCode") != null && request.getParameter("SearchedPinCode").trim().length() > 0) {
			pinCode = new String(request.getParameter("SearchedPinCode"));			
			ArrayList<TutorBasicDetails> listTutors = new ArrayList<TutorBasicDetails>();
			TutorSearchingConditionsDaos tutorSearchingConditionsDaos = new TutorSearchingConditionsDaos();
			listTutors = tutorSearchingConditionsDaos.findByTutorPinCode(pinCode);
			if(listTutors.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("JSP-PAGES/NoTutorsFound.jsp");
				rd.forward(request, response);
			}
			request.setAttribute("tutorList", listTutors);
			RequestDispatcher rd = request.getRequestDispatcher("JSP-PAGES/TutorsList.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("JSP-PAGES/SearchTutorByPinCode.jsp");
			rd.forward(request, response);
		}
		

	}

}
