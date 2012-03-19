package ca.drusk.flightmanager.client.table_data;

/**
 * Constants for the fields in the FlightInventory table.
 * 
 * @author drusk
 * 
 */
public class FlightInventory implements TableFields {

	public static final String PASSENGER_ID = "passengerId";

	public static final String FLIGHT_ID = "flightId";

	public static final String BAGGAGE_ID = "baggageId";

	@Override
	public String[] getPrimaryKeyAttributes() {
		return new String[] { PASSENGER_ID, FLIGHT_ID, BAGGAGE_ID };
	}

	@Override
	public String[] getFields() {
		return new String[] { PASSENGER_ID, FLIGHT_ID, BAGGAGE_ID };
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
