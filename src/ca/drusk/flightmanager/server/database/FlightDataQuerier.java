package ca.drusk.flightmanager.server.database;

import java.sql.PreparedStatement;
import java.sql.Time;

import ca.drusk.flightmanager.client.data.Relation;
import ca.drusk.flightmanager.client.table_data.Arrivals;
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

	private PreparedStatement arrDepStmt = null;

	private PreparedStatement passengersForFlightStmt = null;

	private PreparedStatement baggageStmt = null;

	private PreparedStatement connectingFlightsStmt = null;

	private PreparedStatement frequentPassengerStmt = null;

	private PreparedStatement passengersInTransitStmt = null;

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
		setParameters(inOutFlightsStmt, airportCode, airportCode);
		return executeQuery(inOutFlightsStmt, new String[] {
				Flights.FLIGHT_NUMBER, Flights.SOURCE, Flights.DESTINATION });
	}

	@SuppressWarnings("unchecked")
	public Relation getArrivalsAndDeparturesAround(Time time, int minutes) {
		arrDepStmt = prepareStatement(
				arrDepStmt,
				"SELECT flightNumber, status FROM ((SELECT flightNumber FROM IncomingFlights WHERE ? < ABS(plannedArrivalTime-?)*1440) UNION (SELECT flightNumber FROM OutgoingFlights WHERE ? < ABS(plannedDepartureTime-?)*1440))");
		setParameters(arrDepStmt, minutes, time, minutes, time);
		return executeQuery(arrDepStmt, Flights.FLIGHT_NUMBER, Arrivals.STATUS);
	}

	public Relation getPassengers(String flightInstanceId) {
		passengersForFlightStmt = prepareStatement(
				passengersForFlightStmt,
				"SELECT Passengers.id, travelClass, firstName, lastName, citizenship, placeOfBirth, TO_CHAR(dateOfBirth, 'MON DD, YYYY') AS dateOfBirth, specialNeeds FROM FlightAttendance JOIN Passengers ON FlightAttendance.passengerId=Passengers.id WHERE flightId=?");
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

	public Relation getConnectingFlights(int maxWaitTimeMinutes) {
		/*
		 * Subtracting dates in Oracle returns the number of days difference as
		 * a float. This can be multiplied by the number of minutes in a day
		 * (1440) to get the difference between the dates in minutes.
		 */
		connectingFlightsStmt = prepareStatement(
				connectingFlightsStmt,
				"SELECT F1.flightNumber AS f1, F2.flightNumber AS f2 FROM (SELECT * FROM Flights JOIN IncomingFlights USING(flightNumber)) F1, (SELECT * FROM Flights JOIN OutgoingFlights USING(flightNumber)) F2 WHERE F1.destination=F2.source AND F2.plannedDepartureTime>F1.plannedArrivalTime AND (F2.plannedDepartureTime-F1.plannedArrivalTime)*1440 < ?");
		setParameters(connectingFlightsStmt, maxWaitTimeMinutes);
		return executeQuery(connectingFlightsStmt, new String[] { "f1", "f2" });
	}

	public Relation getMostFrequentPassengers(int topN) {
		frequentPassengerStmt = prepareStatement(
				frequentPassengerStmt,
				"SELECT * FROM (SELECT passengerId, firstName, lastName, numberOfFlights FROM (SELECT passengerId, COUNT(flightId) AS numberOfFlights FROM FlightAttendance GROUP BY passengerId) R JOIN Passengers ON R.passengerId=Passengers.id ORDER BY numberOfFlights DESC) WHERE ROWNUM <= ?");
		setParameters(frequentPassengerStmt, topN);
		return executeQuery(frequentPassengerStmt,
				FlightAttendance.PASSENGER_ID, Passengers.FIRST_NAME,
				Passengers.LAST_NAME, "numberOfFlights");
	}

	public Relation getPassengersInTransit() {
		passengersInTransitStmt = prepareStatement(
				passengersInTransitStmt,
				"SELECT Passengers.id, Passengers.firstName, Passengers.lastName FROM (SELECT passengerId FROM FlightAttendance JOIN (SELECT id FROM FlightInstances JOIN Departures USING(id) LEFT OUTER JOIN Arrivals USING(id) WHERE departureDate IS NOT NULL AND arrivalDate IS NULL) R ON FlightAttendance.flightId=R.id) S JOIN Passengers ON Passengers.id=S.passengerId");
		return executeQuery(passengersInTransitStmt, Passengers.ID,
				Passengers.FIRST_NAME, Passengers.LAST_NAME);
	}
}
