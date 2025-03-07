package Management;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BookingPageDAO 
{
    int k = 0;
    public int insert(BookingPageBean bb)
    {
    	try
    	{
    		Connection con = DBConnection.getConnection();
    		PreparedStatement ps = con.prepareStatement("Insert Into Userticket values(?,?,?,?,?,?,?,?)");
    		ps.setString(1, bb.getfName());
    		ps.setString(2, bb.getlName());
    		ps.setLong(3, bb.getMobileNo());
    		ps.setString(4, bb.getmId());
    		ps.setString(5, bb.getEntryTime());
    		ps.setString(6, bb.getGoTime());
    		ps.setLong(7, bb.getNoOfTour());
    		ps.setString(8, bb.getDate());
    		k=ps.executeUpdate();
    	}
    	catch (Exception e) {e.printStackTrace();}
    	return k;
    }
}
