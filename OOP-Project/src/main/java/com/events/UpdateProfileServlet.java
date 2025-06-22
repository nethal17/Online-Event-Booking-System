package com.events;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String uname = request.getParameter("uname");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		/*String id = "3";
		String uname = "Ricky17";
		String name = "Ricky Perera";
		String email = "ricky2@gmail.com";
		String phone = "0771111111";
		boolean isTrue;*/
		
		boolean isTrue = AdminDButil.updateprofile(id, uname, name, email, phone);
		
		if(isTrue == true) {
			
			List<Admin> addDetails = AdminDButil.getAdminDetails(id);
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
			
			RequestDispatcher dis = request.getRequestDispatcher("Ricky-Profile.jsp");
			dis.forward(request, response);
		}
		else {
			RequestDispatcher dis = request.getRequestDispatcher("unsuccess.jsp");
			dis.forward(request, response);
			
		}
	}

}