<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Home</title>
<link rel="stylesheet" type="text/css" href="/E_Tutors/resources/style.css"
	media="all" />
</head>
<body>
<div class="navbar">
  <a href="/E_Tutors/JSP-PAGES/UserHome.jsp">Home</a>
  <div class="subnav">
    <button class="subnavbtn">Profile<i class="fa fa-caret-down"></i></button>
    <div class="subnav-content">
      <a href="/E_Tutors/UpdateUserProfile">Update Profile</a>
      <a href="/E_Tutors/JSP-PAGES/UpdateUserPassword.jsp">Update Password</a>

    </div>
  </div> 
  <div class="subnav">
    <button class="subnavbtn">Search Coaching<i class="fa fa-caret-down"></i></button>
    <div class="subnav-content">
      <a href="/E_Tutors/JSP-PAGES/SearchCoachingByClassAndSubAndCity.jsp">Search By City <br>Class And Subject</a>
      <a href="/E_Tutors/JSP-PAGES/SearchCoachingByCityAndSubject.jsp">Search By City<br> And Subject</a>
      <a href="/E_Tutors/JSP-PAGES/SearchCoachingByCityAndClass.jsp">Search By City<br> And Class</a>
     
    </div>
  </div> 
  <div class="subnav">
    <button class="subnavbtn">Search Home Tutors<i class="fa fa-caret-down"></i></button>
    <div class="subnav-content">
      <a href="/E_Tutors/JSP-PAGES/SearchTutorByPincode.jsp">Search By PinCode</a>
      <a href="/E_Tutors/JSP-PAGES/SearchTutorByPinCodeAndSub.jsp">Search By PinCode<br>And Subject</a>
      <a href="/E_Tutors/JSP-PAGES/SearchTutorByPinCodeAndClass.jsp">Search By PinCode<br>And Class</a>
      <a href="/E_Tutors/JSP-PAGES/SearchTutorByPinCodeAndSubAndClass.jsp">Search By PinCode<br>And Subject And Class</a>
      <a href="/E_Tutors/JSP-PAGES/SearchTutorByClassAndSubject.jsp">Search By Class<br>And Subject</a>
     
    </div>
  </div>
  <a href="/E_Tutors/JSP-PAGES/ContactUs.jsp">Contact Us</a>
</div>
</body>
</html>