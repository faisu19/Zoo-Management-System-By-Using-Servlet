<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="Management.AdminLoginBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AdminLoginJSP</title>
<!-- Link to your CSS file -->
<link rel="stylesheet" type="text/css" href="AdminLogin.css">
</head>
<body>
  <%
  AdminLoginBean ab = (AdminLoginBean)session.getAttribute("abean");
  %>
  <div class="welcome">
    Welcome Admin: <%= ab.getUname() %><br>
  </div>
  <div class="menu">
    <a href="view">View Tickets</a>
    <a href="Logout">Logout</a>
  </div>
</body>
</html>
