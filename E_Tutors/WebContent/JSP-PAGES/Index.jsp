<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome To E_Tutors</title>

<link rel="stylesheet" type="text/css" href="/E_Tutors/resources/HomeStyle.css"
	media="all" />
</head>
<body style="background-color:#c6ffb3">
<div class="back">
<%@include file="Heading.jsp" %>
<br>
<div class="slideshow-container">

  <!-- Full-width images with number and caption text -->
  <div class="mySlides fade">
    <div class="numbertext">1 / 3</div>
    <img src="/E_Tutors/resources/images/img1.jpg" width="1000px" height="400" class="img">
    <div class="text">Image One</div>
  </div>

  <div class="mySlides fade">
    <div class="numbertext">2 / 3</div>
    <img src="/E_Tutors/resources/images/img2.jpg" width="1000" height="400" class="img">
    <div class="text">Image Two</div>
  </div>

  <div class="mySlides fade">
    <div class="numbertext">3 / 3</div>
    <img src="/E_Tutors/resources/images/img3.jpg" width="1000" height="400" class="img">
    <div class="text">Image Three</div>
  </div>

  <!-- Next and previous buttons -->
  <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
  <a class="next" onclick="plusSlides(1)">&#10095;</a>
</div>
<br>

<!-- The dots/circles -->
<div style="text-align:center">
  <span class="dot" onclick="currentSlide(1)"></span> 
  <span class="dot" onclick="currentSlide(2)"></span> 
  <span class="dot" onclick="currentSlide(3)"></span> 
</div>
<script>
var slideIndex = 0;
showSlides();

function showSlides() {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";  
  }
  slideIndex++;
  if (slideIndex > slides.length) {slideIndex = 1}    
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
  setTimeout(showSlides, 2000); // Change image every 2 seconds
}
</script>

<div class="wrapper">
<a href="/E_Tutors/JSP-PAGES/UserLogin.jsp"><button class="btn button">I Am A User</button></a>
<a href="/E_Tutors/JSP-PAGES/TutorLogin.jsp"><button class="btn button">I Am A Home Tutor</button></a>
<a href="/E_Tutors/JSP-PAGES/CoachingLogin.jsp"><button class="btn button">I Am A Coaching Institute</button></a>
<a href="/E_Tutors/JSP-PAGES/AboutUs.jsp"><button class="btn button">Know About Us</button></a>
</div>
</div>
<br>

</body>
</html>