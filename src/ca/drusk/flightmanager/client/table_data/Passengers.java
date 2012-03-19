package ca.drusk.flightmanager.client.table_data;

/**
 * Constants for the fields in the Passengers table.
 * 
 * @author drusk
 * 
 */
public class Passengers implements TableFields {

	public static final String ID = "id";

	public static final String FIRST_NAME = "firstName";

	public static final String LAST_NAME = "lastName";

	public static final String PLACE_OF_BIRTH = "placeOfBirth";

	public static final String DATE_OF_BIRTH = "dateOfBirth";

	public static final String SPECIAL_NEEDS = "specialNeeds";

	public static final String INFANT = "Infant";

	@Override
	public String[] getPrimaryKeyAttributes() {
		return new String[] { ID };
	}

	@Override
	public String[] getFields() {
		return new String[] { ID, FIRST_NAME, LAST_NAME,
				Citizenships.CITIZENSHIP, PLACE_OF_BIRTH, DATE_OF_BIRTH,
				SPECIAL_NEEDS };
	}

	@Override
	public String[] getEntryFields() {
		return new String[] { FIRST_NAME, LAST_NAME, Citizenships.CITIZENSHIP,
				PLACE_OF_BIRTH, DATE_OF_BIRTH, SPECIAL_NEEDS };
	}

	@Override
	public String[] getDisplayFields() {
		return getFields();
	}

}
