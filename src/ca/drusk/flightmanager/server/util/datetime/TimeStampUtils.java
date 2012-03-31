package ca.drusk.flightmanager.server.util.datetime;

/**
 * Methods for working with the Oracle Timestamp datatype.
 * 
 * @author drusk
 * 
 */
public class TimeStampUtils {

	public static String toTimeStampWithTimeZone(String day, String time,
			String utcOffset) {
		return day + " " + time + " " + utcOffset;
	}
}
