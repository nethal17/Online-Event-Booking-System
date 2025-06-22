package com.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteEventServlet")
public class DeleteEventServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String eventID = request.getParameter("event_id");
        String id = "1";

        
        boolean isDeleted = EventDButil.deleteEvent(eventID);

        // Redirect based on the result of the deletion
        if (isDeleted) {
        	
        	List<Admin> addDetails = AdminDButil.getAdminDetails(id);
			request.setAttribute("addDetails", addDetails);
			
			List<EventBooking> bookingList = BookingsDButil.getAllBookingDetails();
	        request.setAttribute("bookingList", bookingList);
	        
	        List<Admin> allDetails = AdminDButil.getAllUserDetails();
			request.setAttribute("allDetails", allDetails);
			
			List<Events> eventDetails = EventDButil.getAllEventDetails();
			request.setAttribute("eventDetails", eventDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("AdminDashboard.jsp");
			dis.forward(request, response);
			
			/*int totalEvents = EventDButil.getTotalEventsCount();
            int upcomingEvents = EventDButil.getUpcomingEventsCount();
            int pastEvents = EventDBUtil.getPastEventsCount();

            // Set counts as attributes
            request.setAttribute("totalEvents", totalEvents);
            request.setAttribute("upcomingEvents", upcomingEvents);
            request.setAttribute("pastEvents", pastEvents);*/
			
            RequestDispatcher dispatcher = request.getRequestDispatcher("AdminDashboard.jsp");
            dispatcher.forward(request, response);
            
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("unsuccess.jsp");
            dispatcher.forward(request, response);
        }
    }
}