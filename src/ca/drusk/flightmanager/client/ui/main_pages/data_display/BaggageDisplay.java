package ca.drusk.flightmanager.client.ui.main_pages.data_display;

import ca.drusk.flightmanager.client.services.DataQueryServiceAsync;

/**
 * Display for data from the Baggage table.
 * 
 * @author drusk
 * 
 */
public class BaggageDisplay extends AbstractDataDisplay {

	public BaggageDisplay(DataQueryServiceAsync dataQueryService) {
		super(dataQueryService);
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		dataQueryService.getBaggage(new TableGeneratingCallback());
	}

}
