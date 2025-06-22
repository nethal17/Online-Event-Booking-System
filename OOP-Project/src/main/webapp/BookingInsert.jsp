<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Event Booking Form</title>
    <script>
        function validateForm() {

            const email = document.getElementById('email').value;
            const eventDate = document.getElementById('event_date').value;
            const eventTime = document.getElementById('time').value;
            const hotelName = document.getElementById('hotel_name').value.trim();
            const additional = document.getElementById('textBox').value.trim();

            const currentDate = new Date().toISOString().split('T')[0];

            
            if (!email) {
                alert('Please enter a valid email address.');
                return false;
            }

            
            if (eventDate < currentDate) {
                alert('Event Date cannot be in the past.');
                return false;
            }

            
            if (!eventTime) {
                alert('Please enter a valid time for the event.');
                return false;
            }

            
            if (!hotelName) {
                alert('Please enter the hotel name.');
                return false;
            }

            
            if (additional.length < 10) {
                alert('Additional requirements must be at least 10 characters long.');
                return false;
            }

            return true; 
        }
    </script>
</head>
<body style="font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; box-sizing: border-box;">
    <div class="container" style="width: 60%; margin: 30px auto; background-color: #fff; padding: 20px; border: 1px solid #ccc; border-radius: 10px;">
        <div class="form-header" style="text-align: center; margin-bottom: 20px;">
            <h1 style="font-size: 2rem; color: #3a4b9e;">Event Booking Form</h1>
        </div>

        <form action="insert" method="POST" onsubmit="return validateForm();">
            <fieldset class="booking-info" style="border: 2px solid #3a4b9e; border-radius: 10px; padding: 30px; margin: 50px;">
                <legend style="color: #3a4b9e; font-size: 1.2rem; padding: 0 10px; font-weight: bold;">Booking Information</legend>

                <label for="email" style="display: block; font-weight: bold; color: #333; margin-bottom: 5px;">Email Address:</label>
                <input type="email" id="email" name="email" required style="width: 100%; padding: 8px; margin-bottom: 15px; border-radius: 5px; border: 1px solid #ccc;" placeholder="Enter your email">

                <label for="event_date" style="display: block; font-weight: bold; color: #333; margin-bottom: 5px;">Event Date:</label>
                <input type="date" id="event_date" name="event_date" required style="width: 100%; padding: 8px; margin-bottom: 15px; border-radius: 5px; border: 1px solid #ccc;">

                <label for="time" style="display: block; font-weight: bold; color: #333; margin-bottom: 5px;">Time:</label>
                <input type="time" id="time" name="time" required style="width: 100%; padding: 8px; margin-bottom: 15px; border-radius: 5px; border: 1px solid #ccc;">

                <label for="hotel_name" style="display: block; font-weight: bold; color: #333; margin-bottom: 5px;">Hotel Name:</label>
                <input type="text" id="hotel_name" name="hotel_name" required style="width: 100%; padding: 8px; margin-bottom: 15px; border-radius: 5px; border: 1px solid #ccc;" placeholder="Enter the hotel name">

                <!-- Hidden Fields -->
                <input type="hidden" value="23" name="cusID" id="cusID">
                <input type="hidden" value="Pending" name="status" id="status">
                <input type="hidden" value="Gold" name="package_type" id="package_type">
                <input type="hidden" value="Birthday" name="type" id="type">
            </fieldset>

            <fieldset class="additional_requirement" style="border: 2px solid #3a4b9e; border-radius: 10px; padding: 30px; margin: 50px;">
                <legend style="color: #3a4b9e; font-size: 1.2rem; padding: 0 10px; font-weight: bold;">Additional Requirements</legend>
                <textarea id="textBox" name="additional" required style="width: 100%; height: 150px; padding: 8px; margin-bottom: 15px; border-radius: 5px; border: 1px solid #ccc;" placeholder="Enter additional requirements (min. 10 characters)"></textarea>
            </fieldset>

            <!-- Submit Button -->
            <div class="form-footer" style="display: flex; justify-content: center; margin-top: 20px;">
                <button type="submit" style="background-color: #4e73df; color: white; padding: 12px 20px; border: none; border-radius: 5px; font-size: 16px; cursor: pointer; transition: background-color 0.3s ease;">Book Now</button>
            </div>
        </form>
    </div>
</body>
</html>
