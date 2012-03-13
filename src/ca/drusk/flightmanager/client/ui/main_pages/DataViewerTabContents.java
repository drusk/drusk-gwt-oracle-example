package ca.drusk.flightmanager.client.ui.main_pages;

import ca.drusk.flightmanager.client.services.DataQueryServiceAsync;
import ca.drusk.flightmanager.client.ui.main_pages.data_display.AirlineResultsDisplay;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DeckLayoutPanel;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Allows selection of database table to view contents of.
 * 
 * @author drusk
 * 
 */
public class DataViewerTabContents implements IsWidget {

	private DockLayoutPanel dockPanel = new DockLayoutPanel(Unit.PX);

	private double tableSelectorWidth = 100;

	private final DataQueryServiceAsync dataQueryService;

	private DeckLayoutPanel resultsDeckPanel;

	private VerticalPanel contents = new VerticalPanel();

	public DataViewerTabContents(DataQueryServiceAsync dataQueryService) {
		this.dataQueryService = dataQueryService;
		initTableSelector();
		initResultsDeckPanel();
		contents.setSpacing(15);
	}

	private void initTableSelector() {
		VerticalPanel buttonHolder = new VerticalPanel();
		Button airlinesButton = new Button("Airlines");
		buttonHolder.add(airlinesButton);
		// TODO onclick handler, show widget on
		buttonHolder.setWidth("100%");
		buttonHolder.setHeight("100%");
		buttonHolder.setBorderWidth(1);
		dockPanel.addWest(buttonHolder, tableSelectorWidth);
	}

	private void initResultsDeckPanel() {
		resultsDeckPanel = new DeckLayoutPanel();

		resultsDeckPanel.add(new AirlineResultsDisplay(dataQueryService));

		resultsDeckPanel.showWidget(0);
		dockPanel.add(resultsDeckPanel);
	}

	@Override
	public Widget asWidget() {
		return dockPanel;
	}

}
