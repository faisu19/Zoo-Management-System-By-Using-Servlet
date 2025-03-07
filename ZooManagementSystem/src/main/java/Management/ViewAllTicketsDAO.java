package Management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewAllTicketsDAO 
{
    public ArrayList<BookingPageBean> al = new ArrayList<BookingPageBean>();
    
    public ArrayList<BookingPageBean> retrive() throws SQLException
    {
      try
      {
    	Connection con = DBConnection.getConnection();
    	PreparedStatement ps = con.prepareStatement("select * from UserTicket");
    	ResultSet rs = ps.executeQuery();
    	while(rs.next())
    	{
    		BookingPageBean bb = new BookingPageBean();
    		bb.setfName(rs.getString(1));
    		bb.setlName(rs.getString(2));
    		bb.setMobileNo(Long.parseLong(rs.getString(3)));
    		bb.setmId(rs.getString(4));
    		bb.setEntryTime(rs.getString(5));
    		bb.setGoTime(rs.getString(6));
    		bb.setNoOfTour(Long.parseLong(rs.getString(7)));
    		bb.setDate(rs.getString(8));
    		al.add(bb);//BookingPageBean added to ArrayList object 
    	}
      }
      catch(Exception e) {e.printStackTrace();}
      return al;
    }
}
