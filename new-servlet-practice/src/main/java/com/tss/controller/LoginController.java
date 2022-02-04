package com.tss.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		PrintWriter writer = response.getWriter();
		if (username.equals("java1234") && password.equals("1234")) {
			writer.print("<h3 style=color:green>Login Successfully</h3>");
		} else {
			writer.print("<h3 style=color:red>**Login Failed</h3>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		PrintWriter writer = response.getWriter();
		if (username.equals("java1234") && password.equals("1234")) {
			writer.print("<h3 style=color:green>Login Successfully</h3>");
		} else {
			writer.print("<h3 style=color:red>**Login Failed</h3>");
		}
	}

}
