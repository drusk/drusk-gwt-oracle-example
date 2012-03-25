package ca.drusk.flightmanager.server.util.datetime;

/**
 * Methods for working with the Oracle Timestamp datatype.
 * 
 * @author drusk
 * 
 */
public class OracleTimeStampUtils {

	public static String toTimeStampWithTimeZone(String day, String time,
			int utcOffset) {
		String offsetStr = utcOffset < 0 ? "" + utcOffset : "+" + utcOffset;
		return day + " " + time + " " + offsetStr + ":00";
	}
}
