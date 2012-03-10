package ca.drusk.flightmanager.client.table_field_constants;

/**
 * Constants for the fields in the Airlines table
 * 
 * @author drusk
 * 
 */
public class AirlinesFields implements TableFields {

	public static final String WEBSITE = "Website";

	public static final String CODE = "Code";

	public static final String NAME = "Name";

	public String[] getFields() {
		return new String[] { NAME, CODE, WEBSITE };
	}
}
