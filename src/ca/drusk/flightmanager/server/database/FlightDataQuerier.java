package ca.drusk.flightmanager.server.database;

import java.sql.PreparedStatement;

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

	private PreparedStatement depTimeStmt = null;

	private PreparedStatement arrTimeStmt = null;

	private PreparedStatement passengersForFlightStmt = null;

	private PreparedStatement baggageStmt = null;

	private PreparedStatement connectingFlightsStmt = null;

	private PreparedStatement frequentPassengerStmt = null;

	private PreparedStatement passengersInTransitStmt = null;

	private PreparedStatement delaysStmt = null;

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
				"SELECT airlineCode, flightNumber, source, destination FROM Flights WHERE source=? OR destination=?");
		setParameters(inOutFlightsStmt, airportCode, airportCode);
		return executeQuery(inOutFlightsStmt, new String[] { "airlineCode",
				Flights.FLIGHT_NUMBER, Flights.SOURCE, Flights.DESTINATION });
	}

	// @SuppressWarnings("unchecked")
	// public Relation getDeparturesAround(Time targetTime, int bufferMinutes) {
	// /*
	// * Subtracting dates in Oracle returns the number of days difference as
	// * a float. This can be multiplied by the number of minutes in a day
	// * (1440) to get the difference between the dates in minutes.
	// */
	// depTimeStmt = prepareStatement(
	// depTimeStmt,
	// "SELECT flightNumber, TO_CHAR(plannedDepartureTime, 'HH:MI') AS scheduledDeparture, departureDate, status FROM OutgoingFlights JOIN FlightInstances USING(flightNumber) JOIN Departures USING(id) WHERE ? < ABS(plannedDepartureTime-?)*1440");
	// setParameters(depTimeStmt, bufferMinutes, targetTime);
	// return executeQuery(depTimeStmt, Flights.FLIGHT_NUMBER,
	// "scheduledDeparture", Departures.DEPARTURE_DATE,
	// Departures.STATUS);
	// }

	@SuppressWarnings("unchecked")
	public Relation getDeparturesAround(String airportCode, String targetTime,
			int bufferMinutes) {
		/*
		 * XXX having trouble setting interval value with prepared statement
		 */
		System.out.println("Target time " + targetTime);
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
		// depTimeStmt = prepareStatement(depTimeStmt, sql);
		// setParameters(depTimeStmt, airportCode, targetTime, bufferMinutes,
		// bufferMinutes);
		// return executeQuery(depTimeStmt, Flights.FLIGHT_NUMBER,
		// "scheduledDeparture", Departures.DEPARTURE_DATE,
		// Departures.STATUS);
	}

	@SuppressWarnings("unchecked")
	public Relation getArrivalsAround(String airportCode, String targetTime,
			int bufferMinutes) {
		/*
		 * XXX having trouble setting interval value with prepared statement
		 */
		System.out.println("Target time " + targetTime);
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
		System.out.println(sql);
		return executeQuery(sql);
		// arrTimeStmt = prepareStatement(arrTimeStmt, sql);
		// setParameters(arrTimeStmt, airportCode, targetTime, bufferMinutes,
		// bufferMinutes);
		// return executeQuery(arrTimeStmt, Flights.FLIGHT_NUMBER,
		// "scheduledArrival", Arrivals.ARRIVAL_DATE, Arrivals.STATUS);
	}

	public Relation getPassengers(String flightInstanceId) {
		passengersForFlightStmt = prepareStatement(
				passengersForFlightStmt,
				"SELECT Passengers.id, travelClass, firstName, lastName, citizenship, placeOfBirth, TO_CHAR(dateOfBirth, 'MON DD, YYYY') AS dateOfBirth, dietaryRestrictions, medicalConsiderations, isAirlineEmployee, isDoctor, isInfant FROM FlightAttendance JOIN Passengers ON FlightAttendance.passengerId=Passengers.id WHERE flightId=?");
		setParameters(passengersForFlightStmt, flightInstanceId);
		return executeQuery(passengersForFlightStmt, new String[] {
				Passengers.ID, FlightAttendance.TRAVEL_CLASS,
				Passengers.FIRST_NAME, Passengers.LAST_NAME,
				Citizenships.CITIZENSHIP, Passengers.PLACE_OF_BIRTH,
				Passengers.DATE_OF_BIRTH, Passengers.DIETARY_RESTRICTIONS,
				Passengers.MEDICAL_CONSIDERATIONS,
				Passengers.IS_AIRLINE_EMPLOYEE, Passengers.IS_DOCTOR,
				Passengers.IS_INFANT });
	}

	public Relation getBaggage(String passengerId, String flightId) {
		baggageStmt = prepareStatement(
				baggageStmt,
				"SELECT Baggage.id, ownerId, weight FROM FlightInventory JOIN Baggage ON Baggage.id=FlightInventory.baggageId WHERE ownerId=? AND flightId=?");
		setParameters(baggageStmt, passengerId, flightId);
		return executeQuery(baggageStmt, new String[] { Baggage.ID, "ownerId",
				Baggage.WEIGHT });
	}

	public Relation getConnectingFlights(String airportCode,
			int maxWaitTimeMinutes) {
		/*
		 * XXX having trouble setting interval value with prepared statement
		 */
		String sql = "SELECT R1.airlineCode AS f1_airlineCode, R1.flightNumber AS f1_flightNumber, R2.airlineCode AS f2_airlineCode, R2.flightNumber AS f2_flightNumber FROM Flights R1, Flights R2 WHERE R1.destination=R2.source AND R1.destination='"
				+ airportCode
				+ "' AND R2.plannedDepartureTime>R1.plannedArrivalTime AND R2.plannedDepartureTime<(R1.plannedArrivalTime + INTERVAL '"
				+ maxWaitTimeMinutes + "' MINUTE)";
		System.out.println(sql);
		return executeQuery(sql);
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

	public Relation getMostDelayedAirlines() {
		delaysStmt = prepareStatement(
				delaysStmt,
				"SELECT source, destination, airlineCode, numDelays FROM DelayedFlights R WHERE numDelays=(SELECT MAX(numDelays) FROM DelayedFlights S WHERE R.source=S.source AND R.destination=S.destination)");
		return executeQuery(delaysStmt, Flights.SOURCE, Flights.DESTINATION,
				Flights.AIRLINE_CODE, "numDelays");
	}
}
