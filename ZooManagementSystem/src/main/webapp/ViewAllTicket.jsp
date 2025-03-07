<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="Management.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ViewAllTicketJSP</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
    }
    .container {
        width: 80%;
        margin: 20px auto;
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    h1 {
        text-align: center;
        margin-bottom: 20px;
    }
    .booking-table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
    }
    .booking-table th, .booking-table td {
        padding: 10px;
        border-bottom: 1px solid #ddd;
        text-align: left;
    }
    .booking-table th {
        background-color: #f2f2f2;
    }
    .booking-table td a {
        color: #007bff;
        text-decoration: none;
        margin-right: 10px;
    }
    .booking-table td a:hover {
        text-decoration: underline;
    }
    .logout-link {
        display: block;
        text-align: center;
        margin-top: 20px;
    }
</style>
</head>
<body>
<div class="container">
    <h1>Booking Management</h1>
    <%
    AdminLoginBean ab = (AdminLoginBean) session.getAttribute("abean");
    ArrayList<BookingPageBean> al = (ArrayList<BookingPageBean>) session.getAttribute("alist");
    out.println("Welcome To: " + ab.getUname() + "<br>");
    if (al.size() == 0) {
        out.println("Tickets are Not Available...<br>");
    } else {
        %>
        <table class="booking-table">
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Mobile No</th>
                <th>Email</th>
                <th>Entry Time</th>
                <th>Exit Time</th>
                <th>No of Tours</th>
                 <th>Date</th>
                <th>Action</th>
            </tr>
            <%
            Iterator<BookingPageBean> it = al.iterator();
            while (it.hasNext()) {
                BookingPageBean bb = it.next();
                %>
                <tr>
                    <td><%= bb.getfName() %></td>
                    <td><%= bb.getlName() %></td>
                    <td><%= bb.getMobileNo() %></td>
                    <td><%= bb.getmId() %></td>
                    <td><%= bb.getEntryTime() %></td>
                    <td><%= bb.getGoTime() %></td>
                    <td><%= bb.getNoOfTour() %></td>
                    <td><%= bb.getDate() %></td>
                    <td>
                        <a href='edit?mono=<%= bb.getMobileNo() %>'>Edit</a>
                       <a href='del?mono=<%= bb.getMobileNo() %>'>Delete</a>
                    </td>
                </tr>
                <%
            }
        }
        %>
        </table>
        <a class="logout-link" href="Logout">Logout</a>
    </div>
</body>
</html>
