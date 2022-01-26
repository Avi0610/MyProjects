<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/E_Tutors/resources/FormStyle.css"
	media="all" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:#c6ffb3">
<%@include file="Heading.jsp" %>
<br>
<div>
<h1 align="center">User Login</h1>
</div>
<div class="form" align="center">
<form action="/E_Tutors/UserLogin" method="post" class="thisform">
<p align="left">Email :</p> 
<input  type="email" name="email" id="email" placeholder="enter your email" required>
<p align="left">Email :</p> 
<input  type="password" name="password" id="password" placeholder="enter your password" required>
<input type="submit" value="Login">
</form>
</div>
<div class="links" align="right">
<a href="/E_Tutors/JSP-PAGES/ForgotPasswordUser.jsp" class="link"> <font color="#990000">Forgot Password?</font></a>
<br><br>
<a href="/E_Tutors/JSP-PAGES/UserRegistration.jsp" class="link"> <font color="#990000">Not Registered As A User? SignUp Now..</font></a>
</div>
</body>
</html>