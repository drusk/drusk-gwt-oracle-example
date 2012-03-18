package ca.drusk.flightmanager.client.table_data;

/**
 * Classes which store the constants for a database table's fields should
 * implement this interface so that the field names may be retrieved.
 * 
 * @author drusk
 * 
 */
public interface TableFields {

	String[] getPrimaryKeys();

	String[] getFields();

	String[] getEntryFields();

	String[] getDisplayFields();

}
