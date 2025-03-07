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
@WebServlet("/del")
public class DeleteTicketServlet extends HttpServlet
{
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
    		Long mono = Long.parseLong(req.getParameter("mono")); 
    		@SuppressWarnings("unchecked")
			ArrayList<BookingPageBean> al = (ArrayList<BookingPageBean>)hs.getAttribute("alist");
    		Iterator<BookingPageBean> it = al.iterator();
    		while(it.hasNext())
    		{
    			BookingPageBean bb = (BookingPageBean)it.next();
    			if(mono.equals(bb.getMobileNo()))
    			{
    				int k = new DeleteTicketDAO().delete(bb);
    				if(k>0)
    				{
    					req.setAttribute("msg", "Ticket Deleted Successfully...<br>");
    					req.getRequestDispatcher("ExtraJspMsg.jsp").forward(req, res);
    				}
    			}
    		}//end loop
    	}
    	
    }
}
