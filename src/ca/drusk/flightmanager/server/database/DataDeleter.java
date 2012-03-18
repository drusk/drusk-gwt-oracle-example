package ca.drusk.flightmanager.server.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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

	private PreparedStatement airportsStmt = null;

	private PreparedStatement flightsStmt = null;

	private PreparedStatement incomingFlightStmt = null;

	private PreparedStatement outgoingFlightStmt = null;

	private PreparedStatement gateStmt = null;

	private PreparedStatement arrivalStmt = null;

	private PreparedStatement departureStmt = null;

	private PreparedStatement passengerStmt = null;

	private PreparedStatement flightInstanceStmt = null;

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

	public int removeAirport(String airportCode) {
		airportsStmt = prepareStatement(airportsStmt,
				"DELETE FROM Airports WHERE airportCode=?");
		setParameters(airportsStmt, airportCode);
		return executeUpdate(airportsStmt);
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

	public int removeGate(String gate, String airportCode) {
		// gateStmt = prepareStatement(gateStmt,
		// "DELETE FROM Gates WHERE gate=? AND airportCode=?");
		// setParameters(gateStmt, gate, airportCode);
		// System.out.println("DELETE FROM Gates WHERE gate=" + gate
		// + " AND airportCode=" + airportCode);
		// return executeUpdate(gateStmt);

		String query = "DELETE FROM Gates WHERE gate='" + gate
				+ "' AND airportCode='" + airportCode + "'";
		try {
			Statement stmt = conn.createStatement();
			int executeUpdate = stmt.executeUpdate(query);
			System.out.println(executeUpdate);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int removeArrival(String id) {
		arrivalStmt = prepareStatement(arrivalStmt,
				"DELETE FROM Arrivals WHERE id=?");
		setParameters(arrivalStmt, id);
		return executeUpdate(arrivalStmt);
	}

	public int removeDeparture(String id) {
		departureStmt = prepareStatement(departureStmt,
				"DELETE FROM Departures WHERE id=?");
		setParameters(departureStmt, id);
		return executeUpdate(departureStmt);
	}

	public int removePassenger(String id) {
		passengerStmt = prepareStatement(passengerStmt,
				"DELETE FROM Passengers WHERE id=?");
		setParameters(passengerStmt, id);
		return executeUpdate(passengerStmt);
	}

	public int removeFlightInstance(String id) {
		flightInstanceStmt = prepareStatement(flightInstanceStmt,
				"DELETE FROM FlightInstances WHERE id=?");
		setParameters(flightInstanceStmt, id);
		return executeUpdate(flightInstanceStmt);
	}
}
