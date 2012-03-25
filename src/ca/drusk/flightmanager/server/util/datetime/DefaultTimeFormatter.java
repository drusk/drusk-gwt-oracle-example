package ca.drusk.flightmanager.server.util.datetime;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Wraps a {@link SimpleDateFormat} which has been configured for the default
 * time format in this project: HH:mm. Times are parsed as UTC time.
 * 
 * @author drusk
 * 
 */
public class DefaultTimeFormatter {

	private static final String TIME_ZONE = "UTC";

	private DateFormat formatter;

	public DefaultTimeFormatter() {
		formatter = new SimpleDateFormat("HH:mm");
		formatter.setTimeZone(TimeZone.getTimeZone(TIME_ZONE));
	}

	public Time parseTime(String timeString) throws ParseException {
		Date date = formatter.parse(timeString);
		return new Time(date.getTime());
	}

	public String formatTime(String fullTimeString) throws ParseException {
		DateFormat fullFormatter = new SimpleDateFormat();
		Date date = fullFormatter.parse(fullTimeString);
		return formatTime(date);
	}

	public String formatTime(Date date) {
		return formatter.format(date);
	}

}
