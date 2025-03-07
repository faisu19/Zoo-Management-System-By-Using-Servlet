package Management;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/anml")
public class ManagementServlet extends GenericServlet
{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		int checkDataInsertOrNot = 0 ;
		ManagementBean mb = new ManagementBean();
		mb.setEmail(req.getParameter("mid"));
		mb.setPassword(req.getParameter("psw"));
		res.setContentType("text/html");
		ManagementDAO md = new ManagementDAO();
		
		
		try 
		{
			checkDataInsertOrNot = md.insert();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		if(checkDataInsertOrNot>0)
		{
			req.setAttribute("msg", "User Login Success");
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, res);
		}
		
	}

}
