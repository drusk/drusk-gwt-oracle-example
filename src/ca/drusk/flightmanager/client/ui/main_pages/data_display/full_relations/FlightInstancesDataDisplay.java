package ca.drusk.flightmanager.client.ui.main_pages.data_display.full_relations;

import ca.drusk.flightmanager.client.services.FullRelationQueryServiceAsync;

/**
 * Display for data from the FlightInstances table.
 * 
 * @author drusk
 * 
 */
public class FlightInstancesDataDisplay extends AbstractFullRelationDisplay {

	public FlightInstancesDataDisplay(
			FullRelationQueryServiceAsync dataQueryService) {
		super(dataQueryService);
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		dataQueryService.getFlightInstances(new TableGeneratingCallback());
	}

}
