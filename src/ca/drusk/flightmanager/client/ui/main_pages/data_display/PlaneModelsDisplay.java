package ca.drusk.flightmanager.client.ui.main_pages.data_display;

import ca.drusk.flightmanager.client.services.DataQueryServiceAsync;

/**
 * Display for data from the PlaneModels table.
 * 
 * @author drusk
 * 
 */
public class PlaneModelsDisplay extends AbstractDataDisplay {

	public PlaneModelsDisplay(DataQueryServiceAsync dataQueryService) {
		super(dataQueryService);
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		dataQueryService.getPlaneModels(new TableGeneratingCallback());
	}

}
