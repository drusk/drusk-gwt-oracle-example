package ca.drusk.flightmanager.client.ui.main_pages.data_display.full_relations;

import ca.drusk.flightmanager.client.services.FullRelationQueryServiceAsync;

/**
 * Display for data from the citizenships table.
 * 
 * @author drusk
 * 
 */
public class CitizenshipsDisplay extends AbstractFullRelationDisplay {

	public CitizenshipsDisplay(FullRelationQueryServiceAsync dataQueryService) {
		super(dataQueryService);
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		dataQueryService.getCitizenships(new TableGeneratingCallback());
	}

}
