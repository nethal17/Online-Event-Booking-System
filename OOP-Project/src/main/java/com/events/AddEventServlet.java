package com.events;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddEventServlet")
public class AddEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String orgID = request.getParameter("organizer_id");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String organizer = request.getParameter("organizer");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String price = request.getParameter("price");
		String date = request.getParameter("date");
		
		boolean isTrue;
		
		isTrue = EventDBUtil.addevent(title, description, organizer, email, phone, price, date);
		
		if(isTrue == true) {

			
			List<Admin> addDetails = AdminDButil.getAdminDetails(orgID);
			request.setAttribute("addDetails", addDetails);
			
			List<Event> eventList = EventDBUtil.getAllEventDetails();
			request.getSession().setAttribute("eventList", eventList);

			
			int totalEvents = EventDBUtil.getTotalEventsCount();
            int upcomingEvents = EventDBUtil.getUpcomingEventsCount();
            int pastEvents = EventDBUtil.getPastEventsCount();

            // Set counts as attributes
            request.setAttribute("totalEvents", totalEvents);
            request.setAttribute("upcomingEvents", upcomingEvents);
            request.setAttribute("pastEvents", pastEvents);
			
			RequestDispatcher dis = request.getRequestDispatcher("Ricky-Profile.jsp");
			dis.forward(request, response);
		}
		else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
		}
		
		
		
		
	}

}