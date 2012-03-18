package ca.drusk.flightmanager.client.table_data;

/**
 * Constants for the fields in the IncomingFlights table.
 * 
 * @author drusk
 * 
 */
public class IncomingFlights implements TableFields {

	public static final String PLANNED_ARRIVAL_TIME = "plannedArrivalTime";

	@Override
	public String[] getPrimaryKeys() {
		return new String[] { Flights.FLIGHT_NUMBER };
	}

	@Override
	public String[] getFields() {
		return new String[] { Flights.FLIGHT_NUMBER, PLANNED_ARRIVAL_TIME };
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
