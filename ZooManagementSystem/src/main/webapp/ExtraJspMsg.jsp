<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ExtraJSPMsg</title>
<link rel="stylesheet" type="text/css" href="ExtraJspMsg.css">
</head>
<body>
  <div class="container">
    <% 
    String msg = (String)request.getAttribute("msg");
    if (msg != null && !msg.isEmpty()) {
    %>
      <div class="message">
        <%= msg %>
      </div>
    <% } %>
  </div>
</body>
</html>
