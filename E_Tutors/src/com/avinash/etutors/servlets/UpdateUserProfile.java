package com.avinash.etutors.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.avinash.etutors.daos.UsersDaos;
import com.avinash.etutors.pojos.Users;
import com.avinash.etutors.utilities.DateUtils;

/**
 * Servlet implementation class UpdateUserProfile
 */
@WebServlet("/UpdateUserProfile")
public class UpdateUserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserProfile() {
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
		
		int userId = (int) request.getSession().getAttribute("userId");
		
		if(request.getParameter("userName") != null && request.getParameter("userName").trim().length() > 0) {
			String name = request.getParameter("userName");
			String email = request.getParameter("userEmail");
			String mobile = request.getParameter("userMobileNo");
			String city = request.getParameter("userCity");
			String userPinCode = request.getParameter("userPinCode");
			String gender  = request.getParameter("userGender");
			String dob = request.getParameter("userDob");
			
			Users user = new Users();
			user.setUserId(userId);
			user.setUserName(name);
			user.setEmail(email);
			user.setMobile(mobile);
			user.setCity(city);
			user.setPinCode(userPinCode);
			user.setGender(gender);
			user.setDob(DateUtils.convertDate(dob));
			
			UsersDaos usersDaos = new UsersDaos();
			
			usersDaos.edit(user);
			
			RequestDispatcher rd = request.getRequestDispatcher("JSP-PAGES/UserHome.jsp");
			rd.forward(request, response);
		}
		else {
			Users user = new Users();
			UsersDaos usersDaos = new UsersDaos();
			user = usersDaos.findByUserId(userId);
			request.setAttribute("userDet", user);
			RequestDispatcher rd = request.getRequestDispatcher("JSP-PAGES/UpdateUserProfile.jsp");
			rd.forward(request, response);
		}
		
	}

}
