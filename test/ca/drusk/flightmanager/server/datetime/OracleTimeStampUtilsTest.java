package ca.drusk.flightmanager.server.datetime;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.drusk.flightmanager.server.util.datetime.TimeStampUtils;

/**
 * Tests for {@link TimeStampUtils}.
 * 
 * @author drusk
 * 
 */
public class OracleTimeStampUtilsTest {

	@Test
	public void positiveOffset() {
		String timestamp = TimeStampUtils.toTimeStampWithTimeZone(
				"Mar 23, 2012", "9:30", "+2:00");
		assertEquals("Mar 23, 2012 9:30 +2:00", timestamp);
	}

	@Test
	public void negativeOffset() {
		String timestamp = TimeStampUtils.toTimeStampWithTimeZone(
				"Mar 23, 2012", "9:30", "-2:00");
		assertEquals("Mar 23, 2012 9:30 -2:00", timestamp);
	}

}
