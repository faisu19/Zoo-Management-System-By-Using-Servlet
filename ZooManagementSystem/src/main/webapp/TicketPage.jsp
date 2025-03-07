<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Zoo Park Ticket</title>
    <link rel="stylesheet" type="text/css" href="TicketPage.css">
</head>
<body>
    <div class="ticket">
        <h2>Zoo Park Ticket</h2>
        <div class="ticket-info">
            <p><span class="info-label">First Name   :</span> <span class="info-value"><%= request.getParameter("fname") %></span></p>
            <p><span class="info-label">Last Name    :</span> <span class="info-value"><%= request.getParameter("lname") %></span></p>
            <p><span class="info-label">Mobile Number:</span> <span class="info-value"><%= request.getParameter("number") %></span></p>
            <p><span class="info-label">Email        :</span> <span class="info-value"><%= request.getParameter("mid") %></span></p>
            <p><span class="info-label">Entry Time   :</span> <span class="info-value"><%= request.getParameter("time1") %></span></p>
            <p><span class="info-label">Go Out Time  :</span> <span class="info-value"><%= request.getParameter("time2") %></span></p>
            <p><span class="info-label">Number of Tourists:</span> <span class="info-value"><%= request.getParameter("people") %></span></p>
            <p><span class="info-label">Date         :</span> <span class="info-value"><%= request.getParameter("date") %></span></p>
            <p>
                <a href="welcomePage.html"><button>Conform</button></a>
                <a href="BookingPage.html"><button>Try Again</button></a>
            </p>
        </div>
    </div>
</body>
</html>
