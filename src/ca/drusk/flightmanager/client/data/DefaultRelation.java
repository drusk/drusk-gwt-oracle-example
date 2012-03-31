package ca.drusk.flightmanager.client.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Default implementation of {@link Relation}.
 * 
 * @author drusk
 * 
 */
public class DefaultRelation implements Relation, Serializable {

	private List<String> columnNames;

	private List<Row> rows = new ArrayList<Row>();

	// needed for serialization
	private DefaultRelation() {
	}

	public DefaultRelation(String... columnNames) {
		this.columnNames = Arrays.asList(columnNames);
	}

	public DefaultRelation(List<String> columnNames) {
		this.columnNames = columnNames;
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
