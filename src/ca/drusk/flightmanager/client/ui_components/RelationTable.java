package ca.drusk.flightmanager.client.ui_components;

import java.util.List;

import ca.drusk.flightmanager.shared.Relation;
import ca.drusk.flightmanager.shared.Row;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;

/**
 * Displays a {@link Relation} in a GWT cell table widget.
 * 
 * @author drusk
 * 
 */
public class RelationTable {

	private Relation relation;

	private CellTable<Row> table = new CellTable<Row>();

	public RelationTable(Relation relation) {
		this.relation = relation;
		initTable();
		initDataProvider();
	}

	private void initDataProvider() {
		ListDataProvider<Row> dataProvider = new ListDataProvider<Row>();

		// connect table to the data provider
		dataProvider.addDataDisplay(table);

		// Add data to the data provider, which automatically pushes it to the
		// widget
		List<Row> dataRows = dataProvider.getList();
		for (Row row : relation.getRows()) {
			dataRows.add(row);
		}

		// TODO column sort events?
	}

	private void initTable() {
		for (final String columnName : relation.getColumnNames()) {
			TextColumn<Row> column = new TextColumn<Row>() {
				@Override
				public String getValue(Row row) {
					return row.getValue(columnName);
				}
			};
			column.setSortable(true);
			table.addColumn(column);
		}
	}

	/**
	 * 
	 * @return the table as a widget which can be added to the UI.
	 */
	public Widget asWidget() {
		return table;
	}

}
