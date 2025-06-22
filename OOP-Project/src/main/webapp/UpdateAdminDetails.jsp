<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Profile | Nexus Events</title>
    <link rel="stylesheet" href="./CSS/UpdateAdminDetails.css">
</head>

<body>
	<header class="header">
        <a href="#" class="logo"><span>N</span>exus</a>
        <nav class="navbar">
            <a href="#home">Home</a>
            <a href="#about">About</a>
            <a href="#service">Services</a>
            <a href="#contact">Contact</a>
        </nav>
    </header>

    <!-- Update Profile Form Section -->
    <section class="update-profile">
        <div class="form-container">
            <h2 class="form-title">Update Profile Details</h2>
            
            <%
            	String id = request.getParameter("id");
    			String name = request.getParameter("name");
    			String email = request.getParameter("email");
    			String phone = request.getParameter("telephone");
    			String username = request.getParameter("uname");
    			String password = request.getParameter("pass");
			%>
            
            <form action="update" method="post" class="profile-form">
            	
            	<div class="input-group">
                    <label for="name">Admin ID</label>
                    <input type="text" id="name" name="adminID" value="<%= id %>" readonly>
                </div>
                
                <div class="input-group">
                    <label for="name">Admin Name</label>
                    <input type="text" id="name" name="Name" value="<%= name %>" placeholder="Enter new username" required>
                </div>

                <div class="input-group">
                    <label for="email">Email</label>
                    <input type="text" id="email" name="Email" value="<%= email %>" placeholder="Enter your email" required>
                </div>

                <div class="input-group">
                    <label for="phone">Phone Number</label>
                    <input type="text" id="phone" name="Phone" value="<%= phone %>" placeholder="Enter your phone number" required>
                </div>
                
                <div class="input-group">
                    <label for="username">Username</label>
                    <input type="text" id="username" name="Username" value="<%= username %>" placeholder="Enter your phone number" required>
                </div>

                <input type="submit" name="submit" value="Update Details" class="btn">
            </form>
        </div>
    </section>

    <!-- Footer Section -->
    <footer class="footer">
        <p>Created by <span>Nexus Team</span> | All rights reserved</p>
    </footer>
</body>

</html>
