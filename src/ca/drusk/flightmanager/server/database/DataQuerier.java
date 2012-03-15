package ca.drusk.flightmanager.server.database;

import java.sql.PreparedStatement;
import java.util.List;

import ca.drusk.flightmanager.client.data.Relation;
import ca.drusk.flightmanager.client.data.Row;
import ca.drusk.flightmanager.client.table_data.Airlines;
import ca.drusk.flightmanager.client.table_data.Citizenships;
import ca.drusk.flightmanager.client.table_data.Locations;
import ca.drusk.flightmanager.client.table_data.PlaneModels;

/**
 * Returns data from the database after running queries.
 * 
 * @author drusk
 * 
 */
public class DataQuerier extends DatabaseAccessor {

	private PreparedStatement airlineStmt = null;

	private PreparedStatement citizenshipStmt = null;

	private PreparedStatement planeModelStmt = null;

	private PreparedStatement locationsStmt = null;

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

	public static void main(String[] args) {
		DataQuerier querier = new DataQuerier();
		Relation result = querier.getAirlineFullRelation();
		List<String> columnNames = result.getColumnNames();
		for (Row row : result.getRows()) {
			System.out.println("=============");
			for (String columnName : columnNames) {
				System.out
						.println(columnName + ": " + row.getValue(columnName));
			}
		}
	}

	public Relation getLocationsFullRelation() {
		locationsStmt = prepareStatement(locationsStmt,
				"SELECT airportCode, city, country, utcOffset FROM Locations");
		return executeQuery(locationsStmt, new Locations().getFields());
	}

}
