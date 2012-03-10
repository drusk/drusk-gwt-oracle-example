package ca.drusk.flightmanager.client.data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Default implementation of {@link Row}.
 * 
 * @author drusk
 * 
 */
public class DefaultRow implements Row, Serializable {

	private Map<String, String> rowValuesByColumn = new HashMap<String, String>();

	// needed for serialization
	public DefaultRow() {
	}

	public void addColumnValue(String column, String value) {
		rowValuesByColumn.put(column, value);
	}

	@Override
	public String getValue(String columnName) {
		assert rowValuesByColumn.containsKey(columnName);
		return rowValuesByColumn.get(columnName);
	}

}
