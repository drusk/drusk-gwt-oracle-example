package ca.drusk.flightmanager.server.database;

import java.sql.Date;
import java.sql.PreparedStatement;

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

	private PreparedStatement infantStmt = null;

	private PreparedStatement guardiansStmt = null;

	private PreparedStatement passengerClassStmt = null;

	public int addAirline(String name, String code, String website) {
		airlineStmt = prepareStatement(airlineStmt,
				"INSERT INTO Airlines(name, code, website) VALUES (?, ?, ?)");
		setStringParameters(airlineStmt, name, code, website);
		return executeUpdate(airlineStmt);
	}

	@SuppressWarnings("unchecked")
	public int addPlaneModel(String code, String name, int capacity) {
		planeModelStmt = prepareStatement(planeModelStmt,
				"INSERT INTO PlaneModels(code, name, capacity) VALUES(?, ?, ?)");
		setParameters(planeModelStmt, code, name, capacity);
		return executeUpdate(planeModelStmt);
	}

	public int addCitizenship(String citizenship) {
		citizenshipsStmt = prepareStatement(citizenshipsStmt,
				"INSERT INTO Citizenships(citizenship) VALUES(?)");
		setParameters(citizenshipsStmt, citizenship);
		return executeUpdate(citizenshipsStmt);
	}

	public int addAirport(String airportCode, String city, String country,
			String utcOffset) {
		airportsStmt = prepareStatement(
				airportsStmt,
				"INSERT INTO Airports(airportCode, city, country, utcOffset) VALUES(?, ?, ?, ?)");
		setParameters(airportsStmt, airportCode, city, country, utcOffset);
		return executeUpdate(airportsStmt);
	}

	@SuppressWarnings("unchecked")
	public int addFlight(String airlineCode, int flightNumber, String source,
			String destination, String planeCode, String departureTime,
			String arrivalTime) {
		String sql = "INSERT INTO Flights(airlineCode, flightNumber, source, destination, planeCode, plannedDepartureTime, plannedArrivalTime) VALUES(?, ?, ?, ?, ?, "
				+ TimezoneUtils.TO_TIMESTAMP_TZ
				+ ", "
				+ TimezoneUtils.TO_TIMESTAMP_TZ + ")";
		flightsStmt = prepareStatement(flightsStmt, sql);
		setParameters(flightsStmt, airlineCode, flightNumber, source,
				destination, planeCode, departureTime, arrivalTime);
		return executeUpdate(flightsStmt);
	}

	public int addGate(String gate, String airportCode) {
		gateStmt = prepareStatement(gateStmt,
				"INSERT INTO Gates(gate, airportCode) VALUES(?, ?)");
		setParameters(gateStmt, gate, airportCode);
		return executeUpdate(gateStmt);
	}

	@SuppressWarnings("unchecked")
	public int addArrival(int id, String gate, String airportCode,
			String arrivalDate, String status) {
		arrivalStmt = prepareStatement(
				arrivalStmt,
				"INSERT INTO Arrivals(id, gate, airportCode, arrivalDate, status) VALUES(?, ?, ?, "
						+ TimezoneUtils.TO_TIMESTAMP_TZ + ", ?)");
		setParameters(arrivalStmt, id, gate, airportCode, arrivalDate, status);
		return executeUpdate(arrivalStmt);
	}

	@SuppressWarnings("unchecked")
	public int addDeparture(int id, String gate, String airportCode,
			String departureDate, String status) {
		departureStmt = prepareStatement(
				departureStmt,
				"INSERT INTO Departures(id, gate, airportCode, departureDate, status) VALUES(?, ?, ?, "
						+ TimezoneUtils.TO_TIMESTAMP_TZ + ", ?)");
		setParameters(departureStmt, id, gate, airportCode, departureDate,
				status);
		return executeUpdate(departureStmt);
	}

	@SuppressWarnings("unchecked")
	public int addPassenger(String firstName, String lastName,
			String citizenship, String placeOfBirth, Date dateOfBirth) {
		passengerStmt = prepareStatement(
				passengerStmt,
				"INSERT INTO Passengers(id, firstName, lastName, citizenship, placeOfBirth, dateOfBirth) VALUES(PassengerIds.nextval, ?, ?, ?, ?, ?)");
		setParameters(passengerStmt, firstName, lastName, citizenship,
				placeOfBirth, dateOfBirth);
		return executeUpdate(passengerStmt);
	}

	@SuppressWarnings("unchecked")
	public int addFlightInstance(String airlineCode, int flightNumber,
			String flightDate) {
		flightInstanceStmt = prepareStatement(
				flightInstanceStmt,
				"INSERT INTO FlightInstances(id, airlineCode, flightNumber, flightDate) VALUES(FlightInstanceIds.nextval, ?, ?, TO_DATE(?, 'MON DD, YYYY'))");
		setParameters(flightInstanceStmt, airlineCode, flightNumber, flightDate);
		return executeUpdate(flightInstanceStmt);
	}

	@SuppressWarnings("unchecked")
	public int addPassengerToFlight(int passengerId, int flightId,
			String travelClass) {
		flightAttendanceStmt = prepareStatement(
				flightAttendanceStmt,
				"INSERT INTO FlightAttendance(passengerId, flightId, travelClass) VALUES(?, ?, ?)");
		setParameters(flightAttendanceStmt, passengerId, flightId, travelClass);
		return executeUpdate(flightAttendanceStmt);
	}

	@SuppressWarnings("unchecked")
	public int addBaggage(int ownerId, double weight) {
		baggageStmt = prepareStatement(baggageStmt,
				"INSERT INTO Baggage(id, ownerId, weight) VALUES(BaggageIds.nextval, ?, ?)");
		setParameters(baggageStmt, ownerId, weight);
		return executeUpdate(baggageStmt);
	}

	public int addBaggageForFlight(int flightId, int baggageId) {
		flightInventoryStmt = prepareStatement(flightInventoryStmt,
				"INSERT INTO FlightInventory(flightId, baggageId) VALUES(?, ?)");
		setParameters(flightInventoryStmt, flightId, baggageId);
		return executeUpdate(flightInventoryStmt);
	}

	public int addGuardian(int guardianId, int infantId) {
		guardiansStmt = prepareStatement(guardiansStmt,
				"INSERT INTO Guardians(guardianId, infantId) VALUES(?, ?)");
		setParameters(guardiansStmt, guardianId, infantId);
		return executeUpdate(guardiansStmt);
	}

	public int addInfant(int passengerId, int guardianId) {
		infantStmt = prepareStatement(infantStmt,
				"INSERT INTO Infants(id, guardianId) VALUES(?, ?)");
		setParameters(infantStmt, passengerId, guardianId);
		return executeUpdate(infantStmt);
	}

	public int addPassengerClass(String travelClass, String includesMeal) {
		passengerClassStmt = prepareStatement(passengerClassStmt,
				"INSERT INTO PassengerClass(travelClass, includesMeal) VALUES(?, ?)");
		setParameters(passengerClassStmt, travelClass, includesMeal);
		return executeUpdate(passengerClassStmt);
	}
}
