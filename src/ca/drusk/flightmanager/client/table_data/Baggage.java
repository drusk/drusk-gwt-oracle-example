package ca.drusk.flightmanager.client.table_data;

/**
 * Constants for the fields in the Airports table.
 * 
 * @author drusk
 * 
 */
public class Baggage implements TableFields {

	public static final String ID = "id";

	public static final String WEIGHT = "weight";

	@Override
	public String[] getPrimaryKeyAttributes() {
		return new String[] { ID };
	}

	@Override
	public String[] getFields() {
		return new String[] { ID, WEIGHT };
	}

	@Override
	public String[] getEntryFields() {
		return new String[] { WEIGHT };
	}

	@Override
	public String[] getDisplayFields() {
		return getFields();
	}

}
