package com.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// servlet for approve pending event bookings
@WebServlet("/ApproveEventBookingServlet")
public class ApproveEventBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String PID = request.getParameter("pid");
		String adminID = request.getParameter("id");
		//String Status = request.getParameter("status");
		
		boolean isTrue;
		
		isTrue = BookingsDButil.approveEventBooking(PID);
		
		if (isTrue == true) {
        	
            List<Admin> addDetails = AdminDButil.getAdminDetails(adminID);
            request.setAttribute("addDetails", addDetails);

            List<EventBooking> bookingList = BookingsDButil.getAllBookingDetails();
            request.setAttribute("bookingList", bookingList);
            
            List<Admin> allDetails = AdminDButil.getAllUserDetails();
			request.setAttribute("allDetails", allDetails); 
			
			List<Events> eventDetails = EventDButil.getAllEventDetails();
			request.setAttribute("eventDetails", eventDetails);

            RequestDispatcher dispatcher = request.getRequestDispatcher("AdminDashboard.jsp");
            dispatcher.forward(request, response);
            
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("unsuccess.jsp");
            dispatcher.forward(request, response);
        }
		
		
	}

}
