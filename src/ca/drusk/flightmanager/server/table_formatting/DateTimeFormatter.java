package ca.drusk.flightmanager.server.table_formatting;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

/**
 * Uses {@link DefaultDayFormatter} and {@link DefaultTimeFormatter} to generate
 * a date object with both the day and time.
 * 
 * @author drusk
 * 
 */
public class DateTimeFormatter {

	private DefaultDayFormatter dayFormatter = new DefaultDayFormatter();

	private DefaultTimeFormatter timeFormatter = new DefaultTimeFormatter();

	public Timestamp parseDateTime(String dayString, String timeString)
			throws ParseException {
		Date day = dayFormatter.parseDate(dayString);
		Date time = timeFormatter.parseTime(timeString);
		return new Timestamp(day.getTime() + time.getTime());
	}

}
