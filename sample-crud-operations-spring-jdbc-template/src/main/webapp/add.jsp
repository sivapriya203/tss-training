<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.box {
	background-color: Black;
	width: 88px;
	height: 25px;
	text-color: white;
	border-radius: 10px;
}

.box a {
	color: white;
	padding-left: 12px;
	font-size:25px;
}
</style>
</head>
<body>
   <form action="add" method="POST">
     <div class="container">
     <h2>Add user details:</h2>
      Name:<input type="text" name="name"><br><br>
      PhoneNo:<input type="text" name="phoneNo"><br><br>
      <input type="submit" value="add" />
      <br><br>
     </div>
   </form>
   <form action="index.jsp">
    <input type="submit" value="HOME" />
   </form>
</body>
</html>