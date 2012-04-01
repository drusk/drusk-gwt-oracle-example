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

	// private PreparedStatement airportUtcStmt = null;

	private PreparedStatement passengerIdStmt = null;

	private PreparedStatement infantStmt = null;

	@SuppressWarnings("unchecked")
	public int getFlightInstanceId(String airlineCode, int flightNumber,
			String flightDate) {
		PreparedStatement stmt = null;
		stmt = prepareStatement(
				stmt,
				"SELECT id FROM FlightInstances WHERE airlineCode=? AND flightNumber=? AND flightDate="
						+ TimezoneUtils.TO_TIMESTAMP_TZ);
		setParameters(stmt, airlineCode, flightNumber, flightDate);

		int flightInstanceId = -1;
		try {
			ResultSet results = stmt.executeQuery();
			/*
			 * If it exists there will be one result, otherwise none
			 */
			if (results.next()) {
				flightInstanceId = results.getInt(1);
			}

			results.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flightInstanceId;
	}

	public String getUtcOffset(String airportCode) {
		PreparedStatement airportUtcStmt = null;
		airportUtcStmt = prepareStatement(airportUtcStmt,
				"SELECT utcOffset FROM Airports WHERE airportCode=?");
		setParameters(airportUtcStmt, airportCode);

		String utcOffset = null;
		try {
			ResultSet results = airportUtcStmt.executeQuery();
			/*
			 * Only one value will be returned.
			 */
			results.next();
			utcOffset = results.getString(1);

			results.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utcOffset;
	}

	public int getPassengerId(String firstName, String lastName,
			String placeOfBirth, String dateOfBirth) {
		// should be sufficient to specify a single passenger
		passengerIdStmt = prepareStatement(
				passengerIdStmt,
				"SELECT id FROM Passengers WHERE firstName=? AND lastName=? AND placeOfBirth=? AND dateOfBirth="
						+ TimezoneUtils.TO_TIMESTAMP_TZ);
		setParameters(passengerIdStmt, firstName, lastName, placeOfBirth,
				dateOfBirth);

		int passengerId = -1;
		try {
			ResultSet results = passengerIdStmt.executeQuery();
			/*
			 * Only one value will be returned.
			 */
			results.next();
			passengerId = results.getInt(1);

			results.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return passengerId;
	}

	public int isInfant(int passengerId) {
		infantStmt = prepareStatement(infantStmt,
				"SELECT COUNT(id) FROM Infants WHERE id=?");
		setParameters(infantStmt, passengerId);

		int isInfant = -1;
		try {
			ResultSet results = infantStmt.executeQuery();
			/*
			 * Only one value will be returned.
			 */
			results.next();
			isInfant = results.getInt(1);

			results.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isInfant;
	}

}
