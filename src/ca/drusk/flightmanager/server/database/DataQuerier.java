package ca.drusk.flightmanager.server.database;

import java.sql.PreparedStatement;
import java.util.List;

import ca.drusk.flightmanager.client.data.Relation;
import ca.drusk.flightmanager.client.data.Row;
import ca.drusk.flightmanager.client.table_data.AirlinesFields;

/**
 * Returns data from the database after running queries.
 * 
 * @author drusk
 * 
 */
public class DataQuerier extends DatabaseAccessor {

	private PreparedStatement airlineStmt = null;

	public Relation getAirlineFullRelation() {
		airlineStmt = prepareStatement(airlineStmt,
				"SELECT name, code, website FROM Airlines");
		return executeQuery(airlineStmt, new AirlinesFields().getFields());
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

}
