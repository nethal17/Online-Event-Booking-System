package com.events;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RickyChangePasswordServlet")
public class RickyChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ID = request.getParameter("id");
		String oldPass = request.getParameter("oldPass");
		String newPass1 = request.getParameter("newPass1");
		String newPass2 = request.getParameter("newPass2");
		
		boolean isTrue;
		
		isTrue = AdminDButil.changePassword(ID, oldPass, newPass1, newPass2);
		
		if (isTrue == true) {
			
			RequestDispatcher dis = request.getRequestDispatcher("Login.jsp");
			dis.forward(request, response);
		}
		else {
			
			RequestDispatcher dis = request.getRequestDispatcher("unsuccess.jsp");
			dis.forward(request, response);
		}
	}

}
