package ca.drusk.flightmanager.client.table_data;

/**
 * Constants for the fields in the Airlines table
 * 
 * @author drusk
 * 
 */
public final class AirlinesFields implements TableFields {

	public static final String WEBSITE = "Website";

	public static final String CODE = "Code";

	public static final String NAME = "Name";

	@Override
	public String[] getFields() {
		return new String[] { NAME, CODE, WEBSITE };
	}

	@Override
	public String[] getPrimaryKeyAttributes() {
		return new String[] { CODE };
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
