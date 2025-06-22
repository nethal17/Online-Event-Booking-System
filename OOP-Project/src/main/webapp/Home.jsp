<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <%
    	HttpSession session1 = request.getSession(false); // Get session if it exists
    		if (session1 == null || session1.getAttribute("username") == null) {
       			response.sendRedirect("Login.jsp"); // Redirect if no session
    		}
	%>
	
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Event Organizers Home</title>

    <!--swiper css-->
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css"
    />

    <!--font awesome-->
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
    />

    <!--css file-->
    <link rel="stylesheet" href="./CSS/home.css" />
</head>
<body>
	<!-- header section starts  -->
    <header class="header">
      <a href="#" class="logo"><span>N</span>exus</a>

      <nav class="navbar">
        <a href="#home">Home</a>
        <a href="#service">Service</a>
        <a href="#about">About</a>
        <a href="#gallery">Gallery</a>
        <a href="#events">Events</a>
        <a href="ContactUs.jsp">Contact Us</a>
        <%
            HttpSession session2 = request.getSession(false); // Do not create new session
            if (session2 != null && session2.getAttribute("username") != null) {
                // User is logged in, show logout button
        	%> 
        		<a href="AdminLoginServlet">Profile </a>
        	<%
            }  
       		%>
       		
       		<%
            HttpSession session3 = request.getSession(false); // Do not create new session
            if (session3 != null && session2.getAttribute("username") != null) {
                // User is logged in, show logout button
        	%>
            <a href="AdminLogoutServlet" class="auth-btn">Logout</a>
        	<%
            } else {
                // User is not logged in, show login button
        	%>
            <a href="Login.jsp" class="auth-btn">Login</a>
       	 	<%
            }
        	%>
      </nav>

      <div id="menu-bars" class="fas fa-bars"></div>
    </header>

    <!-- home section starts  -->
    <section class="home" id="home">
      <div class="content">
        <h3>
          Your Vision, Our Expertise
          <span> nexus events </span>
        </h3>
        <a href="BookingInsert.jsp" class="btn">Book Event</a>
      </div>

      <div class="swiper-container home-slider">
        <div class="swiper-wrapper">
          <div class="swiper-slide">
            <img src="images/home2.jpg" alt="" />
          </div>
          <div class="swiper-slide">
            <img src="images/home5.jpg" alt="" />
          </div>
          <div class="swiper-slide">
            <img src="images/home6.jpg" alt="" />
          </div>
        </div>
      </div>
    </section>

    <!-- service section starts  -->
    <section class="service" id="service">
      <h1 class="heading">our <span>services</span></h1>

      <div class="box-container">
        

        <div class="box">
          <i class="fas fa-photo-video"></i>
          <h3>photos and videos</h3>
          <p>
            Capture every moment with NEXUS EVENTS! Our professional photography 
            and videography services ensure your special day is beautifully documented, 
            preserving memories that last a lifetime.
          </p>
        </div>

        <div class="box">
          <i class="fas fa-music"></i>
          <h3>entertainment</h3>
          <p>
            At NEXUS EVENTS, we provide top-notch entertainment options, from live music 
            to DJs and sound systems, ensuring your event is lively and unforgettable.
          </p>
        </div>

        <div class="box">
          <i class="fas fa-map-marker-alt"></i>
          <h3>venue selection</h3>
          <p>
            NEXUS EVENTS helps you find the perfect venue for any occasion. From intimate 
            gatherings to grand celebrations, we ensure your event takes place in a location 
            that suits your style and needs.
          </p>
        </div>

        <div class="box">
          <i class="fas fa-birthday-cake"></i>
          <h3>food catering</h3>
          <p>
            NEXUS EVENTS offers exceptional catering services, providing a variety of delicious 
            menu options tailored to your event. From elegant dinners to casual bites, we ensure 
            your guests enjoy a memorable dining experience.
          </p>
        </div>
      </div>
    </section>

    <!-- about section starts  -->
    <section class="about" id="about">
      <h1 class="heading"><span>about</span> us</h1>

      <div class="row">
        <div class="image">
          <img src="images/about.jpg" alt="" />
        </div>

        <div class="content">
          <h3>your occasion deserves our careful planning</h3>
          <p>
            Welcome to NEXUS EVENTS, your one-stop solution for all event 
            planning needs! Whether you're organizing a wedding, birthday 
            party, graduation, or any special occasion, we make the process effortless.
          </p>
          <p>
            Our platform connects event organizers, vendors, and customers, 
            offering a seamless experience from booking to execution. With 
            NEXUS EVENTS, you can browse, book, customize, and plan events 
            with ease, all in one place.
          </p>
          <p>
            Let us help you create memorable moments!
          </p>
          <a href="#" class="btn">reach us</a>
        </div>
      </div>
    </section>

    <!-- gallery section starts  -->
    <section class="gallery" id="gallery">
      <h1 class="heading">our <span>gallery</span></h1>

      <div class="box-container">
        <div class="box">
          <img src="images/gallery1.jpg" alt="" />
          <h3 class="title">best events</h3>
          <div class="icons">
            <a href="#" class="fas fa-heart"></a>
            <a href="#" class="fas fa-share"></a>
            <a href="#" class="fas fa-eye"></a>
          </div>
        </div>


        <div class="box">
          <img src="images/gallery3.jpg" alt="" />
          <h3 class="title">best events</h3>
          <div class="icons">
            <a href="#" class="fas fa-heart"></a>
            <a href="#" class="fas fa-share"></a>
            <a href="#" class="fas fa-eye"></a>
          </div>
        </div>

        <div class="box">
          <img src="images/gallery4.jpg" alt="" />
          <h3 class="title">best events</h3>
          <div class="icons">
            <a href="#" class="fas fa-heart"></a>
            <a href="#" class="fas fa-share"></a>
            <a href="#" class="fas fa-eye"></a>
          </div>
        </div>

        <div class="box">
          <img src="images/gallery5.jpg" alt="" />
          <h3 class="title">best events</h3>
          <div class="icons">
            <a href="#" class="fas fa-heart"></a>
            <a href="#" class="fas fa-share"></a>
            <a href="#" class="fas fa-eye"></a>
          </div>
        </div>

        <div class="box">
          <img src="images/gallery6.jpg" alt="" />
          <h3 class="title">best events</h3>
          <div class="icons">
            <a href="#" class="fas fa-heart"></a>
            <a href="#" class="fas fa-share"></a>
            <a href="#" class="fas fa-eye"></a>
          </div>
        </div>

        <div class="box">
          <img src="images/gallery7.jpg" alt="" />
          <h3 class="title">best events</h3>
          <div class="icons">
            <a href="#" class="fas fa-heart"></a>
            <a href="#" class="fas fa-share"></a>
            <a href="#" class="fas fa-eye"></a>
          </div>
        </div>

        <div class="box">
          <img src="images/gallery8.jpg" alt="" />
          <h3 class="title">best events</h3>
          <div class="icons">
            <a href="#" class="fas fa-heart"></a>
            <a href="#" class="fas fa-share"></a>
            <a href="#" class="fas fa-eye"></a>
          </div>
        </div>

        <div class="box">
          <img src="images/gallery9.jpg" alt="" />
          <h3 class="title">best events</h3>
          <div class="icons">
            <a href="#" class="fas fa-heart"></a>
            <a href="#" class="fas fa-share"></a>
            <a href="#" class="fas fa-eye"></a>
          </div>
        </div>
      </div>
    </section>


    <section class="events" id="events">
      <h1 class="heading">our <span>Events</span></h1>
      
	<div class="box-container">
    <c:forEach var="event" items="${eventList}">
      <div class="box">
        <h3 class="title">${event.title}</h3>
        <ul>
            <li>Description : ${event.description}</li>
            <li>Price : ${event.price} </li>
        </ul><br>
        <a href="BookingInsert.jsp" class="btn">Book Event</a>
      </div>
    </c:forEach>
  </div>
      
    </section>

    

    

    <!-- footer section starts  -->
    <section class="footer">
      <div class="box-container">
        <div class="box">
          <h3>branches</h3>
          <a href="#"> <i class="fas fa-map-marker-alt"></i> Chilaw </a>
          <a href="#"> <i class="fas fa-map-marker-alt"></i> Wennappuwa </a>
          <a href="#"> <i class="fas fa-map-marker-alt"></i> Elpitiya </a>
          <a href="#"> <i class="fas fa-map-marker-alt"></i> Negombo </a>
          <a href="#"> <i class="fas fa-map-marker-alt"></i> Colombo </a>
        </div>

        <div class="box">
          <h3>quick links</h3>
          <a href="#"> <i class="fas fa-arrow-right"></i> home </a>
          <a href="#"> <i class="fas fa-arrow-right"></i> service </a>
          <a href="#"> <i class="fas fa-arrow-right"></i> about </a>
          <a href="#"> <i class="fas fa-arrow-right"></i> gallery </a>
          <a href="#"> <i class="fas fa-arrow-right"></i> price </a>
          <a href="#"> <i class="fas fa-arrow-right"></i> reivew </a>
          <a href="#"> <i class="fas fa-arrow-right"></i> contact </a>
        </div>

        <div class="box">
          <h3>contact info</h3>
          <a href="#"> <i class="fas fa-phone"></i> 076 558 7168 </a>
          <a href="#"> <i class="fas fa-phone"></i> 076 039 1736 </a>
          <a href="#"> <i class="fas fa-phone"></i> 078 563 1061 </a>
          <a href="#"> <i class="fas fa-envelope"></i> NexusEvents@gmail.com </a>
          <a href="#">
            <i class="fas fa-map-marker-alt"></i> 453,Seewali Mawathe,Kaduwela
          </a>
        </div>

        <div class="box">
          <h3>follow us</h3>
          <a href="#"> <i class="fab fa-facebook-f"></i> facebook </a>
          <a href="#"> <i class="fab fa-twitter"></i> twitter </a>
          <a href="#"> <i class="fab fa-instagram"></i> instagram </a>
          <a href="#"> <i class="fab fa-linkedin-in"></i> linkedin </a>
        </div>
      </div>

      <div class="credit">
        created by <span>Nexus Team</span> | all rights reserved
      </div>
    </section>

      <div class="toggle-btn">
      </div>    
    <!-- Swiper JS -->
    <script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>

    <!--JS file-->
    <script src="app.js"></script>
</body>
</html>