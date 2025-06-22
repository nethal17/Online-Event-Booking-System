<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="./CSS/RickyLogin.css">
<script src="https://kit.fontawesome.com/f140081b0d.js" crossorigin="anonymous"></script>
</head>
<body style="background-color:#222;">

<br><br>

	<div class="container">
            <div class="box" id="box1">
                <div class="description">
                    <img src="./images/gallery6.jpg"> <br><br>
                    <p>Welcome to NEXUS Events, your go-to platform for seamless event planning 
                       and management. Log in to Book, Organize, and Track your Events, manage vendors, 
                       and keep your attendees updated. Whether it's a small gathering or a grand celebration, 
                       we're here to help you bring your vision to life effortlessly...
                    </p>
                </div>
            </div>

            <div class="box" id="box2">
                <div class="login-card">

                    <div class="login-icon">
                    <i class="fa-solid fa-user fa-bounce fa-2x"></i>
                    <h3>Sign In</h3>
                    </div>            
        
                    <form action="log" method="post" class="login-form">
                    
                    <input type="text" placeholder="Username" name="username">
                    <input type="password" placeholder="Password" name="password">
                    <p>Forgot Password</p>
                    <button type="submit" id="sbm1" name="submit" value="Login">Login</button>
                    
                    </form>
                    <p id="p1">Still don't have an account?</p><br>
                    <a href="Signup.jsp"><button type="submit" id="sbm2">Sign Up</button></a>
                
                </div>
            </div>
        </div>
        
</body>
</html>
