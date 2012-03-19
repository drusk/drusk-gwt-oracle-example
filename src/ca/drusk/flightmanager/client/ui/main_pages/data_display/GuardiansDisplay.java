package ca.drusk.flightmanager.client.ui.main_pages.data_display;

import ca.drusk.flightmanager.client.services.DataQueryServiceAsync;

/**
 * Display for data from the Guardians table.
 * 
 * @author drusk
 * 
 */
public class GuardiansDisplay extends AbstractDataDisplay {

	public GuardiansDisplay(DataQueryServiceAsync dataQueryService) {
		super(dataQueryService);
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		dataQueryService.getGuardians(new TableGeneratingCallback());
	}

}
