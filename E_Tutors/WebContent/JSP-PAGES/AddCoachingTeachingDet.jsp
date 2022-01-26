<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="/E_Tutors/resources/FormStyle.css"
	media="all" />
<head>
<script>
		function del(coachingDetId) {
		document.getElementById("coachingDetId").value = coachingDetId;
		document.getElementById("operation").value = 'remove';
		document.coachingForm.submit();
		}
		function mod(coachingDetId,coachingClass,coachingSubject) {
		document.getElementById("coachingDetId").value = coachingDetId;
		document.getElementById("coachingClass").value = coachingClass;
		document.getElementById("coachingSubject").value = coachingSubject;
		document.getElementById("add").value = 'Save!';
		document.getElementById("operation").value = 'edit';
		}
		</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Coaching Teaching Details</title>
</head>
<body style="background-color:#c6ffb3">
<%@include file="Heading.jsp" %>
<br>
<div>
<%@include file="CoachingMenuBar.jsp" %>

<br>
<br>
<br>
<br>
</div>
<h1 align="center">Coaching Teaching Details</h1>
<div class="form" align="center">
<form id="coachingForm" name="coachingForm" method="post" action="/E_Tutors/AddCoachingTeachingDet" class="thisform">
<p align="left">Class</p>			
<input type="text" name="coachingClass" id="coachingClass" placeholder="enter the class one by one" required>
<p align="left">Subject</p>	
<input type="text" name="coachingSubject" id="coachingSubject" placeholder="enter subject" required>
<input class=buttom name=add id=add tabindex=3
					value=Add ! type=submit>

<input name="operation" id="operation" value="create" type=hidden> 
<input name="coachingDetId" id="coachingDetId" type=hidden>
			</form>
			</div>
			
			<table width=90% border=1>

				<tr>
					<td align=center>Class</td>
					<td align=center>Subject</td>
					<td align=center>Update</td>
					<td align=center>Remove</td>
				</tr>
				<c:forEach items="${requestScope.coachingList}" var="cclass">
					<tr>
						<td>${cclass.coachingClass}</td>
						<td>${cclass.coachingSubject}</td>
						<td><input class="buttom" name="edit" id="edit" value="Edit!"
							type="button" onclick="mod('${cclass.caochingTeachDetId}','${cclass.coachingClass}','${cclass.coachingSubject}');"></td>
						<td><input class="buttom" name="delete" id="delete" value="Delete!" type="button" onclick="del('${cclass.caochingTeachDetId}');"></td>
				</c:forEach>
			</table>

</body>
</html>