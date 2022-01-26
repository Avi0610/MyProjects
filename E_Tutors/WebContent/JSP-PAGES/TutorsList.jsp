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
		
		document.tutorForm.submit();
		}
		</script>
<title>Tutor List</title>
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


<form id="tutorForm" name="tutorForm" method="post"
				action="/E_Tutors/TutorDetailsFromId">
				

				
				 <input name="tutorId"
					id="tutorId" type="hidden">

			</form>



				
					
					
				
				<c:forEach items="${requestScope.tutorList}" var="tutor">
					
						<p class="show">Name :- ${tutor.tutorName}</p><br>
						<P class="show">Profession :- ${tutor.profession}</P><br>
						<button class="button" style="vertical-align:middle" onclick="find('${tutor.tutorId}');"><span>Know More</span></button><br>
							<hr>
						
					
				</c:forEach>
			
</body>
</html>