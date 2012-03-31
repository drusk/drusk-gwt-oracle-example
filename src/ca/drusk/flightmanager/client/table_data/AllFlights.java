package ca.drusk.flightmanager.client.table_data;

/**
 * Returns fields for all the flights tables, that is, Flights, IncomingFlights,
 * and OutgoingFlights.
 * 
 * @author drusk
 * 
 */
public class AllFlights implements TableFields {

	@Override
	public String[] getPrimaryKeyAttributes() {
		return new String[] { Flights.FLIGHT_NUMBER };
	}

	@Override
	public String[] getFields() {
		return new String[] { Flights.AIRLINE_CODE, Flights.FLIGHT_NUMBER,
				Flights.SOURCE, Flights.DESTINATION, Flights.PLANE_CODE,
				OutgoingFlights.PLANNED_DEPARTURE_TIME,
				IncomingFlights.PLANNED_ARRIVAL_TIME };
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
