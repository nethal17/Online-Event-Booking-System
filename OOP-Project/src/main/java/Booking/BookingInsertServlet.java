package Booking;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BookingInsertServlet")
public class BookingInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
        String email = request.getParameter("email");
        String event_date = request.getParameter("event_date");
        String time = request.getParameter("time");
        String status = request.getParameter("status");
        String package_type = request.getParameter("package_type");
        String type = request.getParameter("type");
        String cusID = request.getParameter("cusID");
        String hotel_name = request.getParameter("hotel_name");
        String additional = request.getParameter("additional");
        
        
        boolean isTrue;
        
        isTrue = BookingDBUTIL.insertBooking(email, type, event_date, time, package_type, hotel_name, additional, status, cusID);
        
        if(isTrue == true) {
        	RequestDispatcher dis = request.getRequestDispatcher("Home.jsp");
        	dis.forward(request, response);
        }else {
        	RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
        	dis2.forward(request, response);
        }
	}

}
