package ca.drusk.flightmanager.client.table_data;

/**
 * Constants for the fields in the PlaneModels table
 * 
 * @author drusk
 * 
 */
public final class PlaneModels implements TableFields {

	public static final String CODE = "Code";

	public static final String CAPACITY = "Capacity";

	@Override
	public String[] getPrimaryKeys() {
		return new String[] { CODE };
	}

	@Override
	public String[] getFields() {
		return new String[] { CODE, CAPACITY };
	}

	@Override
	public String[] getEntryFields() {
		return getFields();
	}

	@Override
	public String[] getDisplayFields() {
		return getFields();
	}

}
