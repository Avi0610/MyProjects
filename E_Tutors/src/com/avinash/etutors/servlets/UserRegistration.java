package com.avinash.etutors.servlets;

import java.io.IOException;

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
import com.mysql.cj.Session;

/**
 * Servlet implementation class UserRegistration
 */
@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession session = request.getSession();
		
		String name = request.getParameter("userName");
		String email = request.getParameter("userEmail");
		String mobile = request.getParameter("userMobileNo");
		String city = request.getParameter("userCity");
		String userPinCode = request.getParameter("userPinCode");
		String gender  = request.getParameter("userGender");
		String dob = request.getParameter("userDob");
		String pass = request.getParameter("userPassword");
		
		String newDob = dob.replace("/", "-");
		
		Users user = new Users();
		user.setUserName(name);
		user.setEmail(email);
		user.setMobile(mobile);
		user.setCity(city);
		user.setPinCode(userPinCode);
		user.setGender(gender);
		user.setDob(DateUtils.convertDate(newDob));
		user.setPassword(pass);
		
		UsersDaos usersDaos = new UsersDaos();
		
		int userId;
		userId = usersDaos.createUser(user);
		session.setAttribute("userId", userId); 
		if(userId > 0) {
			RequestDispatcher rd = request.getRequestDispatcher("JSP-PAGES/UserHome.jsp");
			rd.forward(request, response);
		}
		else {
			response.getWriter().append("Served at: ").append("User Already Exists");

		}

		

	}

}
