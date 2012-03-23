package ca.drusk.flightmanager.server.util.datetime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

/**
 * Wraps a {@link SimpleDateFormat} which has been configured for the default
 * date format in this project: MMM dd yyyy. Parsing uses UTC time.
 * 
 * @author drusk
 * 
 */
public class DefaultDayFormatter {

	private static final String TIME_ZONE = "UTC";

	private DateFormat formatter;

	public DefaultDayFormatter() {
		formatter = new SimpleDateFormat("MMM dd, yyyy");
		formatter.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME,
				TIME_ZONE));
	}

	public Date parseDate(String dateString) throws ParseException {
		return formatter.parse(dateString);
	}

	public java.sql.Date parseDay(String dateString) throws ParseException {
		return new java.sql.Date(parseDate(dateString).getTime());
	}

}
