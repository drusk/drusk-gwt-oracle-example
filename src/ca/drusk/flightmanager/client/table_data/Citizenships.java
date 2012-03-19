package ca.drusk.flightmanager.client.table_data;

/**
 * Constants for the fields in the Citizenships table.
 * 
 * @author drusk
 * 
 */
public final class Citizenships implements TableFields {

	public static final String CITIZENSHIP = "Citizenship";

	@Override
	public String[] getPrimaryKeyAttributes() {
		return new String[] { CITIZENSHIP };
	}

	@Override
	public String[] getFields() {
		return new String[] { CITIZENSHIP };
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
