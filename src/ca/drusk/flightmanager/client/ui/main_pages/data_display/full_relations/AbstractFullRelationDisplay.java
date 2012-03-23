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

	protected AbstractFullRelationDisplay(String tableName,
			FullRelationQueryServiceAsync dataQueryService) {
		this.dataQueryService = dataQueryService;
		init(tableName);
	}

	private void init(String tableName) {
		addInstructions("Press 'Submit' to retrieve/refresh <b><u>" + tableName
				+ "</u></b> records");
		createSubmitButton();
	}

}
