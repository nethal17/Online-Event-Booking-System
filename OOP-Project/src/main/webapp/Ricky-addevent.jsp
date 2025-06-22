<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Event | Nexus Events</title>
    <link rel="stylesheet" href="./CSS/addevent.css">
    
    <!-- Add JavaScript for form validation -->
    <script>
        function validateForm() {
            // Get the form elements
            var title = document.getElementById('title').value.trim();
            var description = document.getElementById('description').value.trim();
            var organizer = document.getElementById('organizer').value.trim();
            var email = document.getElementById('email').value.trim();
            var phone = document.getElementById('phone').value.trim();
            var priceOptions = document.getElementsByName('price');
            
            // Validate title
            if (title === "") {
                alert("Event title is required");
                return false;
            }
            
            // Validate description
            if (description === "") {
                alert("Event description is required");
                return false;
            }

            // Validate organizer name
            if (organizer === "") {
                alert("Organizer name is required");
                return false;
            }

            // Validate email using a regular expression for correct format
            var emailPattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
            if (!email.match(emailPattern)) {
                alert("Please enter a valid email address");
                return false;
            }

            // Validate phone number for 10 digits
            var phonePattern = /^\d{10}$/;
            if (!phone.match(phonePattern)) {
                alert("Please enter a valid 10-digit phone number");
                return false;
            }

            // Validate that a price range is selected
            var priceSelected = false;
            for (var i = 0; i < priceOptions.length; i++) {
                if (priceOptions[i].checked) {
                    priceSelected = true;
                    break;
                }
            }
            if (!priceSelected) {
                alert("Please select a price range");
                return false;
            }

            // If all fields are valid, allow the form to be submitted
            return true;
        }
    </script>
    
</head>
<body>

	<!-- Header Section -->
    <header class="header">
		<a href="home.jsp" class="logo"><span>N</span>exus</a>
        <nav class="navbar">
			<a href="home.jsp">Home</a>
			<a href="logout">Logout</a>
			<a href="profile.jsp">My Profile</a>             
        </nav>
    </header>

    <!-- Add Event Form Section -->
    <section class="add-event">
        <div class="form-container">
            <h2 class="form-title">Add Event</h2><hr><br><br><br>
            
            <%
            	String id = request.getParameter("id");
            	String name = request.getParameter("name");
            	String email = request.getParameter("email");
            	String phone = request.getParameter("telephone");
            	String username = request.getParameter("uname");
            	String password = request.getParameter("pass");
            
            %>
            
            <form action="addEvent" method="post"class="event-form" onsubmit="return validateForm()">
                <div class="input-group">
                    <label for="title">Event Title</label>
                    <input type="text" id="title" name="title" placeholder="Enter event title" required>
                </div>

                <div class="input-group">
                    <label for="description">Event Description</label>
                    <textarea id="description" name="description" placeholder="Enter event description" required></textarea>
                </div>
                
                <div class="input-group">
                    <label for="organizer">Organizer Name</label>
                    <input type="text" id="organizer" name="organizer" placeholder="Enter organizer's name" required>
                </div>

                <div class="input-group">
                    <label for="email">Contact Email</label>
                    <input type="email" id="email" name="email" placeholder="Enter contact email" required>
                </div>

                <div class="input-group">
                    <label for="phone">Contact Phone Number</label>
                    <input type="tel" id="phone" name="phone" placeholder="Enter contact phone number" required>
                </div>

                <div class="input-group">
                    <label for="ticket-price">Price Range</label><br>

                    <div class="ricca">
                        <input type="radio" id="age1" name="price" value="0 - 250,000">
                        <label for="price1">0 - 250,000</label>
                    </div>
                    <div class="ricca">
                        <input type="radio" id="age1" name="price" value="250,000 - 500,000">
                        <label for="price2">250,000 - 500,000</label>
                    </div>
                    <div class="ricca">
                        <input type="radio" id="age2" name="price" value="500,000 - 750,000">
                        <label for="price3">500,000 - 750,000</label>
                    </div>

                    <div class="ricca">
                        <input type="radio" id="age3" name="price" value="750,000 - 1,000,000">
                        <label for="price4">750,000 - 1,000,000</label>
                    </div>
                    
                    <div>
                    	<input type="hidden" name="date" value="2024-11-11">
                    	<input type="hidden" name="organizer_id" value="<%= id %>">
                    </div>
                    
                </div>
                
                <button type="submit" class="btn">Add Event</button>
            </form>
        </div>
    </section>

    <!-- Footer Section -->
   <footer class="footer">
        <p>Created by <span>Nexus Team</span> | All rights reserved</p>
    </footer>

</body>
</html>