<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="/E_Tutors/resources/Button.css"
	media="all" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:#c6ffb3">
<%@include file="Heading.jsp" %>
<br>

<%@include file="UserMenuBar.jsp" %>
</div>
<br>
<br>
<br>
<br>
<br>
<h1>Basic Details</h1>
<hr>

<p class="show">Name: ${requestScope.coachingDetails.institutionName}</p><br>
<p class="show">Email: ${requestScope.coachingDetails.email}</p><br>
<p class="show">Mobile: ${requestScope.coachingDetails.mobile}</p><br>
<p class="show">City: ${requestScope.coachingDetails.city}</p><br>
<p class="show">Description: ${requestScope.coachingDetails.details}</p><br>


<hr>
<h1>Teaching Details</h1>
<hr>
<c:forEach items="${requestScope.coachingTeachingDetails}" var="coaching">
					
						<p class="show">Class: ${coaching.coachingClass}</p>
						<p class="show">Subject : ${coaching.coachingSubject}</p>
						<br>
						<br>
						
					
				</c:forEach>
				<br><br>

</body>
</html>