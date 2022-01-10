package com.tss.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/Addition")
public class Addition extends GenericServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int first = Integer.parseInt(request.getParameter("number1"));
		int second = Integer.parseInt(request.getParameter("number2"));
		int add = first + second;
		PrintWriter writer = response.getWriter();
		writer.println("<h3>Addition of two numbers is:</h3>" + add);
	}

}
