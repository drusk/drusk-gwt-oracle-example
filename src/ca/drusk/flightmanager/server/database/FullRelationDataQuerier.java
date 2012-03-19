package ca.drusk.flightmanager.server.database;

import java.sql.PreparedStatement;

import ca.drusk.flightmanager.client.data.Relation;
import ca.drusk.flightmanager.client.table_data.Airlines;
import ca.drusk.flightmanager.client.table_data.Airports;
import ca.drusk.flightmanager.client.table_data.AllFlights;
import ca.drusk.flightmanager.client.table_data.Arrivals;
import ca.drusk.flightmanager.client.table_data.Baggage;
import ca.drusk.flightmanager.client.table_data.Citizenships;
import ca.drusk.flightmanager.client.table_data.Departures;
import ca.drusk.flightmanager.client.table_data.FlightAttendance;
import ca.drusk.flightmanager.client.table_data.FlightInstances;
import ca.drusk.flightmanager.client.table_data.FlightInventory;
import ca.drusk.flightmanager.client.table_data.Gates;
import ca.drusk.flightmanager.client.table_data.Guardians;
import ca.drusk.flightmanager.client.table_data.Passengers;
import ca.drusk.flightmanager.client.table_data.PlaneModels;

/**
 * Returns data from the database after running queries.
 * 
 * @author drusk
 * 
 */
public class FullRelationDataQuerier extends DatabaseAccessor {

	private PreparedStatement airlineStmt = null;

	private PreparedStatement citizenshipStmt = null;

	private PreparedStatement planeModelStmt = null;

	private PreparedStatement airportsStmt = null;

	private PreparedStatement flightsStmt = null;

	private PreparedStatement gateStmt = null;

	private PreparedStatement arrivalStmt = null;

	private PreparedStatement departureStmt = null;

	private PreparedStatement passengerStmt = null;

	private PreparedStatement flightInstancesStmt = null;

	private PreparedStatement flightAttendanceStmt = null;

	private PreparedStatement baggageStmt = null;

	private PreparedStatement flightInventoryStmt = null;

	private PreparedStatement guardiansStmt = null;

	public Relation getAirlineFullRelation() {
		airlineStmt = prepareStatement(airlineStmt,
				"SELECT name, code, website FROM Airlines");
		return executeQuery(airlineStmt, new Airlines().getFields());
	}

	public Relation getCitizenshipsFullRelation() {
		citizenshipStmt = prepareStatement(citizenshipStmt,
				"SELECT citizenship FROM Citizenships");
		return executeQuery(citizenshipStmt, new Citizenships().getFields());
	}

	public Relation getPlaneModelsFullRelation() {
		planeModelStmt = prepareStatement(planeModelStmt,
				"SELECT code, capacity FROM PlaneModels");
		return executeQuery(planeModelStmt, new PlaneModels().getFields());
	}

	public Relation getAirportsFullRelation() {
		airportsStmt = prepareStatement(airportsStmt,
				"SELECT airportCode, city, country, utcOffset FROM Airports");
		return executeQuery(airportsStmt, new Airports().getFields());
	}

	public Relation getFlightsIncomingOutgoingFullRelation() {
		flightsStmt = prepareStatement(
				flightsStmt,
				"SELECT flightNumber, source, destination, airlineCode, planeCode, TO_CHAR(plannedDepartureTime, 'HH24:MI') AS plannedDepartureTime, TO_CHAR(plannedArrivalTime, 'HH24:MI') AS plannedArrivalTime FROM Flights JOIN IncomingFlights USING(flightNumber) JOIN OutgoingFlights USING(flightNumber)");
		return executeQuery(flightsStmt, new AllFlights().getFields());
	}

	public Relation getGatesFullRelation() {
		gateStmt = prepareStatement(gateStmt,
				"SELECT gate, airportCode FROM Gates");
		return executeQuery(gateStmt, new Gates().getFields());
	}

	public Relation getArrivalsFullRelation() {
		arrivalStmt = prepareStatement(arrivalStmt,
				"SELECT id, gate, airportCode, arrivalDate, status FROM Arrivals");
		return executeQuery(arrivalStmt, new Arrivals().getFields());
	}

	public Relation getDepartureFullRelation() {
		departureStmt = prepareStatement(departureStmt,
				"SELECT id, gate, airportCode, departureDate, status FROM Departures");
		return executeQuery(departureStmt, new Departures().getFields());
	}

	public Relation getPassengersFullRelation() {
		passengerStmt = prepareStatement(
				passengerStmt,
				"SELECT id, firstName, lastName, citizenship, placeOfBirth, TO_CHAR(dateOfBirth, 'MON DD, YYYY') AS dateOfBirth FROM Passengers");
		return executeQuery(passengerStmt, new Passengers().getFields());
	}

	public Relation getFlightInstances() {
		flightInstancesStmt = prepareStatement(flightInstancesStmt,
				"SELECT id, flightNumber FROM FlightInstances");
		return executeQuery(flightInstancesStmt,
				new FlightInstances().getFields());
	}

	public Relation getFlightAttendanceFullRelation() {
		flightAttendanceStmt = prepareStatement(flightAttendanceStmt,
				"SELECT passengerId, flightId, travelClass FROM FlightAttendance");
		return executeQuery(flightAttendanceStmt,
				new FlightAttendance().getFields());
	}

	public Relation getBaggageFullRelation() {
		baggageStmt = prepareStatement(baggageStmt,
				"SELECT id, weight FROM Baggage");
		return executeQuery(baggageStmt, new Baggage().getFields());
	}

	public Relation getFlightInventoryFullRelation() {
		flightInventoryStmt = prepareStatement(flightInventoryStmt,
				"SELECT passengerId, flightId, baggageId FROM FlightInventory");
		return executeQuery(flightInventoryStmt,
				new FlightInventory().getFields());
	}

	public Relation getGuardiansFullRelation() {
		guardiansStmt = prepareStatement(guardiansStmt,
				"SELECT guardianId, infantId FROM Guardians");
		return executeQuery(guardiansStmt, new Guardians().getFields());
	}
}
