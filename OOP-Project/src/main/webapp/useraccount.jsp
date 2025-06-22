<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Details</title>
    <link rel="stylesheet" href="useraccount.css">
    
</head>
<body>

    <div class="container">
    <h1>Customer Details</h1>

    <c:forEach var="cus" items="${cusDetails}">
    
    <c:set var="id" value="${cus.id}"/>
    <c:set var="name" value="${cus.name}"/>
    <c:set var="email" value="${cus.email}"/>
    <c:set var="telephone" value="${cus.telephone}"/>
    <c:set var="userName" value="${cus.userName}"/>
    <c:set var="password" value="${cus.password}"/>
    
    <div class="profile-section">
        <!-- Profile Card on the left -->
        <div class="profile-card">
            <div class="profile-details">
            <h2>Your Details</h2>
                <div>
                    <div class="profile-label">Customer ID : ${cus.id}</div>
                    
                    <div class="profile-label2">Name : ${cus.name}</div>
                    
                    <div class="profile-label">Email : ${cus.email}</div>
                
                    <div class="profile-label2">Phone : ${cus.telephone}</div>
                    
                    <div class="profile-label">Type : ${cus.type}</div>
                    
                    <div class="profile-label2">User name : ${cus.userName}</div>
                </div>
            </div>
            
            <c:url value="UpdateProfile.jsp" var="cusupdate">
       			<c:param name="id" value="${id}"/>
        		<c:param name="name" value="${name}"/>
        		<c:param name="email" value="${email}"/>
        		<c:param name="telephone" value="${telephone}"/>
        		<c:param name="userName" value="${userName}"/>
        		
    		</c:url>
    
            
            <div class="edit-button-container">
                   
        			
        			<a href="${cusupdate}">
    				<input type="button" name="edit" class="edit-button" value="Edit Details" style="width:49%;">
    				</a>
    		
    				
    				<c:url value="DeleteProfile.jsp" var="cusdelete">
       					<c:param name="id" value="${id}"/>
        				<c:param name="name" value="${name}"/>
        				<c:param name="email" value="${email}"/>
        				<c:param name="telephone" value="${telephone}"/>
        				<c:param name="userName" value="${userName}"/>
        				<c:param name="password" value="${password}"/>
    				</c:url>
    				
    				<a href="${cusdelete}">
    				<input type="button" name="delete" class="delete-button" value="Delete Account" 
						    style="display: inline-block; 
						    	width: 49%;
						           background-color: #c0392b; 
						           color: white; 
						           padding: 12px 24px; 
						           border: none; 
						           border-radius: 5px; 
						           font-size: 16px; 
						           cursor: pointer; 
						           transition: background-color 0.3s ease, transform 0.2s ease;"
						    onmouseover="this.style.transform='scale(1.05)';" 
						    onmouseout="this.style.transform='scale(1)';">
    				</a>
    				
    				
    				
    				
    		</div>
    		
    		
        </div>

        <!-- Password Change Section on the right -->
        <div class="password-change-container">
            <h2>Update Password</h2>
                  
            <form action="ChangePasswordServlet" method="POST">
    <c:forEach var="cus" items="${cusDetails}">
        <input type="hidden" name="id" value="${cus.id}" />
        <input type="hidden" name="name" value="${cus.name}" />
        <input type="hidden" name="email" value="${cus.email}" />
        <input type="hidden" name="telephone" value="${cus.telephone}" />
        <input type="hidden" name="userName" value="${cus.userName}" />
        <input type="hidden" name="password" value="${cus.password}" />
        
        <div class="password-field">
            <label for="oldPassword">Old Password:</label>
            <input type="password" id="oldPassword" name="oldPass" required>
        </div>
        <div class="password-field">
            <label for="newPassword">New Password:</label>
            <input type="password" id="newPassword" name="newPass1" required>
        </div>
        <div class="password-field">
            <label for="confirmPassword">Confirm New Password:</label>
            <input type="password" id="confirmPassword" name="newPass2" required>
        </div>
        <div class="edit-button-container">
            <button type="submit" class="confirm-button" style="width:100%;">Confirm Change</button>
        </div>
    </c:forEach>
</form>

        </div>
    </div>

    </c:forEach>
<div class="bookingtb"><br>
    <h2>Your Bookings</h2>

    <!-- Booking Details Section -->
    <table>
        <thead>
            <tr>
                <th>Booking ID</th>
                <th>Event Date</th>
                <th>Event Time</th>
                <th>Hotel Name</th>
                <th>Event Type</th>
                <th>Status</th>
                
            </tr>
        </thead>
        <tbody>
            <c:forEach var="booking" items="${bookingList}">
                <tr>
                    <td>${booking.booking_id}</td>
                    <td>${booking.event_date}</td>
                    <td>${booking.event_time}</td>
                    <td>${booking.hotel_name}</td>
                    <td>${booking.type}</td>
                    <td>${booking.status}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    </div>
</div>
    

</body>
</html>
