package com.events;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RickyDeleteEventServlet")
public class RickyDeleteEventServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the event_id from the request
        String eventID = request.getParameter("event_id");
        
        String organizerID = request.getParameter("organizer_id");;

        // Call the deleteEvent method in the EventDBUtil
        boolean isDeleted = EventDBUtil.deleteEvent(eventID);

        // Redirect based on the result of the deletion
        if (isDeleted) {
        	
        	List<Admin> addDetails = AdminDButil.getAdminDetails(organizerID);
			request.setAttribute("addDetails", addDetails);
        	
        	List<Event> eventList = EventDBUtil.getAllEventDetails();
			request.setAttribute("eventList", eventList);
			
			int totalEvents = EventDBUtil.getTotalEventsCount();
            int upcomingEvents = EventDBUtil.getUpcomingEventsCount();
            int pastEvents = EventDBUtil.getPastEventsCount();

            // Set counts as attributes
            request.setAttribute("totalEvents", totalEvents);
            request.setAttribute("upcomingEvents", upcomingEvents);
            request.setAttribute("pastEvents", pastEvents);
			
            RequestDispatcher dispatcher = request.getRequestDispatcher("Ricky-Profile.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("unsuccess.jsp");
            dispatcher.forward(request, response);
        }
    }
}
