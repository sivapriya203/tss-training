package com.tss.redirect;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tss.util.Utility;

@WebServlet("/SendRedirect")
public class SendRedirect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String email = request.getParameter("email");
		String number = request.getParameter("number");
		PrintWriter writer = response.getWriter();
		if (Utility.validateEmail(email) && Utility.isValidMobileNo(number)) {
			response.sendRedirect("loginsuccessful.html");
		} else {
			writer.print("<center><h2 style=color:red>** Invalid Credentials</h2></center>");
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/login.html");
			reqDispatcher.include(request, response);
		}
	}

}
