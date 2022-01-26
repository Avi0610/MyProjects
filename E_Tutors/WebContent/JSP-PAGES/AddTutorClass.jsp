<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="/E_Tutors/resources/FormStyle.css"
	media="all" />
<head>

<script>
		function del(teachingDetId) {
		document.getElementById("teachingDetId").value = teachingDetId;
		document.getElementById("operation").value = 'remove';
		document.tutorForm.submit();
		}
		function mod(teachingDetId,tutorClass,tutorSubject) {
		document.getElementById("teachingDetId").value = teachingDetId;
		document.getElementById("tutorClass").value = tutorClass;
		document.getElementById("tutorSubject").value = tutorSubject;
		document.getElementById("add").value = 'Save!';
		document.getElementById("operation").value = 'edit';
		}
		</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:#c6ffb3">
<%@include file="Heading.jsp" %>
<br>
<div>
<%@include file="TutorMenuBar.jsp" %>
</div>
<br>
<br>
<br>
<h1 align="center">Your Teaching Details</h1>
<div class="form" align="center">
<form id="tutorForm" name="tutorForm" method="post" action="/E_Tutors/AddTutorClass" class="thisform">
	<p align="left">Class :</p>				
<input type="text" name="tutorClass" id="tutorClass" placeholder="enter the class one by one" required>
<p align="left">Subject :</p>	
<input type="text" name="tutorSubject" id="tutorSubject" placeholder="enter subject" required><br><br>
<input class=buttom name=add id=add tabindex=3
					value=Add ! type=submit>

<input name="operation" id="operation" value="create" type=hidden> 
<input name="teachingDetId" id="teachingDetId" type=hidden>
			</form>
			</div>
			
			<table width=90% border=1>

				<tr>
					<td align=center>Class</td>
					<td align=center>Subject</td>
					<td align=center>Update</td>
					<td align=center>Remove</td>
				</tr>
				<c:forEach items="${requestScope.tutorClass}" var="tclass">
					<tr>
						<td>${tclass.teachingClass}</td>
						<td>${tclass.teachingSubject}</td>
						<td><input class="buttom" name="edit" id="edit" value="Edit!"
							type="button" onclick="mod('${tclass.techingdetId}','${tclass.teachingClass}','${tclass.teachingSubject}');"></td>
						<td><input class="buttom" name="delete" id="delete" value="Delete!" type="button" onclick="del('${tclass.techingdetId}');"></td>
				</c:forEach>
			</table>
<div class="form" align="center">
<form action="/E_Tutors/AddTutorArea" method="post" class="thisform">
<input type="submit" value="See Your Teaching Area">
</form>
</div>
</body>
</html>