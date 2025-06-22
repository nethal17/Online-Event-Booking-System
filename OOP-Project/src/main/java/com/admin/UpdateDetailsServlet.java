package com.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateDetailsServlet")
public class UpdateDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("adminID");
		String name = request.getParameter("Name");
		String email = request.getParameter("Email");
		String phone = request.getParameter("Phone");
		String username = request.getParameter("Username");
		
		boolean isTrue;
		
		isTrue = AdminDButil.updateAdminDetails(id, name, email, phone, username);
		
		if (isTrue == true) {
			
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
		}
		else {
			
			List<Admin> addDetails = AdminDButil.getAdminDetails(id);
			request.setAttribute("addDetails", addDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("unsuccess.jsp");
			dis.forward(request, response);
		}
		
	}

}
