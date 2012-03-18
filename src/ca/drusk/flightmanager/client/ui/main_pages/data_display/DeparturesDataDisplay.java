package ca.drusk.flightmanager.client.ui.main_pages.data_display;

import ca.drusk.flightmanager.client.services.DataQueryServiceAsync;

/**
 * Display for data from the Departures table.
 * 
 * @author drusk
 * 
 */
public class DeparturesDataDisplay extends AbstractDataDisplay {

	public DeparturesDataDisplay(DataQueryServiceAsync dataQueryService) {
		super(dataQueryService);
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		dataQueryService.getDepartures(new TableGeneratingCallback());
	}

}
