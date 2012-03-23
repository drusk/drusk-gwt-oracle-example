package ca.drusk.flightmanager.server.util.datetime;

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
		System.out.println("Day: " + day);
		Date time = timeFormatter.parseTime(timeString);
		System.out.println("Time: " + time);
		Timestamp dayTs = new Timestamp(day.getTime());
		Timestamp timeTs = new Timestamp(time.getTime());
		System.out.println("TS day: " + dayTs);
		System.out.println("TS time: " + timeTs);
		return new Timestamp(day.getTime() + time.getTime());
	}

}
