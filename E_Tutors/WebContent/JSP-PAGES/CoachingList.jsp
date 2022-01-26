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
		function find(coachingId) {
		document.getElementById("coachingId").value = coachingId;
		
		document.coachingForm.submit();
		}
		</script>
<title>Coaching List</title>
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

<form id="coachingForm" name="coachingForm" method="post"
				action="/E_Tutors/CoachingDetailsFromId">
				

				
				 <input name="coachingId"
					id="coachingId" type="hidden">

			</form>
			
				<c:forEach items="${requestScope.coachingList}" var="coaching">
					
						<p class="show">Name :- ${coaching.institutionName}</p><br>
						<P class="show">Profession :- ${coaching.mobile}</P><br>
						<button class="button" style="vertical-align:middle" onclick="find('${coaching.coachingDetId}');"><span>Know More</span></button><br>
						
							<hr>
						
					
				</c:forEach>

</body>
</html>