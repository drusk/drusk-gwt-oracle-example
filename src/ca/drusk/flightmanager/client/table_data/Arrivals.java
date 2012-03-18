package ca.drusk.flightmanager.client.table_data;

/**
 * Constants for the fields in the Arrivals table.
 * 
 * @author drusk
 * 
 */
public class Arrivals implements TableFields {

	public static final String ARRIVAL_DATE = "arrivalDate";

	public static final String ARRIVAL_DAY = "arrivalDay";

	public static final String ARRIVAL_TIME = "arrivalTime";

	public static final String STATUS = "status";

	@Override
	public String[] getPrimaryKeys() {
		return new String[] { FlightInstances.ID };
	}

	@Override
	public String[] getFields() {
		return new String[] { FlightInstances.ID, Gates.GATE,
				Airports.AIRPORT_CODE, ARRIVAL_DATE, STATUS };
	}

	@Override
	public String[] getEntryFields() {
		return new String[] { FlightInstances.ID, Gates.GATE,
				Airports.AIRPORT_CODE, ARRIVAL_DAY, ARRIVAL_TIME, STATUS };
	}

	@Override
	public String[] getDisplayFields() {
		return getFields();
	}

}
