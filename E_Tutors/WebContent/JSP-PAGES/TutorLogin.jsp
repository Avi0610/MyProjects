<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/E_Tutors/resources/FormStyle.css"
	media="all" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Tutor Login</title>
</head>
<body style="background-color:#c6ffb3">
<%@include file="Heading.jsp" %>
<br>
<h1 align="center">Home Tutor Login</h1>
<div class="form" align="center">
<form action="/E_Tutors/TutorLogin" method="post" class="thisform">
<p align="left">Email :</p> 
<input  type="email" name="email" id="email" placeholder="enter your email" required>
<p align="left">Email :</p> 
<input  type="password" name="password" id="password" placeholder="enter your password" required>

<input type="submit" value="Find">
</form>
</div>
<div class="links" align="right">
<a href="/E_Tutors/JSP-PAGES/ForgotPasswordTutor.jsp"><font color="#990000">Forgot Password?</font></a><br><br>
<a href="/E_Tutors/JSP-PAGES/TutorRegistration.jsp"><font color="#990000">Not Registered As A Tutor? SignUp Now..</font></a>
</div>
</body>
</html>