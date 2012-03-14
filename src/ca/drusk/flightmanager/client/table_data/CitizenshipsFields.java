package ca.drusk.flightmanager.client.table_data;

/**
 * Constants for the fields in the Citizenships table.
 * 
 * @author drusk
 * 
 */
public final class CitizenshipsFields implements TableFields {

	public static final String CITIZENSHIP = "Citizenship";

	@Override
	public String getPrimaryKey() {
		return CITIZENSHIP;
	}

	@Override
	public String[] getFields() {
		return new String[] { CITIZENSHIP };
	}

}
