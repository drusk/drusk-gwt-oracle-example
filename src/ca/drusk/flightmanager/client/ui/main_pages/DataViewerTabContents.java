package ca.drusk.flightmanager.client.ui.main_pages;

import ca.drusk.flightmanager.client.services.DataQueryServiceAsync;
import ca.drusk.flightmanager.client.table_data.TableNames;
import ca.drusk.flightmanager.client.ui.main_pages.data_display.AirlineResultsDisplay;
import ca.drusk.flightmanager.client.ui.main_pages.data_display.PlaneModelsDisplay;

import com.google.gwt.user.client.ui.DeckLayoutPanel;

/**
 * Allows selection of database table to view contents of.
 * 
 * @author drusk
 * 
 */
public class DataViewerTabContents extends AbstractTabContents {

	private final DataQueryServiceAsync dataQueryService;

	public DataViewerTabContents(DataQueryServiceAsync dataQueryService) {
		super();
		this.dataQueryService = dataQueryService;
		tabContents = initTabContents();
		dockPanel.add(tabContents);
	}

	@Override
	protected String[] getTablesToShow() {
		return TableNames.getAll();
	}

	@Override
	protected DeckLayoutPanel initTabContents() {
		DeckLayoutPanel tabContents = new DeckLayoutPanel();

		AirlineResultsDisplay airlineDisplay = new AirlineResultsDisplay(
				dataQueryService);
		tableSelector.registerSwitchHandler(TableNames.AIRLINES,
				airlineDisplay, tabContents);
		tabContents.add(airlineDisplay);

		PlaneModelsDisplay planeModelDisplay = new PlaneModelsDisplay(
				dataQueryService);
		tableSelector.registerSwitchHandler(TableNames.PLANE_MODELS,
				planeModelDisplay, tabContents);
		tabContents.add(planeModelDisplay);

		tabContents.showWidget(0);
		return tabContents;
	}

}
