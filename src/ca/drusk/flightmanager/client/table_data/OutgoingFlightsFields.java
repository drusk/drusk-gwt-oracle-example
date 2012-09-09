package ca.drusk.flightmanager.client.table_data;

/**
 * Constants for the fields in the OutgoingFlights table.
 * 
 * @author drusk
 * 
 */
public class OutgoingFlightsFields implements TableFields {

	public static final String PLANNED_DEPARTURE_TIME = "plannedDepartureTime";

	@Override
	public String[] getPrimaryKeyAttributes() {
		return new String[] { FlightsFields.FLIGHT_NUMBER };
	}

	@Override
	public String[] getFields() {
		return new String[] { FlightsFields.FLIGHT_NUMBER, PLANNED_DEPARTURE_TIME };
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
