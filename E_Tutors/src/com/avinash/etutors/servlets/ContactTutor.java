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
 * Servlet implementation class ContactTutor
 */
@WebServlet("/ContactTutor")
public class ContactTutor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactTutor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		int tutorId = Integer.parseInt(request.getParameter("tutorId"));
		int userId = (int) request.getSession().getAttribute("userId");
		
		PrintWriter out = response.getWriter();
		
		TutorBasicDetails tutorBasicDetails = new TutorBasicDetails();
		TutorBasicDetailsDaos tutorBasicDetailsDaos = new TutorBasicDetailsDaos();
		
		Users user =  new Users();
		UsersDaos usersDaos = new UsersDaos();
		
		user = usersDaos.findByUserId(userId);
		tutorBasicDetails = tutorBasicDetailsDaos.findByTutorById(tutorId);
		
		String to = tutorBasicDetails.getEmail().trim();
		String subject = new String("Please Contact Me Sir");
		String myPhone = user.getMobile();
		String eMail = user.getEmail();
		String pinCode = user.getPinCode();
		String name = user.getUserName();
		String msg = new String("Please Contact Me Sir I am From\n"+"pincode = "+pinCode+"\n"+"My Email Id is = "+eMail+"\n"+"My Conatct Number is"+myPhone+"\n"+"And My Name is"+name);
		Mailer.send(to, subject, msg);	
		out.print("message has been sent successfully");
		out.close();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
