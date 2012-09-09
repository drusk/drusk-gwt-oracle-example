package ca.drusk.flightmanager.server.database;

import java.sql.PreparedStatement;

import ca.drusk.flightmanager.client.data.Relation;
import ca.drusk.flightmanager.client.table_data.AirlinesFields;
import ca.drusk.flightmanager.client.table_data.AirportsFields;
import ca.drusk.flightmanager.client.table_data.AllFlightsFields;
import ca.drusk.flightmanager.client.table_data.ArrivalsFields;
import ca.drusk.flightmanager.client.table_data.BaggageFields;
import ca.drusk.flightmanager.client.table_data.CitizenshipsFields;
import ca.drusk.flightmanager.client.table_data.DeparturesFields;
import ca.drusk.flightmanager.client.table_data.FlightAttendanceFields;
import ca.drusk.flightmanager.client.table_data.FlightInventoryFields;
import ca.drusk.flightmanager.client.table_data.GatesFields;
import ca.drusk.flightmanager.client.table_data.PassengersFields;
import ca.drusk.flightmanager.client.table_data.PlaneModelsFields;

/**
 * Returns data from the database after running queries. These queries are for
 * returning the full relations, ie all rows and columns in a table.
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

	private PreparedStatement passengerClassesStmt = null;

	public Relation getAirlineFullRelation() {
		airlineStmt = prepareStatement(airlineStmt,
				"SELECT name, code, website FROM Airlines");
		return executeQuery(airlineStmt, new AirlinesFields().getFields());
	}

	public Relation getCitizenshipsFullRelation() {
		citizenshipStmt = prepareStatement(citizenshipStmt,
				"SELECT citizenship FROM Citizenships");
		return executeQuery(citizenshipStmt, new CitizenshipsFields().getFields());
	}

	public Relation getPlaneModelsFullRelation() {
		planeModelStmt = prepareStatement(planeModelStmt,
				"SELECT code, name, capacity FROM PlaneModels");
		return executeQuery(planeModelStmt, new PlaneModelsFields().getFields());
	}

	public Relation getAirportsFullRelation() {
		airportsStmt = prepareStatement(airportsStmt,
				"SELECT airportCode, city, country, utcOffset FROM Airports");
		return executeQuery(airportsStmt, new AirportsFields().getFields());
	}

	public Relation getFlightsFullRelation() {
		flightsStmt = prepareStatement(
				flightsStmt,
				"SELECT airlineCode, flightNumber, source, destination, planeCode, TO_CHAR(plannedDepartureTime, 'HH24:MI TZH:TZM') AS plannedDepartureTime, TO_CHAR(plannedArrivalTime, 'HH24:MI TZH:TZM') AS plannedArrivalTime FROM Flights");
		return executeQuery(flightsStmt, new AllFlightsFields().getFields());
	}

	public Relation getGatesFullRelation() {
		gateStmt = prepareStatement(gateStmt,
				"SELECT gate, airportCode FROM Gates");
		return executeQuery(gateStmt, new GatesFields().getFields());
	}

	public Relation getArrivalsFullRelation() {
		arrivalStmt = prepareStatement(arrivalStmt,
				"SELECT id, gate, airportCode, arrivalDate, status FROM Arrivals");
		return executeQuery(arrivalStmt, new ArrivalsFields().getFields());
	}

	public Relation getDepartureFullRelation() {
		departureStmt = prepareStatement(departureStmt,
				"SELECT id, gate, airportCode, departureDate, status FROM Departures");
		return executeQuery(departureStmt, new DeparturesFields().getFields());
	}

	public Relation getPassengersFullRelation() {
		passengerStmt = prepareStatement(
				passengerStmt,
				"SELECT id, firstName, lastName, citizenship, placeOfBirth, TO_CHAR(dateOfBirth, 'MON DD, YYYY') AS dateOfBirth, dietaryRestrictions, medicalConsiderations, isAirlineEmployee, isDoctor, isInfant FROM Passengers");
		return executeQuery(passengerStmt, new PassengersFields().getFields());
	}

	public Relation getFlightInstances() {
		flightInstancesStmt = prepareStatement(flightInstancesStmt,
				"SELECT id, airlineCode, flightNumber, flightDate FROM FlightInstances");
		return executeQuery(flightInstancesStmt, new String[] { "id",
				"airlineCode", "flightNumber", "flightDate" });
	}

	public Relation getFlightAttendanceFullRelation() {
		flightAttendanceStmt = prepareStatement(flightAttendanceStmt,
				"SELECT passengerId, flightId, travelClass FROM FlightAttendance");
		return executeQuery(flightAttendanceStmt,
				new FlightAttendanceFields().getFields());
	}

	public Relation getBaggageFullRelation() {
		baggageStmt = prepareStatement(baggageStmt,
				"SELECT id, ownerId, weight FROM Baggage");
		return executeQuery(baggageStmt, new BaggageFields().getFields());
	}

	public Relation getFlightInventoryFullRelation() {
		flightInventoryStmt = prepareStatement(flightInventoryStmt,
				"SELECT passengerId, flightId, baggageId FROM FlightInventory");
		return executeQuery(flightInventoryStmt,
				new FlightInventoryFields().getFields());
	}

	public Relation getInfantsFullRelation() {
		guardiansStmt = prepareStatement(guardiansStmt,
				"SELECT id AS infantId, guardianId FROM Infants");
		return executeQuery(guardiansStmt, new String[] { "infantId",
				"guardianId" });
	}

	public Relation getPassengerClassesFullRelation() {
		passengerClassesStmt = prepareStatement(passengerClassesStmt,
				"SELECT travelClass, includesMeal FROM PassengerClass");
		return executeQuery(passengerClassesStmt, new String[] { "travelClass",
				"includesMeal" });
	}
}
