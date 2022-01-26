<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/E_Tutors/resources/FormStyle.css"
	media="all" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Us</title>
</head>
<body style="background-color:#c6ffb3">
<%@include file="Heading.jsp" %>
<div class="form" align="center">
<form action="/E_Tutors/ContactUs" method="post" class="thisform">



    
    <P align="left">Message: </P>
<textarea rows="3" cols="50" name="message" id="message"  placeholder="please add some description" required></textarea><br><br>
    
<input type="submit" value="Send">
</form>
</div>

</body>
</html>