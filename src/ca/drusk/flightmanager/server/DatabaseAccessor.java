package ca.drusk.flightmanager.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ca.drusk.flightmanager.client.table_field_constants.AirlinesFields;
import ca.drusk.flightmanager.shared.DefaultRelation;
import ca.drusk.flightmanager.shared.DefaultRow;
import ca.drusk.flightmanager.shared.Relation;
import ca.drusk.flightmanager.shared.Row;

/**
 * Base class for classes which interact with the database.
 * 
 * Provides commonly used functionality for setting up and executing SQL
 * queries.
 * 
 * @author drusk
 * 
 */
public abstract class DatabaseAccessor {

	protected Connection conn = DatabaseConnectionManager.getInstance()
			.getConnection();

	/**
	 * 
	 * @param stmt
	 *            the <code>PreparedStatement</code> which will call
	 *            executeUpdate()
	 * @return the number of affected tuples, or -1 in case of error
	 */
	protected int executeUpdate(PreparedStatement stmt) {
		int insertions = -1;
		try {
			insertions = stmt.executeUpdate();
		} catch (SQLException sqlExcept) {
			System.err.println("SQLException: " + sqlExcept.getMessage());
		}
		return insertions;
	}

	protected Relation executeQuery(PreparedStatement stmt) {
		// TODO DBFields interface -> getFields
		// pass in DBFields
		DefaultRelation relation = new DefaultRelation(
				AirlinesFields.getFields());
		try {
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				Row row = new DefaultRow();
				// TODO set values
				relation.add(row);
			}
			resultSet.close();
		} catch (SQLException sqlExcept) {
			System.err.println("SQLException: " + sqlExcept.getMessage());
		}
		return relation;
	}

	/**
	 * 
	 * @param stmt
	 *            the <code>PreparedStatement</code> whose parameters will be
	 *            set
	 * @param params
	 *            SQL statement parameters
	 */
	protected void setStringParameters(PreparedStatement stmt, String... params) {
		try {
			for (int i = 0; i < params.length; i++) {
				stmt.setString(i + 1, params[i]);
			}
		} catch (SQLException sqlExcept) {
			System.err.println("SQLException: " + sqlExcept.getMessage());
		}
	}

	/**
	 * Checks if a PreparedStatement has been initialized. If it has, the
	 * parameters are cleared. If it hasn't, it is created using the specified
	 * sql
	 * 
	 * @param stmt
	 *            the <code>PreparedStatement</code> that is being prepared
	 * @param sql
	 *            the sql to be set in the <code>PreparedStatement</code>
	 */
	protected PreparedStatement prepareStatement(PreparedStatement stmt,
			String sql) {
		try {
			if (stmt == null) {
				stmt = conn.prepareStatement(sql);
			} else {
				stmt.clearParameters();
			}
		} catch (SQLException sqlExcept) {
			System.err.println("SQLException: " + sqlExcept.getMessage());
		}
		return stmt;
	}

}
