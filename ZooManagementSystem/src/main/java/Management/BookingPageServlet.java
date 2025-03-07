package Management;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/ticket")
public class BookingPageServlet extends HttpServlet
{
     protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
     {
    	 int k = 0;
    	 BookingPageBean bb = new BookingPageBean();
    	 bb.setfName(req.getParameter("fname"));
    	 bb.setlName(req.getParameter("lname"));
    	 bb.setMobileNo(Long.parseLong(req.getParameter("number")));
    	 bb.setmId(req.getParameter("mid"));
    	 bb.setEntryTime(req.getParameter("time1"));
    	 bb.setGoTime(req.getParameter("time2"));
    	 bb.setNoOfTour(Long.parseLong(req.getParameter("people")));
    	 bb.setDate(req.getParameter("date"));
    	 k = new BookingPageDAO().insert(bb);
    	 if(k>0)
    	 {
    		 req.setAttribute("msg", "Ticket Book Successfull...<br>");
    		 req.getRequestDispatcher("TicketPage.jsp").forward(req, res);
    	 }
    	 else
    	 {
    		 req.setAttribute("msg", "Encounter Some Problem Please Try Again...<br>");
    		 req.getRequestDispatcher("ExtraJspMsg.jsp").forward(req, res);
    	 }
     }
}
