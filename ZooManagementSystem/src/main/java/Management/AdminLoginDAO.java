package Management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminLoginDAO 
{
    public AdminLoginBean ab = null;
    public AdminLoginBean login(String uname,String psw)
    {
    	try
    	{
    		Connection con = DBConnection.getConnection();
    		PreparedStatement ps = con.prepareStatement("select * from Admin where uname=? and psw=?");
    		ps.setString(1, uname);
    		ps.setString(2, psw);
    		ResultSet rs = ps.executeQuery();
    		if(rs.next())
    		{
    			ab = new AdminLoginBean();
				ab.setUname(rs.getString(1));
				ab.setPsw(rs.getString(2));
    		}
    	}
    	catch(Exception e) {e.printStackTrace();}
    	return ab;
    }
}
