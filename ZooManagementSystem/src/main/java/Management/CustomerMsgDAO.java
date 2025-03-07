package Management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerMsgDAO 
{
    int k = 0;
    public int message(CustomerBean cb) throws SQLException
    {
    	
    	Connection con = DBConnection.getConnection();
    	PreparedStatement ps = con.prepareStatement("insert into CustomerMsg values(?,?,?,?,?)");
    	ps.setString(1, cb.getName());
    	ps.setString(2, cb.getEmail());
    	ps.setLong(3, cb.getNumber());
    	ps.setString(4, cb.getSubject());
    	ps.setString(5, cb.getMessage());
    	k = ps.executeUpdate();
    	
    	return k;
    }
}
