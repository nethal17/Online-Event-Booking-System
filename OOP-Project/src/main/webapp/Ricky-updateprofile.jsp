<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Profile | Nexus Events</title>
    <link rel="stylesheet" href="./CSS/updateprofile.css">
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

    <!-- Update Profile Form Section -->
    <section class="update-profile">
        <div class="form-container">
            <h2 class="form-title">Update Profile Details</h2><br>
            
            <%
            	String id = request.getParameter("id");
            	String name = request.getParameter("name");
            	String email = request.getParameter("email");
            	String phone = request.getParameter("telephone");
            	String username = request.getParameter("uname");
            	String password = request.getParameter("pass");
            
            %>
            
            <form action="rickyUpdate" method="post" class="profile-form">
            
            	<div class="input-group">
                    <label for="username">Organizer Number</label>
                    <input type="text" id="id" name="id" value="<%= id %>" placeholder="Enter new username" readonly>
                </div>

                <div class="input-group">
                    <label for="name">Name</label>
                    <input type="text" id="name" name="name" value="<%= name %>" placeholder="Enter Name" required>
                </div>
                
                <div class="input-group">
                    <label for="email">Email</label>
                    <input type="text" id="email" name="email" value="<%= email %>" placeholder="Enter your email" required>
                </div>
                
                <div class="input-group">
                    <label for="phone">Phone Number</label>
                    <input type="tel" id="phone" name="phone" value="<%= phone %>" placeholder="Enter your phone number" required>
                </div>
                
                <div class="input-group">
                    <label for="username">Username</label>
                    <input type="text" id="username" name="uname" value="<%= username %>" placeholder="Enter new username" required>
                </div>
				<br>
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