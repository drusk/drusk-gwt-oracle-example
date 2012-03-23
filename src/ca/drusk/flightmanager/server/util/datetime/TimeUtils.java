package ca.drusk.flightmanager.server.util.datetime;

import java.sql.Time;

/**
 * Useful methods for working with {@link Time}.
 * 
 * @author drusk
 * 
 */
public class TimeUtils {

	/**
	 * Converts a Time object into minutes, rounded to the nearest minute.
	 * 
	 * @param time
	 *            the time to be converted to minutes
	 * @return the number of minutes represented by <code>time</code>, rounded
	 *         to the nearest minute.
	 */
	public static int convertToMinutes(Time time) {
		long milliseconds = time.getTime();
		System.out.println("milliseconds= " + milliseconds);
		double minutes = milliseconds / 60000.0;
		return (int) (minutes + 0.5);
	}

}
