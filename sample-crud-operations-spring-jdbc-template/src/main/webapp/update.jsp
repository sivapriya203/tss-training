<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="update" method="GET">
		<h3>Add user details:</h3>
		Name:<input type="text" name="name" value="${name}" /><br> <br>
		phone number:<input type="text" name="phoneNo" value="${phoneNo}" readonly="readonly" /><br> <br> <input
			type="submit" value="update" />
	</form>
</body>
</html>