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
 * Servlet implementation class SearchTutorByPinCodeAndClass
 */
@WebServlet("/SearchTutorByPinCodeAndClass")
public class SearchTutorByPinCodeAndClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchTutorByPinCodeAndClass() {
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
		String pinCode;
		String SearchedClass;
		
		if(request.getParameter("SearchedPinCode") != null && request.getParameter("SearchedPinCode").trim().length() > 0) {
			pinCode = new String(request.getParameter("SearchedPinCode"));
			SearchedClass = new String(request.getParameter("SearchedClass"));
			ArrayList<TutorBasicDetails> listTutors = new ArrayList<TutorBasicDetails>();
			TutorSearchingConditionsDaos tutorSearchingConditionsDaos = new TutorSearchingConditionsDaos();
			listTutors = tutorSearchingConditionsDaos.findByTutorPinCodeAndClass(SearchedClass, pinCode);
			if(listTutors.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("JSP-PAGES/NoTutorsFound.jsp");
				rd.forward(request, response);
			}
			request.setAttribute("tutorList", listTutors);
			RequestDispatcher rd = request.getRequestDispatcher("JSP-PAGES/TutorsList.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("JSP-PAGES/SearchTutorByPinCodeAndClass.jsp");
			rd.forward(request, response);
		}
		
	}

}
