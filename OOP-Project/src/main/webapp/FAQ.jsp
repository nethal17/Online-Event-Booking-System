<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FAQ - Nexus Events</title>
    <link rel="stylesheet" href="./CSS/FAQ.css">
</head>
<body>
	<header class="header">
		<a href="home.jsp" class="logo"><span>N</span>exus</a>
        <nav class="navbar">
			<a href="home.jsp">Home</a>
			<a href="#service">service</a>
        	<a href="#about">about</a>
        	<a href="#gallery">gallery</a>
        	<a href="#events">Events</a>
        	<a href="#review">review</a>
        	<a href="#contact">contact</a>
			<a href="logout">Logout</a>
			<a href="">My Profile</a>             
        </nav>
    </header>
    
	<div class="faq-container">
        <h1>Frequently Asked Questions</h1>

        <div class="faq-item">
            <button class="faq-question">1. How can I browse your events?</button>
            <div class="faq-answer">
                <p>You can browse our events by visiting the "Events" section on our homepage. Filter events by categories, dates, or locations to find the perfect one for you.</p>
            </div>
        </div>

        <div class="faq-item">
            <button class="faq-question">2. How can I book your events?</button>
            <div class="faq-answer">
                <p>To book an event, simply click on the event you're interested in, review the details, and click the "Book Now" button. Follow the instructions to complete your booking.</p>
            </div>
        </div>

        <div class="faq-item">
            <button class="faq-question">3. How can I contact the event organizer?</button>
            <div class="faq-answer">
                <p>If you need to contact the event organizer, Event Organizer will contact you after you booked an event.If it didn't happen you can contact us within "contact us" page</p>
            </div>
        </div>

        <div class="faq-item">
            <button class="faq-question">4. How can I change my requirements after booking?</button>
            <div class="faq-answer">
                <p>If you need to modify your booking requirements, please log in to your account, navigate to "My Bookings," and select the event you'd like to update. Alternatively, you can contact the event organizer for further assistance.</p>
            </div>
        </div>

        <div class="faq-item">
            <button class="faq-question">5. If I want to cancel a booking, is it possible?</button>
            <div class="faq-answer">
                <p>Yes, you can cancel your booking by going to your account dashboard under "My Bookings." Select the event you wish to cancel and follow the prompts. Please note that cancellation policies may apply.</p>
            </div>
        </div>
    </div>

    <script>
        const faqQuestions = document.querySelectorAll('.faq-question');

        faqQuestions.forEach(question => {
            question.addEventListener('click', () => {
                question.classList.toggle('active');
                const answer = question.nextElementSibling;
                answer.style.display = answer.style.display === 'block' ? 'none' : 'block';
            });
        });
    </script>
    <footer class="footer">
        <p>Created by <span>Nexus Team</span> | All rights reserved</p>
    </footer>
</body>
</html>