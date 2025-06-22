<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    <%
    	HttpSession session1 = request.getSession(false); // Get session if it exists
    		if (session1 == null || session1.getAttribute("username") == null) {
       			response.sendRedirect("Login.jsp"); // Redirect if no session
    		}
	%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="./CSS/AdminDashboard.css">
    <link rel="stylesheet" href="./CSS/Header&Footer.css">
</head>
<body>
	
	<!-- Header Section -->
	<header class="header">
        <a href="#" class="logo"><span>N</span>exus</a>
        <nav class="navbar">
            <a href="RedirectToHomeServlet">Home</a>
            <!--<a href="ContactUs.jsp">Contact US</a>
            <a href="#about">About Us</a>-->
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
    </header>
    
    <main>
	<c:forEach var="admin" items="${addDetails}">
	
	<c:set var="id" value="${admin.id}"/>
	<c:set var="name" value="${admin.name}"/>
	<c:set var="email" value="${admin.email}"/>
	<c:set var="telephone" value="${admin.telephone}"/>
	<c:set var="type" value="${admin.type}"/>
	<c:set var="username" value="${admin.username}"/>
	<c:set var="password" value="${admin.password}"/>
	</c:forEach>

    <div class="dashboard-container">
        <!-- Admin Info Section -->
        <div class="admin-info" style="width: 50%; margin-left: 10px">
            <h2 style="text-align:center;">Admin Info</h2>
            <div class="info">
        <c:if test="${empty addDetails}">
   			<p>No details found.</p>
		</c:if>
	
	
	
	<table>
	
	<c:forEach var="admin" items="${addDetails}">
	
	<c:set var="id" value="${admin.id}"/>
	<c:set var="name" value="${admin.name}"/>
	<c:set var="email" value="${admin.email}"/>
	<c:set var="telephone" value="${admin.telephone}"/>
	<c:set var="type" value="${admin.type}"/>
	<c:set var="username" value="${admin.username}"/>
	<c:set var="password" value="${admin.password}"/>
	
	<tr>
		<td>User name: </td>
		<td>${admin.username}</td>
	</tr>
	
	<tr>
		<td>Name: </td>
		<td>${admin.name}</td>
	</tr>
	 
	<tr>
		<td>Email: </td>
		<td>${admin.email}</td>
	</tr>
	
	<tr>
		<td>Phone:</td> 
		<td>${admin.telephone}</td>
	</tr>
	</c:forEach>
	</table>
            </div>
            
            <c:url value="UpdateAdminDetails.jsp" var="cusUpdate">
			<c:param name="id" value="${id}"/>
			<c:param name="name" value="${name}"/>
			<c:param name="email" value="${email}"/>
			<c:param name="telephone" value="${telephone}"/>
			<c:param name="uname" value="${username}"/>
			<c:param name="pass" value="${password}"/>
			</c:url>
			
			<div class="editLogout" style="margin-left: 200px;">
			<a href="${cusUpdate}">
            <input type="button" name="update" value="Edit Profile" class="btn" style="width: 130px;height: 40px;">
            </a>
            </div>
            
        </div>

        <!-- Pending Event Bookings Section -->
        <div class="pending-bookings" style="margin-left: -560px; width: 800px">
            <h2 style="text-align:center;">Event Bookings</h2>
            <table id="tb1">
                <thead>
                    <tr>
                        <th>Booking ID</th>
                        <th>Event Type</th>
                        <th>Event Date</th>
                        <th>Package Type</th>
                        <th>Hotel Name</th>
                        <th>Status</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="booking" items="${bookingList}">
                	<tr>
                		<c:forEach var="admin" items="${addDetails}">
	
						<c:set var="id" value="${admin.id}"/>
						<c:set var="name" value="${admin.name}"/>
						<c:set var="email" value="${admin.email}"/>
						<c:set var="telephone" value="${admin.telephone}"/>
						<c:set var="type" value="${admin.type}"/>
						<c:set var="username" value="${admin.username}"/>
						<c:set var="password" value="${admin.password}"/>
						
						
                    	<td>${booking.bookingID}</td>
                   	 	<td>${booking.eventType}</td>
                    	<td>${booking.eventDate}</td>
                    	<td>${booking.packageType}</td>
                    	<td>${booking.hotelName}</td>
                    	<td>${booking.bookingStatus}</td>
                    	
                    	<td style="width: 172px;">
                    	 
                    	<form action="approve" method="post">
                    	<input type="hidden" name="pid" value="${booking.bookingID}">
                    	<input type="hidden" name="id" value="${admin.id}">
                    	<input type="hidden" name="status" value="${booking.bookingStatus}">
                    	
                    	<c:choose>
        					<c:when test="${booking.bookingStatus == 'Pending'}">
            					<button type="submit" class="btn-approve">Approve</button>
        					</c:when>
        					<c:otherwise>
            					<button type="submit" class="btn-approve">Decline</button>
        					</c:otherwise>
    					</c:choose>
                    	
                    	</form>
                    
    					<form action="DeleteBookingsServlet" method="post" onsubmit="return confirmDeleteBooking('${booking.bookingID}')">
    					<input type="hidden" name="id" value="${admin.id}">
        				<input type="hidden" name="pid" value="${booking.bookingID}">
        				<button class="btn-delete" type="submit">Delete</button>
    					</form>
    					
    					<script>
    						function confirmDeleteBooking(${booking.bookingID}) {
       
        						let confirmation3 = confirm("Do you want to delete the event booking(Booking ID: '" + ${booking.bookingID} + "')?");        
        						return confirmation3;
    						}
						</script>
    					
						</td>
						</c:forEach>
                	</tr>
            		</c:forEach>
                </tbody>
            </table>
        </div>

        <!-- Manage User Profiles Section -->
        <div class="manage-users" style="width: 900px; margin-left: 10px">
            <h2 style="text-align: center">Manage User Profiles</h2>
            <table>
                <thead>
                    <tr>
                    	<th>Name</th>
                        <th>Username</th>
                        <th>Email</th>
                        <th>Type</th>
                        <th>Status</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="cus" items="${allDetails}">
                	<tr>
                		<c:forEach var="admin" items="${addDetails}">
						<c:set var="id" value="${admin.id}"/>
						
                    	<td>${cus.name}</td>
                   	 	<td>${cus.username}</td>
                    	<td>${cus.email}</td>
                    	<td>${cus.type}</td>
                    	<td>Active</td>
                    	
                    	<td>
                    	
    					<form action="deleteUser" method="post" onsubmit="return confirmDeactivateUser('${cus.username}')">
    					<input type="hidden" name="cusID" value="${cus.id}">
    					<input type="hidden" name="id" value="${admin.id}">
        				<input type="submit" value="Deactivate" class="btn-delete">
    					</form>
    					
    					<script>
    						function confirmDeactivateUser(${cus.username}) {
       
        						let confirmation1 = confirm("Do you want to deactivate the user account '" + ${cus.username} + "'?");        
        						return confirmation1;
    						}
						</script>
						
						</td>
						</c:forEach>
                	</tr>
                	</c:forEach>
                </tbody>
            </table>
        </div>

        <!-- Change Password Section -->
        <div class="change-password-container" style="margin-left: -210px; width: 600px;">
        <form action="change" method="post" class="change-password-form" onsubmit="return validateForm()">

            <h2>Change Password</h2><br>

            <c:forEach var="admin" items="${addDetails}">
			<c:set var="id" value="${admin.id}"/>
			<c:set var="name" value="${admin.name}"/>
			<c:set var="email" value="${admin.email}"/>
			<c:set var="telephone" value="${admin.telephone}"/>
			<c:set var="type" value="${admin.type}"/>
			<c:set var="username" value="${admin.username}"/>
			<c:set var="password" value="${admin.password}"/>

            <input type="hidden" value="${admin.id}" name="id">

            <div class="input-group">
                <input type="text" name="oldPass" value="${admin.password}" placeholder="${admin.password}" required>
            </div>
            <div class="input-group">
                <input type="password" name="newPass1" id="newPass1" placeholder="New Password" required>
            </div>
            <div class="input-group">
                <input type="password" name="newPass2" id="newPass2" placeholder="Confirm-Password" required>
            </div><br>
            
            <input type="submit" name="submit" class="change-btn" value="Change Password">
        	</c:forEach>
        </form>
        
        <script>
        
    		function validateForm() {

    			const password1 = document.getElementById("newPass1").value;
    			const password2 = document.getElementById("newPass2").value;
    		
        		if (password1.length < 6) {
            		alert("Password must be at least 6 characters long");
            		return false;
        		}
        		
        		if (password1 != password2){
    				alert("Password didn't match!");
                	return false;
    			}

        	return true;
        	
    		}
    		
	</script>
	
    </div>

        <!-- Pending Events Section -->
        <div class="pending-events" style="width: 900px; margin-left: 250px;">
            <h2 style="text-align:center;">Current Events</h2>
            <table>
                <thead>
                    <tr>
                        <th>Title</th>
                        <th>Description</th>
                        <th>Date Added</th>
                        <th>Price</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="events" items="${eventDetails}">
                	<tr>
                    	<td>${events.title}</td>
                   	 	<td>${events.description}</td>
                    	<td>${events.date}</td>
                    	<td>${events.price}</td>
                    	<td>
                        <form action="eventDelete" method="post" onsubmit="return confirmDelete('${events.title}')" >
                        	<input type="hidden" name="event_id" value="${events.id}">
                        	<button class="btn-delete" type="submit">Delete</button>
                        </form>
                        
                        <script>
    						function confirmDelete(${events.title}) {
       
        						let confirmation2 = confirm("Do you want to delete the event '" + ${events.title} + "'?");        
        						return confirmation2;
    						}
						</script>
                                               
                         </td>
                	</tr>
            		</c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    </main>

    <!-- Footer Section -->
    <footer class="footer">
        <p>Created by <span>Nexus Team</span> | All rights reserved</p>
    </footer>
</body>
</html>
