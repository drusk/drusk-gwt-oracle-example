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

	private PreparedStatement airportsStmt = null;

	private PreparedStatement flightsStmt = null;

	private PreparedStatement gateStmt = null;

	private PreparedStatement arrivalStmt = null;

	private PreparedStatement departureStmt = null;

	private PreparedStatement passengerStmt = null;

	private PreparedStatement flightInstanceStmt = null;

	private PreparedStatement flightAttendanceStmt = null;

	private PreparedStatement baggageStmt = null;

	private PreparedStatement flightInventoryStmt = null;

	private PreparedStatement guardiansStmt = null;

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

	@SuppressWarnings("unchecked")
	public int removeFlight(String airlineCode, int flightNumber) {
		flightsStmt = prepareStatement(flightsStmt,
				"DELETE FROM Flights WHERE airlineCode=? AND flightNumber=?");
		setParameters(flightsStmt, airlineCode, flightNumber);
		return executeUpdate(flightsStmt);
	}

	public int removeGate(String gate, String airportCode) {
		gateStmt = prepareStatement(gateStmt,
				"DELETE FROM Gates WHERE gate=? AND airportCode=?");
		setParameters(gateStmt, gate, airportCode);
		return executeUpdate(gateStmt);
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

	public int removePassengerFromFlight(int passengerId, int flightId) {
		flightAttendanceStmt = prepareStatement(flightAttendanceStmt,
				"DELETE FROM FlightAttendance WHERE passengerId=? AND flightId=?");
		setParameters(flightAttendanceStmt, passengerId, flightId);
		return executeUpdate(flightAttendanceStmt);
	}

	public int removeBaggage(String id) {
		baggageStmt = prepareStatement(baggageStmt,
				"DELETE FROM Baggage WHERE id=?");
		setParameters(baggageStmt, id);
		return executeUpdate(baggageStmt);
	}

	public int removeBaggageForFlight(int passengerId, int flightId,
			int baggageId) {
		flightInventoryStmt = prepareStatement(
				flightInventoryStmt,
				"DELETE FROM FlightInventory WHERE passengerId=? AND flightId=? AND baggageId=?");
		setParameters(flightInventoryStmt, passengerId, flightId, baggageId);
		return executeUpdate(flightInventoryStmt);
	}

	public int removeGuardian(int guardianId, int infantId) {
		guardiansStmt = prepareStatement(guardiansStmt,
				"DELETE FROM Guardians WHERE guardianId=? AND infantId=?");
		setParameters(guardiansStmt, guardianId, infantId);
		return executeUpdate(guardiansStmt);
	}
}
