package ca.drusk.flightmanager.server.database;

import java.sql.PreparedStatement;

/**
 * Deletes data from the database.
 * 
 * @author drusk
 * 
 */
public class DataDeleter extends DatabaseAccessor {

	private PreparedStatement airlineStmt = null;

	private PreparedStatement citizenshipStmt = null;

	private PreparedStatement planeModelStmt = null;

	private PreparedStatement locationsStmt = null;

	public int removeAirline(String code) {
		airlineStmt = prepareStatement(airlineStmt,
				"DELETE FROM Airlines WHERE code=?");
		setStringParameters(airlineStmt, code);
		return executeUpdate(airlineStmt);
	}

	public int removePlaneModel(String code) {
		planeModelStmt = prepareStatement(planeModelStmt,
				"DELETE FROM PlaneModels WHERE code=?");
		setParameters(planeModelStmt, code);
		return executeUpdate(planeModelStmt);
	}

	public int removeCitizenship(String citizenship) {
		citizenshipStmt = prepareStatement(citizenshipStmt,
				"DELETE FROM Citizenships WHERE citizenship=?");
		setParameters(citizenshipStmt, citizenship);
		return executeUpdate(citizenshipStmt);
	}

	public int removeLocation(String airportCode) {
		locationsStmt = prepareStatement(locationsStmt,
				"DELETE FROM Locations WHERE airportCode=?");
		setParameters(locationsStmt, airportCode);
		return executeUpdate(locationsStmt);
	}
}
