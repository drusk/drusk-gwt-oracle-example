package ca.drusk.flightmanager.client.table_data;

/**
 * Constants for the fields in the Passengers table.
 * 
 * @author drusk
 * 
 */
public class PassengersFields implements TableFields {

	public static final String ID = "id";

	public static final String FIRST_NAME = "firstName";

	public static final String LAST_NAME = "lastName";

	public static final String PLACE_OF_BIRTH = "placeOfBirth";

	public static final String DATE_OF_BIRTH = "dateOfBirth";

	public static final String INFANT = "Infant";

	public static final String DIETARY_RESTRICTIONS = "dietaryRestrictions";

	public static final String MEDICAL_CONSIDERATIONS = "medicalConsiderations";

	public static final String IS_AIRLINE_EMPLOYEE = "isAirlineEmployee";

	public static final String IS_DOCTOR = "isDoctor";

	public static final String IS_INFANT = "isInfant";

	@Override
	public String[] getPrimaryKeyAttributes() {
		return new String[] { ID };
	}

	@Override
	public String[] getFields() {
		return new String[] { ID, FIRST_NAME, LAST_NAME,
				CitizenshipsFields.CITIZENSHIP, PLACE_OF_BIRTH, DATE_OF_BIRTH,
				DIETARY_RESTRICTIONS, MEDICAL_CONSIDERATIONS,
				IS_AIRLINE_EMPLOYEE, IS_DOCTOR, IS_INFANT };
	}

	@Override
	public String[] getEntryFields() {
		return new String[] { FIRST_NAME, LAST_NAME, CitizenshipsFields.CITIZENSHIP,
				PLACE_OF_BIRTH, DATE_OF_BIRTH };
	}

	@Override
	public String[] getDisplayFields() {
		return getFields();
	}

}
