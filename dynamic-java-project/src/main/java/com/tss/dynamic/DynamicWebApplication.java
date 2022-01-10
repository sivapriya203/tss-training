package com.tss.dynamic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DynamicWebApplication")
public class DynamicWebApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int first = Integer.parseInt(request.getParameter("num1"));
		int second = Integer.parseInt(request.getParameter("num2"));
		int add = first + second;
		PrintWriter write = response.getWriter();
		write.print("<h2>Addition of numbers:" + add);
	}

}
