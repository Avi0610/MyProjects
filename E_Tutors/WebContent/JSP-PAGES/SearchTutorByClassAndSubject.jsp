<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="/E_Tutors/resources/FormStyle.css"
	media="all" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Coaching</title>
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
<br>
<br>
<br>
<div class="form" align="center">
<form action="/E_Tutors/SearchTutorByClassAndSubject" method="post" class="thisform">

    <p align="left">Class</p>
    <input type="text" placeholder="Enter The Class" name="SearchedClass" id="SearchedClass" minlength="1"  required><br><br>
	
	<p align="left">Subject</p>
	    <input type="text" placeholder="Enter The Subject" name="SearchedSubject" id="SearchedSubject" minlength="1"  required><br><br>
	

<input type="submit" value="Serach" name="submit" id="submit" text="Search">



</form>
</div>
</body>
</html>