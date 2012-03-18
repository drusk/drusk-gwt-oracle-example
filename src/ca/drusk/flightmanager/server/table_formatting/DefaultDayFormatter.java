package ca.drusk.flightmanager.server.table_formatting;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Wraps a {@link SimpleDateFormat} which has been configured for the default
 * date format in this project: MMM dd yyyy
 * 
 * @author drusk
 * 
 */
public class DefaultDayFormatter {

	private DateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");

	public Date parseDate(String dateString) throws ParseException {
		return formatter.parse(dateString);
	}

	public java.sql.Date parseDay(String dateString) throws ParseException {
		return new java.sql.Date(parseDate(dateString).getTime());
	}

}
