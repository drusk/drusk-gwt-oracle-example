package ca.drusk.flightmanager.client.ui.main_pages.data_display;

import ca.drusk.flightmanager.client.services.DataQueryServiceAsync;

/**
 * Display for data from the FlightInventory table.
 * 
 * @author drusk
 * 
 */
public class FlightInventoryDisplay extends AbstractDataDisplay {

	public FlightInventoryDisplay(DataQueryServiceAsync dataQueryService) {
		super(dataQueryService);
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		dataQueryService.getFlightInventory(new TableGeneratingCallback());
	}

}
