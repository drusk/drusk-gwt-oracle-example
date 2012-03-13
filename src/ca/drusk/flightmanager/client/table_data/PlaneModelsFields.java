package ca.drusk.flightmanager.client.table_data;

/**
 * Constants for the fields in the PlaneModels table
 * 
 * @author drusk
 * 
 */
public final class PlaneModelsFields implements TableFields {

	public static final String CODE = "Code";

	public static final String CAPACITY = "Capacity";

	@Override
	public String getPrimaryKey() {
		return CODE;
	}

	@Override
	public String[] getFields() {
		return new String[] { CODE, CAPACITY };
	}

}
