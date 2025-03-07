package Management;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/admin")
public class AdminLoginServlet extends HttpServlet
{
	@Override
    protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
    {
    	String uname = req.getParameter("uname");
    	String psw = req.getParameter("psw");
    	AdminLoginBean ab = new AdminLoginDAO().login(uname, psw);
    	if(ab==null)
    	{
    		req.setAttribute("msg", "Invalid Login Process<br>");
    		req.getRequestDispatcher("ExtraJspMsg.jsp");
    	}
    	else
    	{
    		HttpSession hs = req.getSession();
    		hs.setAttribute("abean", ab);
    		req.getRequestDispatcher("AdminLogin.jsp").forward(req, res);
    	}
    }
}
