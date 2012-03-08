package ca.drusk.flightmanager.shared;

import java.util.HashMap;
import java.util.Map;


/**
 * Default implementation of {@link Row}.
 * 
 * @author drusk
 * 
 */
public class DefaultRow implements Row {

	private Map<String, String> rowValuesByColumn = new HashMap<String, String>();

	public void addColumnValue(String column, String value) {
		rowValuesByColumn.put(column, value);
	}

	@Override
	public String getValue(String columnName) {
		assert rowValuesByColumn.containsKey(columnName);
		return rowValuesByColumn.get(columnName);
	}

}
