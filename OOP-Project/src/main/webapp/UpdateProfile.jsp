<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Customer Details</title>

<!-- Internal CSS for better styling -->
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f4f8;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .container {
        background-color: #fff;
        padding: 40px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        max-width: 500px;
        width: 100%;
    }
    h2 {
        text-align: center;
        color: #007bff;
        margin-bottom: 20px;
    }
    form {
        display: flex;
        flex-direction: column;
    }
    label {
        font-weight: bold;
        margin-bottom: 5px;
        color: #333;
    }
    input[type="text"], input[type="password"] {
        padding: 10px;
        margin-bottom: 20px;
        border: 1px solid #ccc;
        border-radius: 5px;
        width: 100%;
        box-sizing: border-box;
        font-size: 14px;
    }
    input[type="text"]:focus, input[type="password"]:focus {
        border-color: #007bff;
        outline: none;
    }
    input[type="submit"] {
        padding: 10px;
        background-color: #007bff;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
    }
    input[type="submit"]:hover {
        background-color: #0056b3;
    }
</style>

<script>
    function validateForm() {
       
        const name = document.getElementById('name').value.trim();
        const phone = document.getElementById('telephone').value.trim();
        const uname = document.getElementById('uname').value.trim();
        
        
        if (name === "" || name.length < 2) {
            alert("Please enter a valid name (at least 2 characters).");
            return false;
        }


       
        const phonePattern = /^[0-9]{10,}$/;
        if (!phonePattern.test(phone)) {
            alert("Please enter a valid phone number (at least 10 digits).");
            return false;
        }

        /
        if (uname === "") {
            alert("Please enter a valid username.");
            return false;
        }

        return true;  
    }
</script>
</head>
<body>

    <div class="container">
        <h2>Update Customer Details</h2>
        
        <%
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String telephone = request.getParameter("telephone");
            String userName = request.getParameter("userName");
        %>

        <form action="update" method="post" onsubmit="return validateForm();">
            <label for="cusid">Customer ID</label>
            <input type="text" name="cusid" id="cusid" value="<%= id %>" readonly>
            
            <label for="name">Name</label>
            <input type="text" name="name" id="name" value="<%= name %>" required>
            
            <label for="email">Email</label>
            <input type="text" name="email" id="email" value="<%= email %>" required>
            
            <label for="telephone">Phone Number</label>
            <input type="text" name="phone" id="telephone" value="<%= telephone %>" required>
            
            <label for="uname">User Name</label>
            <input type="text" name="uname" id="uname" value="<%= userName %>" required>
            
            <input type="submit" name="submit" value="Update">
        </form>
    </div>

</body>
</html>
