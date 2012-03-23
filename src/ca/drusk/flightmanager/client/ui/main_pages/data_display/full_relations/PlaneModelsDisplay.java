package ca.drusk.flightmanager.client.ui.main_pages.data_display.full_relations;

import ca.drusk.flightmanager.client.services.FullRelationQueryServiceAsync;

/**
 * Display for data from the PlaneModels table.
 * 
 * @author drusk
 * 
 */
public class PlaneModelsDisplay extends AbstractFullRelationDisplay {

	public PlaneModelsDisplay(FullRelationQueryServiceAsync dataQueryService) {
		super(dataQueryService);
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		dataQueryService.getPlaneModels(new TableGeneratingCallback());
	}

}
