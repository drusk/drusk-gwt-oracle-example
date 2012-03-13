package ca.drusk.flightmanager.server.database;

import java.sql.PreparedStatement;

/**
 * Inserts data into the database.
 * 
 * @author drusk
 * 
 */
public class DataInserter extends DatabaseAccessor {

	private PreparedStatement airlineStmt = null;

	public int addAirline(String name, String code, String website) {
		airlineStmt = prepareStatement(airlineStmt,
				"INSERT INTO Airlines(name, code, website) VALUES (?, ?, ?)");
		setStringParameters(airlineStmt, name, code, website);
		return executeUpdate(airlineStmt);
	}

}
