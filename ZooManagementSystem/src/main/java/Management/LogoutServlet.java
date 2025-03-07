package Management;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet
{
   protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
   {
	   HttpSession hs = req.getSession();
	   if(hs==null)
	   {
		   req.setAttribute("msg", "Session Expired...<br>");
	   }
	   else
	   {
		   hs.removeAttribute("abean");
		   hs.invalidate();//Destroying
		   req.setAttribute("msg", "LoggedOut Successfully...<br>");
	   }
	   req.getRequestDispatcher("ExtraJspMsg.jsp").forward(req, res);
   }
}
