package ca.drusk.flightmanager.client.ui.main_pages.data_display.full_relations;

import ca.drusk.flightmanager.client.services.FullRelationQueryServiceAsync;

/**
 * Display for data from the Locations table.
 * 
 * @author drusk
 * 
 */
public class AirportsDisplay extends AbstractFullRelationDisplay {

	public AirportsDisplay(FullRelationQueryServiceAsync dataQueryService) {
		super(dataQueryService);
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		dataQueryService.getLocations(new TableGeneratingCallback());
	}

}
