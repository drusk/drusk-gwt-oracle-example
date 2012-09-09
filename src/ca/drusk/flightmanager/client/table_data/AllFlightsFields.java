package ca.drusk.flightmanager.client.table_data;

/**
 * Returns fields for all the flights tables, that is, Flights, IncomingFlights,
 * and OutgoingFlights.
 * 
 * @author drusk
 * 
 */
public class AllFlightsFields implements TableFields {

	@Override
	public String[] getPrimaryKeyAttributes() {
		return new String[] { FlightsFields.FLIGHT_NUMBER };
	}

	@Override
	public String[] getFields() {
		return new String[] { FlightsFields.AIRLINE_CODE, FlightsFields.FLIGHT_NUMBER,
				FlightsFields.SOURCE, FlightsFields.DESTINATION, FlightsFields.PLANE_CODE,
				OutgoingFlightsFields.PLANNED_DEPARTURE_TIME,
				IncomingFlightsFields.PLANNED_ARRIVAL_TIME };
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
