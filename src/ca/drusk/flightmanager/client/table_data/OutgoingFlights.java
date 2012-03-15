package ca.drusk.flightmanager.client.table_data;

/**
 * Constants for the fields in the OutgoingFlights table.
 * 
 * @author drusk
 * 
 */
public class OutgoingFlights implements TableFields {

	public static final String PLANNED_DEPARTURE_TIME = "plannedDepartureTime";

	@Override
	public String getPrimaryKey() {
		return Flights.FLIGHT_NUMBER;
	}

	@Override
	public String[] getFields() {
		return new String[] { Flights.FLIGHT_NUMBER, PLANNED_DEPARTURE_TIME };
	}

}
