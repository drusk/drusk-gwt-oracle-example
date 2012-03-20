package ca.drusk.flightmanager.client.ui.main_pages.data_display;

import ca.drusk.flightmanager.client.services.FullRelationQueryServiceAsync;

/**
 * Display for data from the FlightInstances table.
 * 
 * @author drusk
 * 
 */
public class FlightInstancesDataDisplay extends AbstractDataDisplay {

	public FlightInstancesDataDisplay(FullRelationQueryServiceAsync dataQueryService) {
		super(dataQueryService);
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		dataQueryService.getFlightInstances(new TableGeneratingCallback());
	}

}
