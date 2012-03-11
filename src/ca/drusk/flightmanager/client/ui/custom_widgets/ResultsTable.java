package ca.drusk.flightmanager.client.ui.custom_widgets;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.drusk.flightmanager.client.data.Relation;
import ca.drusk.flightmanager.client.data.Row;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;

/**
 * Displays a {@link Relation} in a GWT cell table widget.
 * 
 * @author drusk
 * 
 */
public class ResultsTable implements IsWidget {

	private Relation relation;

	private CellTable<Row> table = new CellTable<Row>();

	private Map<String, TextColumn<Row>> columnsByName = new HashMap<String, TextColumn<Row>>();

	private SimplePager pager;

	private VerticalPanel container = new VerticalPanel();

	public ResultsTable(Relation relation) {
		assert relation != null;
		this.relation = relation;
		initTable();
		initDataProvider();
		initPager();
		initContainingPanel();
	}

	private void initContainingPanel() {
		container = new VerticalPanel();
		container.add(table);
		container.add(pager);
		container.setCellHorizontalAlignment(pager,
				HasHorizontalAlignment.ALIGN_CENTER);
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
		// table
		List<Row> dataRows = dataProvider.getList();
		for (Row row : relation.getRows()) {
			dataRows.add(row);
		}

		// create and add sort handlers
		ListHandler<Row> columnSortHandler = new ListHandler<Row>(dataRows);
		for (final String columnName : relation.getColumnNames()) {
			columnSortHandler.setComparator(columnsByName.get(columnName),
					new Comparator<Row>() {

						@Override
						public int compare(Row row1, Row row2) {
							String row1Value = row1.getValue(columnName);
							String row2Value = row2.getValue(columnName);
							return row1Value.compareTo(row2Value);
						}

					});
		}
		table.addColumnSortHandler(columnSortHandler);
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

			columnsByName.put(columnName, column);
			table.addColumn(column, columnName);
		}
	}

	@Override
	public Widget asWidget() {
		return container;
	}

}
