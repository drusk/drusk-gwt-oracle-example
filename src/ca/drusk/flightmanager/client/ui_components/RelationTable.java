package ca.drusk.flightmanager.client.ui_components;

import java.util.List;

import ca.drusk.flightmanager.client.data.Relation;
import ca.drusk.flightmanager.client.data.Row;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
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

	private SimplePager pager;

	public RelationTable(Relation relation) {
		assert relation != null;
		this.relation = relation;
		initTable();
		initDataProvider();
		initPager();
	}

	private void initPager() {
		pager = new SimplePager();
		pager.setDisplay(table);
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
			table.addColumn(column, columnName);
		}
	}

	/**
	 * 
	 * @return the table as a widget which can be added to the UI.
	 */
	public Widget asWidget() {
		VerticalPanel vPanel = new VerticalPanel();
		vPanel.add(table);
		vPanel.add(pager);
		vPanel.setCellHorizontalAlignment(pager,
				HasHorizontalAlignment.ALIGN_CENTER);
		return vPanel;
	}

}
