package ca.drusk.flightmanager.server.database;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Time;
import java.sql.Timestamp;

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

	private PreparedStatement incomingFlightStmt = null;

	private PreparedStatement outgoingFlightStmt = null;

	private PreparedStatement gateStmt = null;

	private PreparedStatement arrivalStmt = null;

	private PreparedStatement departureStmt = null;

	private PreparedStatement passengerStmt = null;

	private PreparedStatement flightInstanceStmt = null;

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
	public int addAirport(String airportCode, String city, String country,
			int utcOffset) {
		airportsStmt = prepareStatement(
				airportsStmt,
				"INSERT INTO Airports(airportCode, city, country, utcOffset) VALUES(?, ?, ?, ?)");
		setParameters(airportsStmt, airportCode, city, country, utcOffset);
		return executeUpdate(airportsStmt);
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

	public int addGate(String gate, String airportCode) {
		gateStmt = prepareStatement(gateStmt,
				"INSERT INTO Gates(gate, airportCode) VALUES(?, ?)");
		setParameters(gateStmt, gate, airportCode);
		return executeUpdate(gateStmt);
	}

	@SuppressWarnings("unchecked")
	public int addArrival(int id, String gate, String airportCode,
			Timestamp arrivalDate, String status) {
		arrivalStmt = prepareStatement(
				arrivalStmt,
				"INSERT INTO Arrivals(id, gate, airportCode, arrivalDate, status) VALUES(?, ?, ?, ?, ?)");
		System.out.println("Arrival date" + arrivalDate);
		setParameters(arrivalStmt, id, gate, airportCode, arrivalDate, status);
		return executeUpdate(arrivalStmt);
	}

	@SuppressWarnings("unchecked")
	public int addDeparture(int id, String gate, String airportCode,
			Timestamp departureDate, String status) {
		departureStmt = prepareStatement(
				departureStmt,
				"INSERT INTO Departures(id, gate, airportCode, departureDate, status) VALUES(?, ?, ?, ?, ?)");
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

	public int addFlightInstance(int flightNumber) {
		flightInstanceStmt = prepareStatement(
				flightInstanceStmt,
				"INSERT INTO FlightInstances(id, flightNumber) VALUES(FlightInstanceIds.nextval, ?)");
		setParameters(flightInstanceStmt, flightNumber);
		return executeUpdate(flightInstanceStmt);
	}
}
