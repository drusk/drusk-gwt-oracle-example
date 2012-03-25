package ca.drusk.flightmanager.server.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Queries for specific values.
 * 
 * @author drusk
 * 
 */
public class DataValueQuerier extends DatabaseAccessor {

	private PreparedStatement airportUtcStmt = null;

	public int getUtcOffset(String airportCode) {
		airportUtcStmt = prepareStatement(airportUtcStmt,
				"SELECT utcOffset FROM Airports WHERE airportCode=?");
		setParameters(airportUtcStmt, airportCode);

		int utcOffset = Integer.MIN_VALUE;
		try {
			ResultSet results = airportUtcStmt.executeQuery();
			/*
			 * Only one value will be returned.
			 */
			results.next();
			utcOffset = results.getInt(1);

			results.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utcOffset;
	}

}
