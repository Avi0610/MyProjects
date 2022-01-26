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
<h1 align="center">Coaching Login</h1>
<div class="form" align="center">
<form action="/E_Tutors/CoachingLogin" method="post" class="thisform">
<p>Email: </p>
<input  type="email" name="email" id="email" placeholde="enter your email" required>
<p>Password: </p>
<input  type="password" name="password" id="password" placeholde="enter your email" required><br><br>

<input type="submit" value="Find">
</form>
</div>
<div class="links" align="right">
<a href="/E_Tutors/JSP-PAGES/ForgotPasswordCoaching.jsp"><font color="#990000">Forgot Password ?</font></a>
<br><br>
<a href="/E_Tutors/JSP-PAGES/CoachingRegistration.jsp"><font color="#990000">Not Registered As A Coaching Institute? SignUp Now..</font></a>
</div>


</body>
</html>