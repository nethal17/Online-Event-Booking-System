package com.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.events.Event;
import com.events.EventDBUtil;

import Booking.Bookings;
import Booking.Customer;
import Booking.CustomerDBUTIL;

// servlet for log into the system
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		//String type = request.getParameter("type");
		
		int numForType;
		
		numForType = AdminDButil.validateUser(userName, password);
		
		if (numForType == 1) { // if return value equal to 1 redirect to AdminDashboard
			
			HttpSession session = request.getSession();
		    session.setAttribute("username", userName);
		    session.setAttribute("password", password);
			
			List<Admin> addDetails = AdminDButil.getAdmin(userName);
			request.setAttribute("addDetails", addDetails); 
	        
	        // Fetch booking details
	        List<EventBooking> bookingList = BookingsDButil.getAllBookingDetails();
	        request.setAttribute("bookingList", bookingList);
	        
	        List<Admin> allDetails = AdminDButil.getAllUserDetails();
			request.setAttribute("allDetails", allDetails);
			
			List<Events> eventDetails = EventDButil.getAllEventDetails();
			request.setAttribute("eventDetails", eventDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("AdminDashboard.jsp");
			dis.forward(request, response);
			
		}
		
		else if(numForType == 2) {	// if return value equal to 2 redirect to useraccount
			
			HttpSession session = request.getSession();
		    session.setAttribute("username", userName);
		    
		    List<Customer> cusDetails = CustomerDBUTIL.getCustomer(userName);
			request.setAttribute("cusDetails", cusDetails);
			  
			List<Bookings> bookingList = CustomerDBUTIL.getAllBookingDetails();
			request.setAttribute("bookingList", bookingList);
		    
			RequestDispatcher dis = request.getRequestDispatcher("useraccount.jsp");
			dis.forward(request, response);
		}
		
		else if(numForType == 3) { // if return value equal to 3 redirect to EventOrganizer's profile
			
			HttpSession session = request.getSession();
		    session.setAttribute("username", userName);
		    
		    List<Admin> addDetails = AdminDButil.getAdmin(userName);
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
		
		else if(numForType == 4) {	// if return value equal to 4 redirect to Vendor's profile
			
			HttpSession session = request.getSession();
		    session.setAttribute("username", userName);
		    
			RequestDispatcher dis = request.getRequestDispatcher("Vendor.jsp");
			dis.forward(request, response);
		}
		
		else { // if username or password is incorrect display an error
			
			out.println("<script type='text/javascript'>");
			out.println("alert('Your username or password incorrect');");
			out.println("location='Login.jsp'");
			out.println("</script>");
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session2 = request.getSession(false); // Do not create new session
        if (session2 != null) {
        	
        	String userName = (String) session2.getAttribute("username");
        	
        	if (userName.equals("nethal17")) {
        		
        		List<Admin> addDetails = AdminDButil.getAdmin(userName);
    			request.setAttribute("addDetails", addDetails); 
    	        
    	        // Fetch booking details
    	        List<EventBooking> bookingList = BookingsDButil.getAllBookingDetails();
    	        request.setAttribute("bookingList", bookingList);
    	        
    	        List<Admin> allDetails = AdminDButil.getAllUserDetails();
    			request.setAttribute("allDetails", allDetails);
    			
    			List<Events> eventDetails = EventDButil.getAllEventDetails();
    			request.setAttribute("eventDetails", eventDetails);
    			
    			RequestDispatcher dis = request.getRequestDispatcher("AdminDashboard.jsp");
    			dis.forward(request, response);
        	}
        	
        	if (userName.equals("ricky17")) {
        		
        		List<Admin> addDetails = AdminDButil.getAdmin(userName);
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
        	
        	
        }
	}

}
