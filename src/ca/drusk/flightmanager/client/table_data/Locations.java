package ca.drusk.flightmanager.client.table_data;

/**
 * Constants for the fields in the Locations table.
 * 
 * @author drusk
 * 
 */
public final class Locations implements TableFields {

	public static final String AIRPORT_CODE = "airportCode";

	public static final String CITY = "city";

	public static final String COUNTRY = "country";

	public static final String UTC_OFFSET = "utcOffset";

	@Override
	public String getPrimaryKey() {
		return AIRPORT_CODE;
	}

	@Override
	public String[] getFields() {
		return new String[] { AIRPORT_CODE, CITY, COUNTRY, UTC_OFFSET };
	}

}
