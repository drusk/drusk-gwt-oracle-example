package ca.drusk.flightmanager.client.ui.main_pages.data_display;

import ca.drusk.flightmanager.client.services.DataQueryServiceAsync;

/**
 * Display for data from the Arrivals table.
 * 
 * @author drusk
 * 
 */
public class ArrivalsDataDisplay extends AbstractDataDisplay {

	public ArrivalsDataDisplay(DataQueryServiceAsync dataQueryService) {
		super(dataQueryService);
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		dataQueryService.getArrivals(new TableGeneratingCallback());
	}

}
