package ca.drusk.flightmanager.client.table_data;

/**
 * Constants for the fields in the Departures table.
 * 
 * @author drusk
 * 
 */
public class Departures implements TableFields {

	public static final String ID = "id";

	public static final String DEPARTURE_DATE = "departureDate";

	public static final String DEPARTURE_DAY = "departureDay";

	public static final String DEPARTURE_TIME = "departureTime";

	public static final String STATUS = "status";

	@Override
	public String[] getPrimaryKeyAttributes() {
		return new String[] { ID };
	}

	@Override
	public String[] getFields() {
		return new String[] { ID, Gates.GATE, Airports.AIRPORT_CODE,
				DEPARTURE_DATE, STATUS };
	}

	@Override
	public String[] getEntryFields() {
		return new String[] { ID, Gates.GATE, Airports.AIRPORT_CODE,
				DEPARTURE_DAY, DEPARTURE_TIME, STATUS };
	}

	@Override
	public String[] getDisplayFields() {
		return getFields();
	}

}
