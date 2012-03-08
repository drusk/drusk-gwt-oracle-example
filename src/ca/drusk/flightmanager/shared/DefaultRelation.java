package ca.drusk.flightmanager.shared;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Default implementation of {@link Relation}.
 * 
 * @author drusk
 * 
 */
public class DefaultRelation implements Relation {

	private List<String> columnNames;

	private List<Row> rows = new ArrayList<Row>();

	public DefaultRelation(String... columnNames) {
		this.columnNames = Arrays.asList(columnNames);
	}

	public void add(Row row) {
		rows.add(row);
	}

	@Override
	public List<String> getColumnNames() {
		return columnNames;
	}

	@Override
	public List<Row> getRows() {
		return rows;
	}

}
