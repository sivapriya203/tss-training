<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="ISO-8859-1">
<title>messages</title>
</head>
<body>
	<h2>${msg}</h2>
	<br>
	<input type=button value="Back" onCLick="history.back()">
	<br>
</body>
</html>
