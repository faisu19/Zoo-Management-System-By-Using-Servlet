package Management;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteTicketDAO 
{
    int k=0;
    public int delete(BookingPageBean bb)
    {
    	try
    	{
    		Connection con = DBConnection.getConnection();
    		PreparedStatement ps = con.prepareStatement("Delete From  userticket where mono=?");
    		ps.setLong(1, bb.getMobileNo());
    		k = ps.executeUpdate();
    	}
    	catch (Exception e) {
			e.printStackTrace();
		}
    	return k;
    }
}
