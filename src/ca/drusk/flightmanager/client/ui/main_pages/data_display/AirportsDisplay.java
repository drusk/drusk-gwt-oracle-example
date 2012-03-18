package ca.drusk.flightmanager.client.ui.main_pages.data_display;

import ca.drusk.flightmanager.client.services.DataQueryServiceAsync;

/**
 * Display for data from the Locations table.
 * 
 * @author drusk
 * 
 */
public class AirportsDisplay extends AbstractDataDisplay {

	public AirportsDisplay(DataQueryServiceAsync dataQueryService) {
		super(dataQueryService);
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		dataQueryService.getLocations(new TableGeneratingCallback());
	}

}
