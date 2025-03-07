package Management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ManagementDAO 
{
	int checkUserAddOrNot = 0;
    public int insert() throws ClassNotFoundException, SQLException
    {
    	ManagementBean mb = new ManagementBean();
    	Connection con = DBConnection.getConnection();
    	PreparedStatement ps = con.prepareStatement("insert into UserLogin values(?,?)");
    	ps.setString(1, mb.getEmail());
    	ps.setString(2, mb.getPassword());
    	checkUserAddOrNot = ps.executeUpdate();
    	
    	return checkUserAddOrNot;
    }
}
