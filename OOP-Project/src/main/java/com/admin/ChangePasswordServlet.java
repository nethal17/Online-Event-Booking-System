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

@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String ID = request.getParameter("id");
		String oldPass = request.getParameter("oldPass");
		String newPass1 = request.getParameter("newPass1");
		String newPass2 = request.getParameter("newPass2");
		
		boolean isTrue;
		
		isTrue = AdminDButil.changePassword(ID, oldPass, newPass1, newPass2);
		
		if (isTrue == true) {
			
			/*List<Admin> addDetails = AdminDButil.getAdminDetails(ID);
			request.setAttribute("addDetails", addDetails);
			
			List<Bookings> bookingList = BookingsDButil.getAllBookingDetails();
	        request.setAttribute("bookingList", bookingList);
	        
	        List<Admin> allDetails = AdminDButil.getAllUserDetails();
			request.setAttribute("allDetails", allDetails); 
			
			List<Events> eventDetails = EventDButil.getAllEventDetails();
			request.setAttribute("eventDetails", eventDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("Login.jsp");
			dis.forward(request, response);*/
			
			out.println("<script type='text/javascript'>");
			out.println("alert('Password changed successfully!');");
			out.println("location='Login.jsp'");
			out.println("</script>");
		}
		else {
			
			out.println("<script type='text/javascript'>");
			out.println("alert('Password did not match!');");
			
			
			List<Admin> addDetails = AdminDButil.getAdminDetails(ID);
            request.setAttribute("addDetails", addDetails);

            List<EventBooking> bookingList = BookingsDButil.getAllBookingDetails();
            request.setAttribute("bookingList", bookingList);
            
            List<Admin> allDetails = AdminDButil.getAllUserDetails();
			request.setAttribute("allDetails", allDetails);
			
			List<Events> eventDetails = EventDButil.getAllEventDetails();
			request.setAttribute("eventDetails", eventDetails);
			
			out.println("location='AdminLoginServlet'");
			out.println("</script>");
		}
		
		
	}

}
