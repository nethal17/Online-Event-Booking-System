<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact Us</title>
    <link rel="stylesheet" href="./CSS/ContactUs.css">
</head>
<body>
	<header class="header">
		<a href="home.jsp" class="logo"><span>N</span>exus</a>
        <nav class="navbar">
			<a href="home.jsp">Home</a>
			<a href="#service">Service</a>
        	<a href="#about">About</a>
        	<a href="#gallery">Gallery</a>
        	<a href="#events">Events</a>
        	<a href="#review">Review</a>
        	<a href="#contact">Contact</a>
			<a href="logout">Logout</a>
			<a href="">My Profile</a>             
        </nav>
    </header>
    
    <!-- Contact Section -->
    <section class="contact" id="contact">
        <div class="form-container">
            <h2 class="form-title"><span>Contact</span> Us</h2><hr><br><br>

            <form action="contact" method="post" class="form">
                <!-- First Row: Your Name and Your Email -->
                <div class="input-row">
                    <div class="input-group">
                        <label for="name">Your Name</label>
                        <input type="text" name="Name" placeholder="Enter your name" required />
                    </div>
                    <div class="input-group">
                        <label for="email">Your Email</label>
                        <input type="email" name="Email" placeholder="Enter your email" required />
                    </div>
                </div>
                <!-- Second Row: Phone Number and Subject -->
                <div class="input-row">
                    <div class="input-group">
                        <label for="phone">Phone Number</label>
                        <input type="tel" name="Phone" placeholder="Enter your phone number" required />
                    </div>
                    <div class="input-group">
                        <label for="subject">Subject</label>
                        <input type="text" name="Subject" placeholder="Enter the subject" required />
                    </div>
                </div>
                <!-- Third Row: Message -->
                <div class="input-group">
                    <label for="message">Message</label>
                    <textarea name="Message" placeholder="Enter your message" cols="30" rows="5" required></textarea>
                </div>
                <input type="submit" value="Send Message" class="btn" />
            </form>
        </div>
    </section>
    
    <footer class="footer">
        <p>Created by <span>Nexus Team</span> | All rights reserved</p>
    </footer>
</body>
</html>
