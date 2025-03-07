package Management;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateTicketForAdminDAO
{
   public int k=0;
   public int update(BookingPageBean bb)
   {
	   try
	   {
		   Connection con = DBConnection.getConnection();
		   PreparedStatement ps = con.prepareStatement("Update UserTicket set entrytime=? ,gotime=? where mono=?");
		   ps.setString(1,bb.getEntryTime());
		   ps.setString(2, bb.getGoTime());
		   ps.setLong(3, bb.getMobileNo());
		   k = ps.executeUpdate();
	   }
		catch (Exception e) {
			e.printStackTrace();
		}
	   return k;
   }
}
