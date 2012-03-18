package ca.drusk.flightmanager.client.table_data;

/**
 * Constants for the table names as they should be displayed in UI.
 * 
 * @author drusk
 * 
 */
public final class TableNames {

	public static final String AIRLINES = "Airlines";

	public static final String PLANE_MODELS = "Plane Models";

	public static final String CITIZENSHIPS = "Citizenships";

	public static final String LOCATIONS = "Locations";

	public static final String FLIGHTS = "Flights";

	public static final String GATES = "Gates";

	public static final String ARRIVALS = "Arrivals";

	public static final String DEPARTURES = "Departures";

	public static final String[] getAll() {
		return new String[] { AIRLINES, ARRIVALS, CITIZENSHIPS, DEPARTURES,
				FLIGHTS, GATES, LOCATIONS, PLANE_MODELS };
	}

}
