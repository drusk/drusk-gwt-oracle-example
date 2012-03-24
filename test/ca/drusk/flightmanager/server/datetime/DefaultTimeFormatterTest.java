package ca.drusk.flightmanager.server.datetime;

import static org.junit.Assert.assertEquals;

import java.sql.Time;
import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import ca.drusk.flightmanager.server.util.datetime.DefaultTimeFormatter;
import ca.drusk.flightmanager.server.util.datetime.TimeUtils;

/**
 * Tests for {@link DefaultTimeFormatter}.
 * 
 * @author drusk
 * 
 */
public class DefaultTimeFormatterTest {

	private DefaultTimeFormatter underTest;

	@Test
	public void oneHourConvertsTo60minutes() throws ParseException {
		Time targetTime = underTest.parseTime("1:00");
		int minutes = TimeUtils.convertToMinutes(targetTime);
		assertEquals(60, minutes);
	}

	@Before
	public void setUp() {
		underTest = new DefaultTimeFormatter();
	}

}
