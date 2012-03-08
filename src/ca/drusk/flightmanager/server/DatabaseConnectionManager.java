package ca.drusk.flightmanager.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Establishes the connection with the database.
 * 
 * @author drusk
 * 
 */
public class DatabaseConnectionManager {

	private static String driverName = "oracle.jdbc.OracleDriver";

	private static String dbURL = "jdbc:oracle:thin:@//localhost:1521/";

	private static String dbName = "xe";

	private static Connection conn = null;

	/**
	 * 
	 * @return a connection to the database
	 */
	public static Connection getConnInstance() {
		if (conn == null) {
			conn = createConnection();
		}
		return conn;
	}

	private static Connection createConnection() {
		try {
			Class.forName(driverName);
			Properties dbProps = new Properties();
			dbProps.put("user", "drusk");
			dbProps.put("password", "tlotr123");
			conn = DriverManager.getConnection(dbURL + dbName, dbProps);
			System.err.println("Connection successful!");
		} catch (Exception except) {
			System.err.println("Could not connect to the database");
			except.printStackTrace();
		}
		return conn;
	}
}
