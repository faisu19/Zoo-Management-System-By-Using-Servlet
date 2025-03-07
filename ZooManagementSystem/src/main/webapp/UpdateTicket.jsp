<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="Management.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Panel</title>
<link rel="stylesheet" href="UpdateTicket.css">  </head>
<body>
<%

   AdminLoginBean ab = (AdminLoginBean)session.getAttribute("abean");
   String msg = (String) request.getAttribute("msg");

%>
<div id="container"> <h1>Welcome- <%= ab.getUname() %>!</h1>
   <% if (msg != null) { %>  <p class="message"><%= msg %></p>
   <% } %>

   <nav>  <ul>
         <li><a href="view">View All Tickets</a></li>
         <li><a href="Logout">Logout</a></li>
      </ul>
   </nav>
</div>
</body>
</html>
