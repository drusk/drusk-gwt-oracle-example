package ca.drusk.flightmanager.client.ui.main_pages.data_display;

import ca.drusk.flightmanager.client.services.FullRelationQueryServiceAsync;

/**
 * Display for data from the Departures table.
 * 
 * @author drusk
 * 
 */
public class DeparturesDataDisplay extends AbstractDataDisplay {

	public DeparturesDataDisplay(FullRelationQueryServiceAsync dataQueryService) {
		super(dataQueryService);
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		dataQueryService.getDepartures(new TableGeneratingCallback());
	}

}
