package ca.drusk.flightmanager.client.ui.main_pages.data_display;

import ca.drusk.flightmanager.client.services.FullRelationQueryServiceAsync;

/**
 * Display for data from the Passengers table.
 * 
 * @author drusk
 * 
 */
public class PassengersDataDisplay extends AbstractDataDisplay {

	public PassengersDataDisplay(FullRelationQueryServiceAsync dataQueryService) {
		super(dataQueryService);
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		dataQueryService.getPassengers(new TableGeneratingCallback());
	}

}
