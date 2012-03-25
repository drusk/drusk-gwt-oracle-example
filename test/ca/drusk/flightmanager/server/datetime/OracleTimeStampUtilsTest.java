package ca.drusk.flightmanager.server.datetime;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.drusk.flightmanager.server.util.datetime.OracleTimeStampUtils;

/**
 * Tests for {@link OracleTimeStampUtils}.
 * 
 * @author drusk
 * 
 */
public class OracleTimeStampUtilsTest {

	@Test
	public void positiveOffset() {
		String timestamp = OracleTimeStampUtils.toTimeStampWithTimeZone(
				"Mar 23, 2012", "9:30", 2);
		assertEquals("Mar 23, 2012 9:30 +2:00", timestamp);
	}

	@Test
	public void negativeOffset() {
		String timestamp = OracleTimeStampUtils.toTimeStampWithTimeZone(
				"Mar 23, 2012", "9:30", -2);
		assertEquals("Mar 23, 2012 9:30 -2:00", timestamp);
	}

}
