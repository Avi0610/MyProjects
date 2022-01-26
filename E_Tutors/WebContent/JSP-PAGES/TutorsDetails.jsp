<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="/E_Tutors/resources/Button.css"
	media="all" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>		
		function find(tutorId) {
		document.getElementById("tutorId").value = tutorId;
		
		document.contactTutorForm.submit();
		}
		</script>
<title>Tutor Details</title>
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
<h1 align="center">Basic Details</h1>
<hr>
<p class="show">Name: ${requestScope.tutorDetails.tutorName}</p><br>
<p class="show">Gender: ${requestScope.tutorDetails.gender}</p><br>
<p class="show">Profession: ${requestScope.tutorDetails.profession}</p><br>
<p class="show">Date Of Birth: ${requestScope.tutorDetails.dob}</p><br>
<p class="show">Original City: ${requestScope.tutorDetails.originalCity}</p><br>
<p class="show">Current City: ${requestScope.tutorDetails.presentCity}</p><br>
<p class="show">About Me: ${requestScope.tutorDetails.details}</p><br>

<hr>
<h1 align="center">Teaching Details</h1>
<hr>
<c:forEach items="${requestScope.tutorTeachingDetails}" var="tutor">
					
						<p class="show">Class: ${tutor.teachingClass}</p>
						<p class="show">Subject : ${tutor.teachingSubject}</p>
						<br>
						<br>
						
					
				</c:forEach>
				<br><br>
				<hr>
				
				<form id="contactTutorForm" name="contactTutorForm" method="get" action="/E_Tutors/ContactTutor">
				

				
				 <input name="tutorId" id="tutorId" type="hidden">

			</form>
			<div class="wrapper" align="center">
		<button class="button" style="vertical-align:middle" onclick="find('${requestScope.tutorDetails.tutorId}');"><span>Contact Me</span></button><br>
<br>
</div>
							<hr>
							
</body>
</html>