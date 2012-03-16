package ca.drusk.flightmanager.server.table_formatting;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date formatter for dates that just represent the time in hours and minutes.
 * 
 * @author drusk
 * 
 */
public class HourMinuteFormatter {

	private DateFormat formatter = new SimpleDateFormat("HH:mm");

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
