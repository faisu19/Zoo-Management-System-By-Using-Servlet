package Management;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/edit")
public class EditTicketServlet extends HttpServlet
{
    @SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
    {
    	HttpSession hs = req.getSession(false);//accessing existing session
    	if(hs==null)
    	{
    		req.setAttribute("msg", "Session Expired...<br>");
    		req.getRequestDispatcher("ExtraJspMsg.jsp").forward(req, res);
    	}
    	else
    	{
    		Long number = Long.parseLong(req.getParameter("mono"));
  
			ArrayList<BookingPageBean> al = (ArrayList<BookingPageBean>)hs.getAttribute("alist");
    		Iterator<BookingPageBean> it = al.iterator();
    		while(it.hasNext())
    		{
    			BookingPageBean bb = (BookingPageBean)it.next();
    			if(number.equals(bb.getMobileNo()))
    			{
    				req.setAttribute("bbean", bb);
    				req.getRequestDispatcher("EditTicket.jsp").forward(req, res);
    				break;
    			}
    		}//end loop
    	}
    	
    }
}
