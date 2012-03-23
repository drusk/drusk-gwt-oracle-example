package ca.drusk.flightmanager.client.ui.main_pages.data_display.full_relations;

import ca.drusk.flightmanager.client.services.FullRelationQueryServiceAsync;

/**
 * Display for data in the Gates table.
 * 
 * @author drusk
 * 
 */
public class GatesDataDisplay extends AbstractFullRelationDisplay {

	public GatesDataDisplay(FullRelationQueryServiceAsync dataQueryService) {
		super(dataQueryService);
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		dataQueryService.getGates(new TableGeneratingCallback());
	}

}
