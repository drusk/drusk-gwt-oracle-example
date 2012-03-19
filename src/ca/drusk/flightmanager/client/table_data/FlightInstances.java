package ca.drusk.flightmanager.client.table_data;

/**
 * Constants for the fields in the FlightInstances table.
 * 
 * @author drusk
 * 
 */
public class FlightInstances implements TableFields {

	public static final String ID = "id";

	@Override
	public String[] getPrimaryKeyAttributes() {
		return new String[] { ID };
	}

	@Override
	public String[] getFields() {
		return new String[] { ID, Flights.FLIGHT_NUMBER };
	}

	@Override
	public String[] getEntryFields() {
		return new String[] { Flights.FLIGHT_NUMBER };
	}

	@Override
	public String[] getDisplayFields() {
		return getFields();
	}

}
