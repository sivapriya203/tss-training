package com.tss.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tss.util.Utility;

@WebServlet("/OtpController")
public class OtpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String numbr = request.getParameter("num");
		if (Utility.isValidMobileNo(numbr)) {
			out.print("<h3>Your OTP is: </h3>");
			out.print(Utility.generateOtp(10000));
		} else {
			out.print("<center><h2 style=color:red>** Invalid Number</h2></center>");
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/otp.html");
			reqDispatcher.include(request, response);
		}

	}
}
