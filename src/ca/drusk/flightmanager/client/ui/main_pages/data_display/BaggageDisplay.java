package ca.drusk.flightmanager.client.ui.main_pages.data_display;

import ca.drusk.flightmanager.client.services.FullRelationQueryServiceAsync;

/**
 * Display for data from the Baggage table.
 * 
 * @author drusk
 * 
 */
public class BaggageDisplay extends AbstractDataDisplay {

	public BaggageDisplay(FullRelationQueryServiceAsync dataQueryService) {
		super(dataQueryService);
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		dataQueryService.getBaggage(new TableGeneratingCallback());
	}

}
