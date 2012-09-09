package ca.drusk.flightmanager.server.database;

import java.sql.PreparedStatement;

import ca.drusk.flightmanager.client.data.Relation;
import ca.drusk.flightmanager.client.table_data.BaggageFields;
import ca.drusk.flightmanager.client.table_data.CitizenshipsFields;
import ca.drusk.flightmanager.client.table_data.FlightAttendanceFields;
import ca.drusk.flightmanager.client.table_data.FlightsFields;
import ca.drusk.flightmanager.client.table_data.PassengersFields;

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

	private PreparedStatement frequentPassengerStmt = null;

	private PreparedStatement passengersInTransitStmt = null;

	private PreparedStatement delaysStmt = null;

	public Relation getOperatedFlights(String airlineCode) {
		operatedFlightsStmt = prepareStatement(operatedFlightsStmt,
				"SELECT flightNumber, source, destination FROM Flights WHERE airlineCode=?");
		setParameters(operatedFlightsStmt, airlineCode);
		return executeQuery(operatedFlightsStmt, new String[] {
				FlightsFields.FLIGHT_NUMBER, FlightsFields.SOURCE, FlightsFields.DESTINATION });
	}

	public Relation getIncomingAndOutgoingFlights(String airportCode) {
		inOutFlightsStmt = prepareStatement(
				inOutFlightsStmt,
				"SELECT airlineCode, flightNumber, source, destination FROM Flights WHERE source=? OR destination=?");
		setParameters(inOutFlightsStmt, airportCode, airportCode);
		return executeQuery(inOutFlightsStmt, new String[] { "airlineCode",
				FlightsFields.FLIGHT_NUMBER, FlightsFields.SOURCE, FlightsFields.DESTINATION });
	}

	public Relation getDeparturesAround(String airportCode, String targetTime,
			int bufferMinutes) {
		/*
		 * XXX having trouble setting interval value with prepared statement, so
		 * using regular statement.
		 */
		String sql = "SELECT flightNumber, TO_CHAR(plannedDepartureTime, 'HH24:MI') AS scheduledDeparture, departureDate, status FROM Flights JOIN FlightInstances USING(flightNumber) JOIN Departures USING(id) WHERE airportCode='"
				+ airportCode
				+ "' AND "
				+ "TO_TIMESTAMP_TZ('"
				+ targetTime
				+ "', 'MON DD, YYYY HH24:MI TZH:TZM')"
				+ " BETWEEN (plannedDepartureTime - interval '"
				+ bufferMinutes
				+ "' minute) AND "
				+ "(plannedDepartureTime + interval '"
				+ bufferMinutes + "' minute)";
		System.out.println(sql);
		return executeQuery(sql);
	}

	public Relation getArrivalsAround(String airportCode, String targetTime,
			int bufferMinutes) {
		/*
		 * XXX having trouble setting interval value with prepared statement, so
		 * using regular statement.
		 */
		String sql = "SELECT flightNumber, TO_CHAR(plannedArrivalTime, 'HH24:MI') AS scheduledArrival, arrivalDate, status FROM Flights JOIN FlightInstances USING(flightNumber) JOIN Arrivals USING(id) WHERE airportCode='"
				+ airportCode
				+ "' AND "
				+ "TO_TIMESTAMP_TZ('"
				+ targetTime
				+ "', 'MON DD, YYYY HH24:MI TZH:TZM')"
				+ " BETWEEN (plannedArrivalTime - interval '"
				+ bufferMinutes
				+ "' minute) AND "
				+ "(plannedArrivalTime + interval '"
				+ bufferMinutes + "' minute)";
		return executeQuery(sql);
	}

	public Relation getPassengers(String flightInstanceId) {
		passengersForFlightStmt = prepareStatement(
				passengersForFlightStmt,
				"SELECT Passengers.id, travelClass, firstName, lastName, citizenship, placeOfBirth, TO_CHAR(dateOfBirth, 'MON DD, YYYY') AS dateOfBirth, dietaryRestrictions, medicalConsiderations, isAirlineEmployee, isDoctor, isInfant FROM FlightAttendance JOIN Passengers ON FlightAttendance.passengerId=Passengers.id WHERE flightId=?");
		setParameters(passengersForFlightStmt, flightInstanceId);
		return executeQuery(passengersForFlightStmt, new String[] {
				PassengersFields.ID, FlightAttendanceFields.TRAVEL_CLASS,
				PassengersFields.FIRST_NAME, PassengersFields.LAST_NAME,
				CitizenshipsFields.CITIZENSHIP, PassengersFields.PLACE_OF_BIRTH,
				PassengersFields.DATE_OF_BIRTH, PassengersFields.DIETARY_RESTRICTIONS,
				PassengersFields.MEDICAL_CONSIDERATIONS,
				PassengersFields.IS_AIRLINE_EMPLOYEE, PassengersFields.IS_DOCTOR,
				PassengersFields.IS_INFANT });
	}

	public Relation getBaggage(String passengerId, String flightId) {
		baggageStmt = prepareStatement(
				baggageStmt,
				"SELECT Baggage.id, ownerId, weight FROM FlightInventory JOIN Baggage ON Baggage.id=FlightInventory.baggageId WHERE ownerId=? AND flightId=?");
		setParameters(baggageStmt, passengerId, flightId);
		return executeQuery(baggageStmt, new String[] { BaggageFields.ID, "ownerId",
				BaggageFields.WEIGHT });
	}

	public Relation getConnectingFlights(String airportCode,
			int maxWaitTimeMinutes) {
		/*
		 * XXX having trouble setting interval value with prepared statement, so
		 * using regular statement.
		 */
		String sql = "SELECT R1.airlineCode AS f1_airlineCode, R1.flightNumber AS f1_flightNumber, R2.airlineCode AS f2_airlineCode, R2.flightNumber AS f2_flightNumber FROM Flights R1, Flights R2 WHERE R1.destination=R2.source AND R1.destination='"
				+ airportCode
				+ "' AND R2.plannedDepartureTime>R1.plannedArrivalTime AND R2.plannedDepartureTime<(R1.plannedArrivalTime + INTERVAL '"
				+ maxWaitTimeMinutes + "' MINUTE)";
		return executeQuery(sql);
	}

	public Relation getMostFrequentPassengers(int topN) {
		frequentPassengerStmt = prepareStatement(
				frequentPassengerStmt,
				"SELECT * FROM (SELECT passengerId, firstName, lastName, numberOfFlights FROM (SELECT passengerId, COUNT(flightId) AS numberOfFlights FROM FlightAttendance GROUP BY passengerId) R JOIN Passengers ON R.passengerId=Passengers.id ORDER BY numberOfFlights DESC) WHERE ROWNUM <= ?");
		setParameters(frequentPassengerStmt, topN);
		return executeQuery(frequentPassengerStmt,
				FlightAttendanceFields.PASSENGER_ID, PassengersFields.FIRST_NAME,
				PassengersFields.LAST_NAME, "numberOfFlights");
	}

	public Relation getPassengersInTransit() {
		passengersInTransitStmt = prepareStatement(
				passengersInTransitStmt,
				"SELECT Passengers.id, Passengers.firstName, Passengers.lastName FROM (SELECT passengerId FROM FlightAttendance JOIN (SELECT id FROM FlightInstances JOIN Departures USING(id) LEFT OUTER JOIN Arrivals USING(id) WHERE departureDate IS NOT NULL AND arrivalDate IS NULL) R ON FlightAttendance.flightId=R.id) S JOIN Passengers ON Passengers.id=S.passengerId");
		return executeQuery(passengersInTransitStmt, PassengersFields.ID,
				PassengersFields.FIRST_NAME, PassengersFields.LAST_NAME);
	}

	public Relation getMostDelayedAirlines() {
		delaysStmt = prepareStatement(
				delaysStmt,
				"SELECT source, destination, airlineCode, numDelays FROM DelayedFlights R WHERE numDelays=(SELECT MAX(numDelays) FROM DelayedFlights S WHERE R.source=S.source AND R.destination=S.destination)");
		return executeQuery(delaysStmt, FlightsFields.SOURCE, FlightsFields.DESTINATION,
				FlightsFields.AIRLINE_CODE, "numDelays");
	}
}
