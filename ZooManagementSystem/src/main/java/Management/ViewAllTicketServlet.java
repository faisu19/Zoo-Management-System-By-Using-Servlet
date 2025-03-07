package Management;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewAllTicketServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
    {
    	HttpSession hs = req.getSession();//Accessing existing session
        if(hs==null)
        {
        	req.setAttribute("msg", "Session Expire...<br>");
        	req.getRequestDispatcher("Msg.jsp").forward(req, res);
        }
        else
        {
        	try 
        	{
				ArrayList<BookingPageBean> al = new ViewAllTicketsDAO().retrive();
				hs.setAttribute("alist", al);
				req.getRequestDispatcher("ViewAllTicket.jsp").forward(req, res);
			} 
        	catch (SQLException e) 
        	{
				e.printStackTrace();
			}
        }
    }
}
