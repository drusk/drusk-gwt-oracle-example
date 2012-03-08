package ca.drusk.flightmanager.shared;


/**
 * A row returned from the database
 * 
 * @author drusk
 * 
 */
public interface Row {

	/**
	 * @return the value in the specified column for this row
	 */
	String getValue(String columnName);

}
