package ca.drusk.flightmanager.server.datetime;

import java.sql.Timestamp;
import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import ca.drusk.flightmanager.server.util.datetime.DateTimeFormatter;

/**
 * Tests for {@link DateTimeFormatter}.
 * 
 * @author drusk
 * 
 */
public class DateTimeFormatterTest {

	private DateTimeFormatter underTest;

	@Test
	public void parseDateAndTime() throws ParseException {
		String date = "Mar 23, 2012";
		String time = "21:30";
		String dateTime = date + "T" + time;
		Timestamp timestamp = underTest.parseDateTime(dateTime);
		System.out.println("timestamp= " + timestamp);
	}

	@Before
	public void setUp() {
		underTest = new DateTimeFormatter();
	}

}
