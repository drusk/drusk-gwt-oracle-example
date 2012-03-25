package ca.drusk.flightmanager.server.util.datetime;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

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

	private DateFormat dateTimeFormatter = new SimpleDateFormat(
			"MMM dd, yyyy'T'HH:mm");

	public DateTimeFormatter() {
		dateTimeFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
	}

	public Timestamp parseDateTime(String dayString, String timeString)
			throws ParseException {
		Date day = dayFormatter.parseDate(dayString);
		System.out.println("Parsed day:" + day);
		Date time = timeFormatter.parseTime(timeString);
		System.out.println("Parsed time:" + time);
		return new Timestamp(day.getTime() + time.getTime());
	}

	public Timestamp parseDateTime(String dateTimeStr) throws ParseException {
		Date date = dateTimeFormatter.parse(dateTimeStr);
		return new Timestamp(date.getTime());
	}

}
