<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="/E_Tutors/resources/FormStyle.css"
	media="all" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update User Password</title>
</head>
<body style="background-color:#c6ffb3">
<%@include file="Heading.jsp" %>
<br>
<div>
<%@include file="UserMenuBar.jsp" %>
</div>
<br>
<br>
<br>
<h1 align="center">Update Your Profile</h1>
<div class="form" align="center">


<form action="/E_Tutors/UpdateUserPassword" method="post" class="thisform">


<p align="left">Password :</p>
<input type="password" name="userPassword" id="userPassword" placeholder="enter new Password" minlength="1" maxlength="20"  required><br><br>


<input type="submit" value="submit" name="submit" id="submit">



</form>
</div>
</body>
</html>