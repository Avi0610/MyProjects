<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="/E_Tutors/resources/FormStyle.css"
	media="all" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot Password</title>
</head>
<body style="background-color:#c6ffb3">
<%@include file="Heading.jsp" %>
<br>
<h1 align="center">OHHHH!! You Forgot Your Password</h1>
<h5 align="center">Don't worry we will help</h5>
<div class="form" align="center">
<form action="/E_Tutors/ForgotPasswordUser" method="post" class="thisform">

<p align="left">Email :</p>
<input  type="email" name="email" id="email" placeholder="enter your email" required><br><br>

<input type="submit" value="Find">
</form>
</div>
<h5 align="center">You will receive an email containing your password</h5>
</body>
</html>