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
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Event Organizer Profile</title>
    <link rel="stylesheet" href="./CSS/profile.css">
</head>
<body>
	<header class="header">
		<a href="home.jsp" class="logo"><span>N</span>exus</a>
        <nav class="navbar">
			<a href="RedirectToHomeServlet">Home</a>
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
            if (session3 != null && session3.getAttribute("username") != null) {
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

    <section class="event-counts">
        <div class="count-box">
            <p>Total Events</p><hr>
            <h2>${totalEvents}</h2>
        </div>
        <div class="count-box">
            <p>Newly Added Events</p><hr>
            <h2>${upcomingEvents}</h2>
        </div>
        <div class="count-box">
            <p>Deleted Events</p><hr>
            <h2>${pastEvents}</h2>
        </div>
    </section>

    <main>
        <div class="profile-left">
        <div class="profile">
            <!-- Profile Information -->
            <section class="profile-info">
                <h2>Profile Information</h2><hr><br>
                
                <!-- Loop through addDetails to display profile info -->
                <c:forEach var="admin" items="${addDetails}">
                	
                	<c:set var="id" value="${admin.id}"/>
                	<c:set var="name" value="${admin.name}"/>
                	<c:set var="email" value="${admin.email}"/>
                	<c:set var="telephone" value="${admin.telephone}"/>
                	<c:set var="type" value="${admin.type}"/>
                	<c:set var="username" value="${admin.username}"/>
                	<c:set var="password" value="${admin.password}"/>
                	
                
                    <p><strong>User Name:</strong> ${admin.username}</p><br>
                    <p><strong>Name:</strong> ${admin.name}</p><br>
                    <p><strong>Email:</strong> ${admin.email}</p><br>
                    <p><strong>Phone Number:</strong> ${admin.telephone}</p><br>
                    
                </c:forEach>
                
                <c:url value="Ricky-updateprofile.jsp" var="profileupdate">
                	<c:param name="id" value="${id}"/>
                	<c:param name="name" value="${name}"/>
                	<c:param name="email" value="${email}"/>
                	<c:param name="telephone" value="${telephone}"/>
                	<c:param name="uname" value="${username}"/>
                	<c:param name="pass" value="${password}"/>
                </c:url>

                <div class="profile-actions">
                	<a href="${profileupdate}">
                    	<input type="button" name="update" value="Edit Profile" class="btn">
                    </a>
                </div>
                
            </section>

			<br>
		</div>
		<div clas="pass">
            <!-- Update Password Section -->
            <section class="update-password"><br>
                <h2>Update Password</h2><hr>
                <form action="rickyChange" method="post">
                
                	<c:forEach var="admin" items="${addDetails}">
                	
                	<c:set var="id" value="${admin.id}"/>
                	<c:set var="name" value="${admin.name}"/>
                	<c:set var="email" value="${admin.email}"/>
                	<c:set var="telephone" value="${admin.telephone}"/>
                	<c:set var="type" value="${admin.type}"/>
                	<c:set var="username" value="${admin.username}"/>
                	<c:set var="password" value="${admin.password}"/>
                	
                	<input type="hidden" value="${admin.id}" name="id">
                	
                    <label>Old Password</label>
                    <input type="text" name="oldPass" value="${admin.password}" placeholder="${admin.password}" required>

                    <label>New Password</label>
                    <input type="password" name="newPass1" placeholder="New Password" required>

                    <label>Re-enter New Password</label>
                    <input type="password" name="newPass2" placeholder="Enter Again" required><br><br>
					<div class="profile-actions">
						<input type="submit" name="submit" value="Update Password" class="btn">
					</div>
                    
                    
                    </c:forEach>
                    
                </form>
				
            </section>
        </div>
        </div>

        <div class="profile-right">
            <!-- My Events Section -->
            <section class="my-events">
                <h2>My Events</h2><hr>

                <!-- Upcoming Events Section -->
                <h3>Newly Added Events</h3>
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
                	<c:forEach var="admin" items="${addDetails}">
                	<c:set var="id" value="${admin.id}"/>
                	
	                <c:forEach var="events" items="${eventList}">
	                	<tr>
	                    	<td>${events.title}</td>
	                   	 	<td>${events.description}</td>
	                    	<td>${events.date}</td>
	                    	<td>${events.price}</td>
	                    	<td>
	                        	<form id="deleteForm" action="rickyDelete" method="post" onsubmit="return confirmDelete('${events.title}')" >
	                        		<input type="hidden" name="event_id" value="${events.id}">
	                        		<input type="hidden" name="organizer_id" value="${admin.id}">
	                        		<button class="btn-delete" type="submit">Delete</button>
	                        	</form>
	                        
		                        <script>
		    						function confirmDelete(${events.title}) {
		       
		        						let confirmation = confirm("Do you want to delete the event '" + ${events.title} + "'?");        
		        						return confirmation;
		    						}
								</script>
	                                               
	                        </td>
	                	</tr>
	            	</c:forEach>
	            	
	            	</c:forEach>
                </tbody>
            </table><br>
            
            <c:url value="Ricky-addevent.jsp" var="addEvent">
                	<c:param name="id" value="${id}"/>
                	<c:param name="name" value="${name}"/>
                	<c:param name="email" value="${email}"/>
                	<c:param name="telephone" value="${telephone}"/>
                	<c:param name="uname" value="${username}"/>
                	<c:param name="pass" value="${password}"/>
                </c:url>
            
            <div class="profile-actions">
            	 <a href="${addEvent}">
                	<button class="btn">Add New Event</button>	
                </a>
            </div>  
               
			
            </section>
        </div>
    </main>

    <footer class="footer">
        <p>Created by <span>Nexus Team</span> | All rights reserved</p>
    </footer>

</body>
</html>

