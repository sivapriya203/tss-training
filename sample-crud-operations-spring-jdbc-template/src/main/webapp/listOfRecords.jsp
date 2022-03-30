<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%@page import="com.tss.pojo.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style></style>
</head>
<body>
	<%
		User user = new User();
	%>
	<h2>User's Details</h2>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Phone</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${records}" var="record">
			<tr>
				<td><c:out value="${record.name}" /></td>
				<td><c:out value="${record.phoneNo}" /></td>
				<td><a href="<c:url value='/get/${record.phoneNo}' />">Edit</a></td>
				<td><a href="<c:url value='/delete/${record.phoneNo}' />">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<h2>${msg}</h2>
	<input type=button value="Back" onCLick="history.back()">
	<br>
	<br>
	<input type="button" class="btn btn-lg btn-success"
		onclick="location.href='index.jsp';" value="Home" />
</body>
</html>

