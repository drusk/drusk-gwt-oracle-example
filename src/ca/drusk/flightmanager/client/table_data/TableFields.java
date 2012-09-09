package ca.drusk.flightmanager.client.table_data;

/**
 * Classes which store the constants for a database table's fields should
 * implement this interface so that the field names may be retrieved. Using
 * these constants means that if field names in the database are changed, they
 * only have to be updated in these classes instead of throughout all the code.
 * 
 * @author drusk
 * 
 */
public interface TableFields {

	/**
	 * 
	 * @return the names of fields which are primary keys.
	 */
	String[] getPrimaryKeyAttributes();

	/**
	 * 
	 * @return all fields in the tables.
	 */
	String[] getFields();

	/**
	 * 
	 * @return the names of fields which the user can directly enter data for.
	 */
	String[] getEntryFields();

	/**
	 * 
	 * @return the names of fields which should be displayed to the user.
	 */
	String[] getDisplayFields();

}
