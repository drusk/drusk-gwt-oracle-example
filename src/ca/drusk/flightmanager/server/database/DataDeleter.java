package ca.drusk.flightmanager.server.database;

import java.sql.PreparedStatement;

/**
 * Deletes data from the database.
 * 
 * @author drusk
 * 
 */
public class DataDeleter extends DatabaseAccessor {

	private PreparedStatement airlineStmt = null;

	private PreparedStatement citizenshipStmt = null;

	private PreparedStatement planeModelStmt = null;

	private PreparedStatement locationsStmt = null;

	private PreparedStatement flightsStmt = null;

	private PreparedStatement incomingFlightStmt = null;

	private PreparedStatement outgoingFlightStmt = null;

	public int removeAirline(String code) {
		airlineStmt = prepareStatement(airlineStmt,
				"DELETE FROM Airlines WHERE code=?");
		setStringParameters(airlineStmt, code);
		return executeUpdate(airlineStmt);
	}

	public int removePlaneModel(String code) {
		planeModelStmt = prepareStatement(planeModelStmt,
				"DELETE FROM PlaneModels WHERE code=?");
		setParameters(planeModelStmt, code);
		return executeUpdate(planeModelStmt);
	}

	public int removeCitizenship(String citizenship) {
		citizenshipStmt = prepareStatement(citizenshipStmt,
				"DELETE FROM Citizenships WHERE citizenship=?");
		setParameters(citizenshipStmt, citizenship);
		return executeUpdate(citizenshipStmt);
	}

	public int removeLocation(String airportCode) {
		locationsStmt = prepareStatement(locationsStmt,
				"DELETE FROM Locations WHERE airportCode=?");
		setParameters(locationsStmt, airportCode);
		return executeUpdate(locationsStmt);
	}

	public int removeFlight(int flightNumber) {
		flightsStmt = prepareStatement(flightsStmt,
				"DELETE FROM Flights WHERE flightNumber=?");
		setParameters(flightsStmt, flightNumber);
		return executeUpdate(flightsStmt);
	}

	public int removeIncomingFlight(int flightNumber) {
		incomingFlightStmt = prepareStatement(incomingFlightStmt,
				"DELETE FROM IncomingFlights WHERE flightNumber=?");
		setParameters(incomingFlightStmt, flightNumber);
		return executeUpdate(incomingFlightStmt);
	}

	public int removeOutgoingFlight(int flightNumber) {
		outgoingFlightStmt = prepareStatement(outgoingFlightStmt,
				"DELETE FROM OutgoingFlights WHERE flightNumber=?");
		setParameters(outgoingFlightStmt, flightNumber);
		return executeUpdate(outgoingFlightStmt);
	}
}
