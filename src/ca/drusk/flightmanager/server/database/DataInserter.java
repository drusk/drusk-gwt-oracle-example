package ca.drusk.flightmanager.server.database;

import java.sql.PreparedStatement;
import java.sql.Time;

/**
 * Inserts data into the database.
 * 
 * @author drusk
 * 
 */
public class DataInserter extends DatabaseAccessor {

	private PreparedStatement airlineStmt = null;

	private PreparedStatement citizenshipsStmt = null;

	private PreparedStatement planeModelStmt = null;

	private PreparedStatement locationStmt = null;

	private PreparedStatement flightsStmt = null;

	private PreparedStatement incomingFlightStmt = null;

	private PreparedStatement outgoingFlightStmt = null;

	public int addAirline(String name, String code, String website) {
		airlineStmt = prepareStatement(airlineStmt,
				"INSERT INTO Airlines(name, code, website) VALUES (?, ?, ?)");
		setStringParameters(airlineStmt, name, code, website);
		return executeUpdate(airlineStmt);
	}

	public int addPlaneModel(int code, int capacity) {
		planeModelStmt = prepareStatement(planeModelStmt,
				"INSERT INTO PlaneModels(code, capacity) VALUES(?, ?)");
		setParameters(planeModelStmt, code, capacity);
		return executeUpdate(planeModelStmt);
	}

	public int addCitizenship(String citizenship) {
		citizenshipsStmt = prepareStatement(citizenshipsStmt,
				"INSERT INTO Citizenships(citizenship) VALUES(?)");
		setParameters(citizenshipsStmt, citizenship);
		return executeUpdate(citizenshipsStmt);
	}

	@SuppressWarnings("unchecked")
	public int addLocation(String airportCode, String city, String country,
			int utcOffset) {
		locationStmt = prepareStatement(
				locationStmt,
				"INSERT INTO Locations(airportCode, city, country, utcOffset) VALUES(?, ?, ?, ?)");
		setParameters(locationStmt, airportCode, city, country, utcOffset);
		return executeUpdate(locationStmt);
	}

	@SuppressWarnings("unchecked")
	public int addFlight(int flightNumber, String source, String destination,
			String airlineCode, int planeCode) {
		flightsStmt = prepareStatement(
				flightsStmt,
				"INSERT INTO Flights(flightNumber, source, destination, airlineCode, planeCode) VALUES(?, ?, ?, ?, ?)");
		setParameters(flightsStmt, flightNumber, source, destination,
				airlineCode, planeCode);
		return executeUpdate(flightsStmt);
	}

	@SuppressWarnings("unchecked")
	public int addIncomingFlight(int flightNumber, Time plannedArrivalTime) {
		incomingFlightStmt = prepareStatement(incomingFlightStmt,
				"INSERT INTO IncomingFlights(flightNumber, plannedArrivalTime) VALUES(?, ?)");
		setParameters(incomingFlightStmt, flightNumber, plannedArrivalTime);
		return executeUpdate(incomingFlightStmt);
	}

	@SuppressWarnings("unchecked")
	public int addOutgoingFlight(int flightNumber, Time plannedDepartureTime) {
		outgoingFlightStmt = prepareStatement(outgoingFlightStmt,
				"INSERT INTO OutgoingFlights(flightNumber, plannedDepartureTime) VALUES(?, ?)");
		setParameters(outgoingFlightStmt, flightNumber, plannedDepartureTime);
		return executeUpdate(outgoingFlightStmt);
	}

}
