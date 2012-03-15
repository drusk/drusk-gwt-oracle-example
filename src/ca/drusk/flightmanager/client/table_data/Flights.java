package ca.drusk.flightmanager.client.table_data;

/**
 * Constants for the fields in the Flights table.
 * 
 * @author drusk
 * 
 */
public final class Flights implements TableFields {

	public static final String FLIGHT_NUMBER = "flightNumber";

	public static final String SOURCE = "source";

	public static final String DESTINATION = "destination";

	public static final String AIRLINE_CODE = "airlineCode";

	public static final String PLANE_CODE = "planeCode";

	@Override
	public String getPrimaryKey() {
		return FLIGHT_NUMBER;
	}

	@Override
	public String[] getFields() {
		return new String[] { FLIGHT_NUMBER, SOURCE, DESTINATION, AIRLINE_CODE,
				PLANE_CODE };
	}

}
