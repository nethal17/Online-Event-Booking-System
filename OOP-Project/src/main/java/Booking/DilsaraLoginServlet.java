package Booking;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DilsaraLoginServlet")
public class DilsaraLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		
		  String username = request.getParameter("username");
		  String password = request.getParameter("password");
		  String type = request.getParameter("type");
		  
		  boolean isTrue = CustomerDBUTIL.validateUser(username, password, type);
		  
		  if (isTrue == true) {
			  
			  List<Customer> cusDetails = CustomerDBUTIL.getCustomer(username);
			  request.setAttribute("cusDetails", cusDetails);
			  
			  List<Bookings> bookingList = CustomerDBUTIL.getAllBookingDetails();
			  request.setAttribute("bookingList", bookingList);
			  
			  RequestDispatcher dis = request.getRequestDispatcher("useraccount.jsp");
			  dis.forward(request, response);
		  }
		  else {
			  
			  	out.println("<script type='text/javascript'>");
				out.println("alert('Your username or password incorrect');");
				out.println("location='Login.jsp'");
				out.println("</script>");
		  }
		  
		  
	}

}
