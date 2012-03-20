package ca.drusk.flightmanager.server.database;

import java.sql.PreparedStatement;
import java.sql.Time;

import ca.drusk.flightmanager.client.data.Relation;
import ca.drusk.flightmanager.client.table_data.Baggage;
import ca.drusk.flightmanager.client.table_data.Citizenships;
import ca.drusk.flightmanager.client.table_data.FlightAttendance;
import ca.drusk.flightmanager.client.table_data.Flights;
import ca.drusk.flightmanager.client.table_data.Passengers;

/**
 * Queries the database for specialized information. These queries return
 * specific business data, unlike {@link FullRelationDataQuerier} which is meant
 * to retrieve all data from a table.
 * 
 * @author drusk
 * 
 */
public class FlightDataQuerier extends DatabaseAccessor {

	private PreparedStatement operatedFlightsStmt = null;

	private PreparedStatement inOutFlightsStmt = null;

	private PreparedStatement passengersForFlightStmt = null;

	private PreparedStatement baggageStmt = null;

	private PreparedStatement connectingFlightsStmt = null;

	public Relation getOperatedFlights(String airlineCode) {
		operatedFlightsStmt = prepareStatement(operatedFlightsStmt,
				"SELECT flightNumber, source, destination FROM Flights WHERE airlineCode=?");
		setParameters(operatedFlightsStmt, airlineCode);
		return executeQuery(operatedFlightsStmt, new String[] {
				Flights.FLIGHT_NUMBER, Flights.SOURCE, Flights.DESTINATION });
	}

	public Relation getIncomingAndOutgoingFlights(String airportCode) {
		inOutFlightsStmt = prepareStatement(
				inOutFlightsStmt,
				"SELECT flightNumber, source, destination FROM Flights WHERE source=? OR destination=?");
		setParameters(inOutFlightsStmt, airportCode);
		return executeQuery(inOutFlightsStmt, new String[] {
				Flights.FLIGHT_NUMBER, Flights.SOURCE, Flights.DESTINATION });
	}

	public Relation getPassengers(String flightInstanceId) {
		passengersForFlightStmt = prepareStatement(
				passengersForFlightStmt,
				"SELECT Passengers.id, travelClass, firstName, lastName, citizenship, placeOfBirth, dateOfBirth, specialNeeds FROM FlightAttendance JOIN Passengers ON FlightAttendance.passengerId=Passengers.id WHERE flightId=?");
		setParameters(passengersForFlightStmt, flightInstanceId);
		return executeQuery(passengersForFlightStmt, new String[] {
				Passengers.ID, FlightAttendance.TRAVEL_CLASS,
				Passengers.FIRST_NAME, Passengers.LAST_NAME,
				Citizenships.CITIZENSHIP, Passengers.PLACE_OF_BIRTH,
				Passengers.DATE_OF_BIRTH, Passengers.SPECIAL_NEEDS });
	}

	public Relation getBaggage(String passengerId, String flightId) {
		baggageStmt = prepareStatement(
				baggageStmt,
				"SELECT Baggage.id, weight FROM FlightInventory JOIN Baggage ON Baggage.id=FlightInventory.baggageId WHERE passengerId=? AND flightId=?");
		setParameters(baggageStmt, passengerId, flightId);
		return executeQuery(baggageStmt, new String[] { Baggage.ID,
				Baggage.WEIGHT });
	}

	public Relation getConnectingFlights(Time maxWaitTime) {
		connectingFlightsStmt = prepareStatement(
				connectingFlightsStmt,
				"SELECT F1.flightNumber AS f1, F2.flightNumber AS f2 FROM Flights JOIN IncomingFlights USING(flightNumber) F1, Flights JOIN OutgoingFlights USING(flightNumber) F2 WHERE F1.destination=F2.source AND F2.plannedDepartureTime>F1.plannedArrivalTime AND F2.plannedDepartureTime-F1.plannedArrivalTime < ?");
		setParameters(connectingFlightsStmt, maxWaitTime);
		return executeQuery(connectingFlightsStmt, new String[] { "f1", "f2" });
	}
}
