package ca.drusk.flightmanager.client.ui.main_pages.data_display;

import ca.drusk.flightmanager.client.services.DataQueryServiceAsync;

/**
 * Display for data from the Flights, IncomingFlights, and OutgoingFlights
 * tables.
 * 
 * @author drusk
 * 
 */
public class FlightsDisplay extends AbstractDataDisplay {

	public FlightsDisplay(DataQueryServiceAsync dataQueryService) {
		super(dataQueryService);
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		dataQueryService.getFlights(new TableGeneratingCallback());
	}
}
