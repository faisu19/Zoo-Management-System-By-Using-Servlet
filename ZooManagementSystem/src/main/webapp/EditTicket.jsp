<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="Management.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Ticket</title>
<link rel="stylesheet" href="EditTicket.css">  </head>
<body>
  <%
  AdminLoginBean ab = (AdminLoginBean)session.getAttribute("abean");
  out.println("<br>");
  BookingPageBean bb = (BookingPageBean)request.getAttribute("bbean");
  %>

  <div class="container">  <h1>Edit Ticket</h1>  <form action="update" method="post" class="edit-form">  <input type="hidden" name="mono" value=<%=bb.getMobileNo() %>>

      <div class="form-group">  <label for="etime">Entry Time:</label>
        <input type="time" name="etime" id="etime" value=<%=bb.getEntryTime() %>> 
      </div>

      <div class="form-group">
        <label for="gotime">Time To Go Out:</label>
        <input type="time" name="gotime" id="gotime" value=<%=bb.getGoTime() %>> 
      </div>

      <input type="submit" value="Update Ticket" class="update-btn">

    </form>

  </div>

</body>
</html>
