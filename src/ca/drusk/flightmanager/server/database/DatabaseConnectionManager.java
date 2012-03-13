package ca.drusk.flightmanager.server.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.Stack;

/**
 * Establishes the connection with the database.
 * 
 * @author drusk
 * 
 */
public class DatabaseConnectionManager {

	// TODO: read from properties file
	private static final String PASSWORD = "tlotr123";

	private static final String USER_NAME = "drusk";

	private static final String PORT = "1521";

	private static final String MACHINE_NAME = "localhost";

	private static String DRIVER_NAME = "oracle.jdbc.OracleDriver";

	private static String DB_NAME = "xe";

	private Stack<Connection> connections = new Stack<Connection>();

	private static DatabaseConnectionManager instance = null;

	public static DatabaseConnectionManager getInstance() {
		if (instance == null) {
			instance = new DatabaseConnectionManager();
		}
		return instance;
	}

	/**
	 * 
	 * @return a connection to the database
	 */
	public Connection getConnection() {
		if (!connections.isEmpty()) {
			return connections.pop();
		} else {
			return createConnection();
		}
	}

	/**
	 * 
	 * @return a newly created connection
	 */
	private static Connection createConnection() {
		Connection conn = null;
		try {
			Class.forName(DRIVER_NAME);
			Properties dbProps = new Properties();
			dbProps.put("user", USER_NAME);
			dbProps.put("password", PASSWORD);
			conn = DriverManager.getConnection("jdbc:oracle:thin:@//"
					+ MACHINE_NAME + ":" + PORT + "/" + DB_NAME, dbProps);
			System.err.println("Connection successful!");
		} catch (Exception except) {
			System.err.println("Could not connect to the database");
			except.printStackTrace();
		}
		return conn;
	}

	public void returnConnection(Connection conn) {
		if (conn != null) {
			connections.push(conn);
		}
	}
}
