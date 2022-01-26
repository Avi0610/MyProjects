package com.avinash.etutors.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.avinash.etutors.daos.TutorBasicDetailsDaos;
import com.avinash.etutors.daos.UsersDaos;
import com.avinash.etutors.pojos.TutorBasicDetails;
import com.avinash.etutors.pojos.Users;
import com.avinash.etutors.utilities.Mailer;

/**
 * Servlet implementation class ContactUs
 */
@WebServlet("/ContactUs")
public class ContactUs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactUs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		int userId = (int) request.getSession().getAttribute("userId");
		
		PrintWriter out = response.getWriter();
		
	
		
		Users user =  new Users();
		UsersDaos usersDaos = new UsersDaos();
		
		user = usersDaos.findByUserId(userId);
		
		String msg = request.getParameter("message");
		String to = new String("doremondisney9@gmail.com");
		String subject = new String("Some One Needs Help");
		String myPhone = user.getMobile();
		String eMail = user.getEmail();
		String pinCode = user.getPinCode();
		String name = user.getUserName();
		String sendMsg = new String(msg+"\n"+"My Email Is \t"+eMail+"\n"+"My Mobile No Is \t"+myPhone+"\n"+"My Name is \t"+name);
		Mailer.send(to, subject, sendMsg);	
		out.print("message has been sent successfully");
		out.close();
		
	}

}
