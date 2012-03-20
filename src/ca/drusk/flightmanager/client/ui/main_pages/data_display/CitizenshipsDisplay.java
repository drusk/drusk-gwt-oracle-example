package ca.drusk.flightmanager.client.ui.main_pages.data_display;

import ca.drusk.flightmanager.client.services.FullRelationQueryServiceAsync;

/**
 * Display for data from the citizenships table.
 * 
 * @author drusk
 * 
 */
public class CitizenshipsDisplay extends AbstractDataDisplay {

	public CitizenshipsDisplay(FullRelationQueryServiceAsync dataQueryService) {
		super(dataQueryService);
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		dataQueryService.getCitizenships(new TableGeneratingCallback());
	}

}
