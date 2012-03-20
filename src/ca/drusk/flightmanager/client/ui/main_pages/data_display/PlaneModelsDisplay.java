package ca.drusk.flightmanager.client.ui.main_pages.data_display;

import ca.drusk.flightmanager.client.services.FullRelationQueryServiceAsync;

/**
 * Display for data from the PlaneModels table.
 * 
 * @author drusk
 * 
 */
public class PlaneModelsDisplay extends AbstractDataDisplay {

	public PlaneModelsDisplay(FullRelationQueryServiceAsync dataQueryService) {
		super(dataQueryService);
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		dataQueryService.getPlaneModels(new TableGeneratingCallback());
	}

}
