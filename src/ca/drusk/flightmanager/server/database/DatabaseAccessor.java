package ca.drusk.flightmanager.server.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ca.drusk.flightmanager.client.data.DefaultRelation;
import ca.drusk.flightmanager.client.data.DefaultRow;
import ca.drusk.flightmanager.client.data.Relation;

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
		int modifications = -1;
		try {
			modifications = stmt.executeUpdate();
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
			System.err.println("SQLException: " + sqlExcept.getMessage());
		}
		return modifications;
	}

	/**
	 * 
	 * @param stmt
	 *            the <code>PreparedStatement</code> which will call
	 *            executeQuery()
	 * @param columnNames
	 *            the columns which will be retrieved from the {@link ResultSet}
	 *            generated by the database. These will be the columns of the
	 *            {@link Relation} that gets returned.
	 * @return the relation (set of rows) for the query that has been loaded
	 *         into the prepared statement
	 */
	protected Relation executeQuery(PreparedStatement stmt,
			String... columnNames) {
		DefaultRelation relation = new DefaultRelation(columnNames);
		try {
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				DefaultRow row = new DefaultRow();
				for (String columnName : columnNames) {
					row.addColumnValue(columnName,
							resultSet.getString(columnName));
				}
				relation.add(row);
			}
			resultSet.close();
		} catch (SQLException sqlExcept) {
			System.err.println("SQLException: " + sqlExcept.getMessage());
		}
		return relation;
	}

	protected Relation executeQuery(String sql) {
		DefaultRelation relation = null;
		try {
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(sql);
			List<String> columnNames = new ArrayList<String>();
			ResultSetMetaData metaData = resultSet.getMetaData();
			for (int i = 0; i < metaData.getColumnCount(); i++) {
				columnNames.add(metaData.getColumnLabel(i + 1));
			}

			relation = new DefaultRelation(columnNames);
			while (resultSet.next()) {
				DefaultRow row = new DefaultRow();
				for (int i = 0; i < metaData.getColumnCount(); i++) {
					String columnLabel = metaData.getColumnLabel(i + 1);
					row.addColumnValue(columnLabel, resultSet.getString(i + 1));
				}
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
	 * 
	 * @param stmt
	 *            the <code>PreparedStatement</code> whose parameters will be
	 *            set
	 * @param params
	 *            SQL statement parameters
	 */
	protected <T> void setParameters(PreparedStatement stmt, T... params) {
		try {
			for (int i = 0; i < params.length; i++) {
				stmt.setObject(i + 1, params[i]);
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
