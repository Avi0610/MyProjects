<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="/E_Tutors/resources/FormStyle.css"
	media="all" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Coaching Registration</title>
</head>
<body style="background-color:#c6ffb3">
<%@include file="Heading.jsp" %>
<br>
<h1 align="center">Coaching Registration</h1>
<div class="form" align="center">
<form action="/E_Tutors/CoachingRegistration" method="post" class="thisform">
<P align="left">Email: </P>  
<input type="email" placeholder="enter your email address" name="email" id="email" minlength="1" required>

<P align="left">Mobile: </P> 
<input type="text" placeholder="enter your mobile no" name="mobileNo" id="mobileNo" pattern="[0-9]{10}" maxlength="10" minlength="10" oninvalid="this.setCustomValidity('Enter the correct mobile mobile of length 10(Number Only)')"
    oninput="this.setCustomValidity('')"  required><br><br>

<P align="left">Current City: </P>
 <input type="text" placeholder="enter your Current City" name="city" id="city" minlength="1" pattern="[A-Za-z\s]+" oninvalid="this.setCustomValidity('City Name Will Contain Characters Only')"
    oninput="this.setCustomValidity('')"  required><br><br>
    
<P align="left">Institution Name: </P>
<input type="text" placeholder="enter your instutute name" pattern="[A-Za-z\s]+" name="name" id="name" minlength="1" oninvalid="this.setCustomValidity('Enter The Correct name Without any Number')"
    oninput="this.setCustomValidity('')" width="48" height="48" required><br><br>


<P align="left">Add Some Description: </P>
<textarea rows="3" cols="50" name="description" id="description"  placeholder="please add some description" required></textarea><br><br>

<P align="left">Password: </P>
<input type="password" name="password" id="password" placeholder="enter your Password" minlength="1" maxlength="20"  required><br><br>


<input type="submit" value="submit" name="submit" id="submit">



</form>
</div>
</body>
</html>