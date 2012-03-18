package ca.drusk.flightmanager.client.ui.main_pages.data_display;

import ca.drusk.flightmanager.client.services.DataQueryServiceAsync;

/**
 * Display for data in the Gates table.
 * 
 * @author drusk
 * 
 */
public class GatesDataDisplay extends AbstractDataDisplay {

	public GatesDataDisplay(DataQueryServiceAsync dataQueryService) {
		super(dataQueryService);
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		dataQueryService.getGates(new TableGeneratingCallback());
	}

}
