package ca.drusk.flightmanager.client.ui.main_pages.data_display;

import ca.drusk.flightmanager.client.services.FullRelationQueryServiceAsync;

/**
 * Display for data in the Gates table.
 * 
 * @author drusk
 * 
 */
public class GatesDataDisplay extends AbstractDataDisplay {

	public GatesDataDisplay(FullRelationQueryServiceAsync dataQueryService) {
		super(dataQueryService);
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		dataQueryService.getGates(new TableGeneratingCallback());
	}

}
