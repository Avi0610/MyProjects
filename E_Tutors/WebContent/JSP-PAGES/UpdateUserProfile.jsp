<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="/E_Tutors/resources/FormStyle.css"
	media="all" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Your Profile</title>
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
<h1 align="center">Update Your Profile</h1>
<div class="form" align="center">

<form action="/E_Tutors/UpdateUserProfile" method="post" class="thisform">

<p align="left">Name :</p>
<input type="text" placeholder="enter your name" pattern="[A-Za-z\s]+" name="userName" id="userName" minlength="1" oninvalid="this.setCustomValidity('Enter The Correct name Without any Number')"
    oninput="this.setCustomValidity('')" width="48" height="48" value="${requestScope.userDet.userName}" required>
    
  <p align="left">Email :</p>      
<input type="email" placeholder="enter your email address" name="userEmail" id="userEmail" minlength="1"  value="${requestScope.userDet.email}"required>

<p align="left">Mobile :</p>
<input type="text" placeholder="enter your mobile no" name="userMobileNo" id="userMobileNo" pattern="[0-9]{10}" maxlength="10" minlength="10" oninvalid="this.setCustomValidity('Enter the correct mobile mobile of length 10(Number Only)')"
    oninput="this.setCustomValidity('')" value="${requestScope.userDet.mobile}" required>

<p align="left">City :</p>
<input type="text" placeholder="enter your city Name" name="userCity" id="userCity" minlength="1" pattern="[A-Za-z\s]+" oninvalid="this.setCustomValidity('City Name Will Contain Characters Only')"
    oninput="this.setCustomValidity('')" value="${requestScope.userDet.city}" required>

<p align="left">PinCode :</p>
<input type="text" placeholder="enter your Pincode" name="userPinCode" id="userPinCode" minlength="6" maxlength="6" pattern="[0-9]{6}" oninvalid="this.setCustomValidity('PinCode Should be of number type of 6 digits')"
    oninput="this.setCustomValidity('')" value="${requestScope.userDet.pinCode}" required>
<div align="left" class="gen">
<p align="left">I Am A :</p>
<input type="radio" name="userGender" id="userGender" value="Male" text="Male" checked="checked">Male

<input type="radio" name="userGender" id="userGender" value="Female" text="Female">Female<br><br>
</div>
<p align="left">Date Of Birth :</p>
<input type="date" name="userDob" id="userDob" placeholder="enter your Date Of Birth" value="${requestScope.userDet.dob}"  required ><br><br>

<input type="submit" value="submit" name="submit" id="submit">



</form>
</div>
</body>
</html>