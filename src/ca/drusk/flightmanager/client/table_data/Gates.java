package ca.drusk.flightmanager.client.table_data;

/**
 * Constants for the fields in the Gates table.
 * 
 * @author drusk
 * 
 */
public class Gates implements TableFields {

	public static final String GATE = "Gate";

	@Override
	public String[] getPrimaryKeys() {
		// weak entity set
		return new String[] { GATE, Locations.AIRPORT_CODE };
	}

	@Override
	public String[] getFields() {
		return new String[] { GATE, Locations.AIRPORT_CODE };
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
