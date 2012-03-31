package ca.drusk.flightmanager.client.ui.main_pages.data_display.full_relations;

import ca.drusk.flightmanager.client.services.FullRelationQueryServiceAsync;
import ca.drusk.flightmanager.client.table_data.TableNames;

/**
 * Display for data from the Infants table.
 * 
 * @author drusk
 * 
 */
public class InfantsDisplay extends AbstractFullRelationDisplay {

	public InfantsDisplay(FullRelationQueryServiceAsync dataQueryService) {
		super(TableNames.INFANTS, dataQueryService);
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		dataQueryService.getInfants(new TableGeneratingCallback());
	}

}
