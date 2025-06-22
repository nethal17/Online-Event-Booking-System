<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up Form</title>
    <link rel="stylesheet" href="./CSS/NewFile.css">

</head>

<body>

    <div class="signup-container">
		
   	<form action="insert" method="post" class="signup-form" onsubmit="return validateForm()">
    	<h2>Sign Up</h2>
    
    	<div class="input-group">
        	<label>Register As: </label>
        		<select name="type" id="type">
            		<option value="Admin">Organizer</option>
            		<option value="Organizer">Vendor</option>
            		<option value="Customer">Customer</option>
        		</select>
    	</div>
    
   		<div class="input-group">
        	<input type="text" id="name" name="name" placeholder="Name" required>
    	</div>
    	
    	<div class="input-group">
        	<input type="email" id="email" name="email" placeholder="Email" required>
    	</div>
    	
    	<div class="input-group">
        	<input type="tel" id="phone" name="phone" placeholder="Phone number" required>
    	</div>
    	
    	<div class="input-group">
        	<input type="text" id="username" name="username" placeholder="Username" required>
    	</div>
    	
    	<div class="input-group">
        	<input type="password" id="password" name="password" placeholder="Password" required>
    	</div>

    	<div class="terms-group">
        	<input type="checkbox" id="terms" name="terms" required>
        	<label for="terms">I agree to these <a href="#">Terms & Conditions</a></label>
    	</div>
    
    	<button type="submit" class="signup-btn">Sign Up</button>
    
    	<p class="login-link">Already a member? <a href="Login.jsp">Login Here</a></p>
	</form>

<script>
    function validateForm() {

        const phone = document.getElementById("phone").value;
        const phonePattern = /^[0-9]{10}$/;
        if (!phonePattern.test(phone)) {
            alert("Please enter a valid 10-digit phone number");
            return false;
        }

        // Validate password strength
        const password = document.getElementById("password").value;
        if (password.length < 6) {
            alert("Password must be at least 6 characters long");
            return false;
        }

        return true;
    }
</script>

	
    </div>
    
</body>

</html>
