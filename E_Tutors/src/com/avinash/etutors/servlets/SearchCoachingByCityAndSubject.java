package com.avinash.etutors.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.avinash.etutors.daos.CoachingSearchingConditionsDaos;
import com.avinash.etutors.pojos.CoachingDetails;

/**
 * Servlet implementation class SearchCoachingByCityAndSubject
 */
@WebServlet("/SearchCoachingByCityAndSubject")
public class SearchCoachingByCityAndSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCoachingByCityAndSubject() {
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
	
		
		String SearchedCity;
		
		String SearchedSubject;
		
		if(request.getParameter("SearchedCity") != null && request.getParameter("SearchedCity").trim().length() > 0) {
			SearchedCity = new String(request.getParameter("SearchedCity"));
			
			SearchedSubject = new String(request.getParameter("SearchedSubject"));
			ArrayList<CoachingDetails> listCoachings = new ArrayList<CoachingDetails>();
			CoachingSearchingConditionsDaos coachingSearchingConditionsDaos = new CoachingSearchingConditionsDaos();
			listCoachings = coachingSearchingConditionsDaos.findByTutorByCityAndSubject(SearchedCity, SearchedSubject);
			if(listCoachings.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("JSP-PAGES/NoTutorsFound.jsp");
				rd.forward(request, response);
			}
			request.setAttribute("coachingList", listCoachings);
			RequestDispatcher rd = request.getRequestDispatcher("JSP-PAGES/CoachingList.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("JSP-PAGES/SearchCoachingByCityAndSubject.jsp");
			rd.forward(request, response);
		}
	}

}
