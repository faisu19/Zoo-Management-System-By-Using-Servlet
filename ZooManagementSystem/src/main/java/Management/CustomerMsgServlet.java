package Management;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/message")
public class CustomerMsgServlet extends HttpServlet
{
	int k = 0;   
	@Override
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
    {
    	CustomerBean cb = new CustomerBean();
    	cb.setName(req.getParameter("msgName"));
    	cb.setEmail(req.getParameter("msgMid"));
    	cb.setNumber(Long.parseLong(req.getParameter("msgNumber")));
    	cb.setSubject(req.getParameter("msgSub"));
    	cb.setMessage(req.getParameter("msgMsg"));
    	
    	try {
			k = new CustomerMsgDAO().message(cb);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(k>0)
    	{
    		req.setAttribute("msgWithSuc", "The message you sent me has been received, and I will definitely respond to you on this message.");
    		req.getRequestDispatcher("customerMsg.jsp").forward(req, res);
    	}
    }
}
