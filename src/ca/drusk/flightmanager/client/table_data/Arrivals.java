package ca.drusk.flightmanager.client.table_data;

/**
 * Constants for the fields in the Arrivals table.
 * 
 * @author drusk
 * 
 */
public class Arrivals implements TableFields {

	public static final String ID = "id";

	public static final String ARRIVAL_DATE = "arrivalDate";

	public static final String ARRIVAL_DAY = "arrivalDay";

	public static final String ARRIVAL_TIME = "arrivalTime";

	public static final String STATUS = "status";

	@Override
	public String[] getPrimaryKeys() {
		return new String[] { ID };
	}

	@Override
	public String[] getFields() {
		return new String[] { ID, Gates.GATE, Locations.AIRPORT_CODE,
				ARRIVAL_DATE, STATUS, Flights.FLIGHT_NUMBER };
	}

	@Override
	public String[] getEntryFields() {
		return new String[] { Gates.GATE, Locations.AIRPORT_CODE, ARRIVAL_DAY,
				ARRIVAL_TIME, STATUS, Flights.FLIGHT_NUMBER };
	}

	@Override
	public String[] getDisplayFields() {
		return getFields();
	}

}
