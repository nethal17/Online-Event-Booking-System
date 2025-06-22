package com.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookingDetailsServlet")
public class BookingDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int ID = 1;
        
        // Fetch booking details
        List<EventBooking> bookingList = BookingsDButil.getBookingDetails(ID);
        
        // Set the booking details as an attribute
        request.setAttribute("bookingList", bookingList);
        
        // Forward the request to Bookings.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("AdminDashboard.jsp");
        dispatcher.forward(request, response);
	}

}
