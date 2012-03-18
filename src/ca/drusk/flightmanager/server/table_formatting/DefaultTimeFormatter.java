package ca.drusk.flightmanager.server.table_formatting;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Wraps a {@link SimpleDateFormat} which has been configured for the default
 * time format in this project: HH:mm
 * 
 * @author drusk
 * 
 */
public class DefaultTimeFormatter {

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
