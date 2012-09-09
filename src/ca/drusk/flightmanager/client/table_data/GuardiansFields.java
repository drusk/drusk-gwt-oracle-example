package ca.drusk.flightmanager.client.table_data;

/**
 * Constants for the fields in the Guardians table.
 * 
 * @author drusk
 * 
 */
public class GuardiansFields implements TableFields {

	public static final String GUARDIAN_ID = "guardianId";

	public static final String INFANT_ID = "infantId";

	@Override
	public String[] getPrimaryKeyAttributes() {
		/*
		 * Note: the Guardians table does not actually have a primary key, but
		 * if it did it would be these attributes
		 */
		return new String[] { GUARDIAN_ID, INFANT_ID };
	}

	@Override
	public String[] getFields() {
		return new String[] { GUARDIAN_ID, INFANT_ID };
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
