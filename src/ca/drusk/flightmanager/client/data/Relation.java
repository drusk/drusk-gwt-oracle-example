package ca.drusk.flightmanager.client.data;

import java.util.List;


/**
 * A database relation, i.e. a list of rows (may be ordered). This could be an
 * entire table or just the results of a query.
 * 
 * @author drusk
 * 
 */
public interface Relation {

	/**
	 * @return column names in the order returned by the database
	 */
	List<String> getColumnNames();

	/**
	 * 
	 * @return all rows in the relation, in the order returned by the database
	 */
	List<Row> getRows();

}
