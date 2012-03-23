package ca.drusk.flightmanager.client.ui.main_pages.data_display.full_relations;

import ca.drusk.flightmanager.client.services.FullRelationQueryServiceAsync;

/**
 * Display for data from the Baggage table.
 * 
 * @author drusk
 * 
 */
public class BaggageDisplay extends AbstractFullRelationDisplay {

	public BaggageDisplay(FullRelationQueryServiceAsync dataQueryService) {
		super(dataQueryService);
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		dataQueryService.getBaggage(new TableGeneratingCallback());
	}

}
