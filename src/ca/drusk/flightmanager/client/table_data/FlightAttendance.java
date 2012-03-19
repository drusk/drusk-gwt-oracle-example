package ca.drusk.flightmanager.client.table_data;

/**
 * Constants for the fields in the FlightAttendance table.
 * 
 * @author drusk
 * 
 */
public class FlightAttendance implements TableFields {

	public static final String PASSENGER_ID = "passengerId";

	public static final String FLIGHT_ID = "flightId";

	public static final String TRAVEL_CLASS = "travelClass";

	@Override
	public String[] getPrimaryKeyAttributes() {
		/*
		 * NOTE: this table doesn't actually have a primary key declared, but
		 * the passenger id and flight instance id could be made into a primary
		 * key. They are used to identify the tuples to delete.
		 */
		return new String[] { PASSENGER_ID, FLIGHT_ID };
	}

	@Override
	public String[] getFields() {
		return new String[] { PASSENGER_ID, FLIGHT_ID, TRAVEL_CLASS };
	}

	@Override
	public String[] getEntryFields() {
		return getFields();
	}

	@Override
	public String[] getDisplayFields() {
		return getFields();
	}

}
