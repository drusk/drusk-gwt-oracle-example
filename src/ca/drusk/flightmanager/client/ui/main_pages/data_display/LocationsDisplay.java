package ca.drusk.flightmanager.client.ui.main_pages.data_display;

import ca.drusk.flightmanager.client.services.DataQueryServiceAsync;

/**
 * Display for data from the Locations table.
 * 
 * @author drusk
 * 
 */
public class LocationsDisplay extends AbstractDataDisplay {

	public LocationsDisplay(DataQueryServiceAsync dataQueryService) {
		super(dataQueryService);
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		dataQueryService.getLocations(new TableGeneratingCallback());
	}

}
