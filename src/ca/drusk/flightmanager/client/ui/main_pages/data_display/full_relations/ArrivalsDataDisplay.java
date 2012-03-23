package ca.drusk.flightmanager.client.ui.main_pages.data_display.full_relations;

import ca.drusk.flightmanager.client.services.FullRelationQueryServiceAsync;

/**
 * Display for data from the Arrivals table.
 * 
 * @author drusk
 * 
 */
public class ArrivalsDataDisplay extends AbstractFullRelationDisplay {

	public ArrivalsDataDisplay(FullRelationQueryServiceAsync dataQueryService) {
		super(dataQueryService);
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		dataQueryService.getArrivals(new TableGeneratingCallback());
	}

}
