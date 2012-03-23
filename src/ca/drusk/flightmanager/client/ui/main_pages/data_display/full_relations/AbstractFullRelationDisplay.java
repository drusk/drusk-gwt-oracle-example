package ca.drusk.flightmanager.client.ui.main_pages.data_display.full_relations;

import ca.drusk.flightmanager.client.services.FullRelationQueryServiceAsync;
import ca.drusk.flightmanager.client.ui.main_pages.data_display.AbstractDataDisplay;

/**
 * Provides common functionality for displays which just show a full relation.
 * 
 * @author drusk
 * 
 */
public abstract class AbstractFullRelationDisplay extends AbstractDataDisplay {

	protected FullRelationQueryServiceAsync dataQueryService;

	protected AbstractFullRelationDisplay(
			FullRelationQueryServiceAsync dataQueryService) {
		this.dataQueryService = dataQueryService;
		init();
	}

	private void init() {
		createRefreshButton();
		retrieveResultsAndAddToDisplay();
		display.setSpacing(SPACING);
	}

}
