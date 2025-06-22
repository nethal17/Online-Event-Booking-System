<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete User Account</title>
<link rel="stylesheet" href="DeleteProfile.css">
</head>
<body>
		
	<div>	
	
		
    <%
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
    %>
    
    
    
    <form action="delete" method="post">
    	
    	<h1>User Account Delete</h1>
    	
        <label for="cusid">Customer ID</label>
        <input type="text" name="cusid" id="cusid" value="<%= id %>" readonly>
        
        <label for="name">Name</label>
        <input type="text" name="name" id="name" value="<%= name %>" readonly>
        
        <label for="email">Email</label>
        <input type="text" name="email" id="email" value="<%= email %>" readonly>
        
        <label for="telephone">Phone Number</label>
        <input type="text" name="phone" id="telephone" value="<%= telephone %>" readonly>
        
        <label for="uname">User Name</label>
        <input type="text" name="uname" id="uname" value="<%= userName %>" readonly>
        
        <input type="submit" name="submit" value="Delete Account">
    </form>
    </div>
</body>
</html>
