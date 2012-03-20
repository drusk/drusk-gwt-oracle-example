package ca.drusk.flightmanager.client.ui.main_pages.data_display;

import ca.drusk.flightmanager.client.services.FullRelationQueryServiceAsync;

/**
 * Display for data from the FlightInventory table.
 * 
 * @author drusk
 * 
 */
public class FlightInventoryDisplay extends AbstractDataDisplay {

	public FlightInventoryDisplay(FullRelationQueryServiceAsync dataQueryService) {
		super(dataQueryService);
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		dataQueryService.getFlightInventory(new TableGeneratingCallback());
	}

}
