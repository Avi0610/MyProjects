<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="/E_Tutors/resources/FormStyle.css"
	media="all" />
<head>

<script>
		function del(tutorAreaId) {
		document.getElementById("tutorAreaId").value = tutorAreaId;
		document.getElementById("operation").value = 'remove';
		document.tutorAreaForm.submit();
		}
		function mod(tutorAreaId,pinCode) {
		document.getElementById("tutorAreaId").value = tutorAreaId;
		document.getElementById("pinCode").value = pinCode;
		document.getElementById("add").value = 'Save!';
		document.getElementById("operation").value = 'edit';
		}
		</script>
		
		
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tutor Area</title>
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
<h1 align="center">Your Teaching Area</h1>
<div class="form" align="center">

<form id="tutorAreaForm" name="tutorAreaForm" method="post" action="/E_Tutors/AddTutorArea" class="thisform">
	<p align="left">PinCode :</p>				
<input type="text" name="pinCode" id="pinCode" placeholder="Enter Pincode where you can serve" required><br><br>

<input class=buttom name=add id=add tabindex=3
					value=Add ! type=submit>

<input name="operation" id="operation" value="create" type=hidden> 
<input name="tutorAreaId" id="tutorAreaId" type=hidden>
			</form>
			</div>
			
			<table width=90% border=1>

				<tr>
					<td align=center>PinCode</td>
					<td align=center>Update</td>
					<td align=center>Remove</td>
				</tr>
				<c:forEach items="${requestScope.tutorArea}" var="tarea">
					<tr>
						<td>${tarea.pinCode}</td>
						<td><input class="buttom" name="edit" id="edit" value="Edit!"
							type="button" onclick="mod('${tarea.tutorAreaId}','${tarea.pinCode}');"></td>
						<td><input class="buttom" name="delete" id="delete" value="Delete!" type="button" onclick="del('${tarea.tutorAreaId}');"></td>
				</c:forEach>
			</table>

</body>
</html>