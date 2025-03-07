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
@WebServlet("/update")
public class UpdateTicketServlet extends HttpServlet
{
    @SuppressWarnings({ "unchecked", "unlikely-arg-type" })
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
    {
    	HttpSession hs = req.getSession();
    	if(hs==null)
    	{
    		req.setAttribute("msg", "Session Expired...<br>");
    		req.getRequestDispatcher("ExtraJspMsg.jsp").forward(req, res);
    	}
    	else
    	{
    		ArrayList<BookingPageBean> al = (ArrayList<BookingPageBean>)hs.getAttribute("alist");
    		String mono = req.getParameter("mono");
    		String etime = req.getParameter("etime");
    		String gotime = req.getParameter("gotime");
    		
    		Iterator<BookingPageBean> it = al.iterator();
    		while (it.hasNext()) 
    		{
				BookingPageBean bb = (BookingPageBean) it.next();
				if(mono.equals(bb.getMobileNo()))
				{
					bb.setEntryTime(etime);
					bb.setGoTime(gotime);
					
					int k = new UpdateTicketForAdminDAO().update(bb);
					if(k>0)
					{
						req.setAttribute("msg", "Ticket Update Successfully...<br>");
						req.getRequestDispatcher("UpdateTicket.jsp").forward(req, res);
					}
				}
				break;
				
			}
    		
    	}
    }
}
