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

	public static final String AIRPORTS = "Airports";

	public static final String FLIGHTS = "Flights";

	public static final String GATES = "Gates";

	public static final String ARRIVALS = "Arrivals";

	public static final String DEPARTURES = "Departures";

	public static final String PASSENGERS = "Passengers";

	public static final String FLIGHT_INSTANCES = "Flight Instances";

	public static final String FLIGHT_ATTENDANCE = "Flight Attendance";

	public static final String BAGGAGE = "Baggage";

	public static final String FLIGHT_INVENTORY = "Flight Inventory";

	public static final String GUARDIANS = "Guardians";

	public static final String INFANTS = "Infants";

	public static final String PASSENGER_CLASS = "Passenger Class";

	public static final String[] getDeletionTables() {
		return new String[] { AIRLINES, AIRPORTS, ARRIVALS, BAGGAGE,
				CITIZENSHIPS, DEPARTURES, FLIGHTS, FLIGHT_ATTENDANCE,
				FLIGHT_INSTANCES, FLIGHT_INVENTORY, GATES, PASSENGERS,
				PASSENGER_CLASS, PLANE_MODELS };
	}

	public static final String[] getEntryTables() {
		return new String[] { AIRLINES, AIRPORTS, ARRIVALS, BAGGAGE,
				CITIZENSHIPS, DEPARTURES, FLIGHTS, FLIGHT_ATTENDANCE,
				FLIGHT_INVENTORY, GATES, PASSENGERS, PASSENGER_CLASS,
				PLANE_MODELS };
	}

	public static final String[] getViewingTables() {
		return new String[] { AIRLINES, AIRPORTS, ARRIVALS, BAGGAGE,
				CITIZENSHIPS, DEPARTURES, FLIGHTS, FLIGHT_ATTENDANCE,
				FLIGHT_INSTANCES, FLIGHT_INVENTORY, GATES, INFANTS, PASSENGERS,
				PASSENGER_CLASS, PLANE_MODELS };
	}

}
