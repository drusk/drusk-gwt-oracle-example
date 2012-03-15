package ca.drusk.flightmanager.client.table_data;

/**
 * Constants for the fields in the Airlines table
 * 
 * @author drusk
 * 
 */
public final class Airlines implements TableFields {

	public static final String WEBSITE = "Website";

	public static final String CODE = "Code";

	public static final String NAME = "Name";

	@Override
	public String[] getFields() {
		return new String[] { NAME, CODE, WEBSITE };
	}

	@Override
	public String getPrimaryKey() {
		return CODE;
	}
}
