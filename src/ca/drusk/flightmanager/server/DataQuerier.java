package ca.drusk.flightmanager.server;

import java.sql.PreparedStatement;

import ca.drusk.flightmanager.shared.Relation;

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
		return executeQuery(airlineStmt);
	}

}
