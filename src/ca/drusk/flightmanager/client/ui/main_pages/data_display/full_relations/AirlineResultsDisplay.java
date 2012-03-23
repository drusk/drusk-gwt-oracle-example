package ca.drusk.flightmanager.client.ui.main_pages.data_display.full_relations;

import ca.drusk.flightmanager.client.services.FullRelationQueryServiceAsync;
import ca.drusk.flightmanager.client.table_data.TableNames;

/**
 * Display for data from the Airlines table.
 * 
 * @author drusk
 * 
 */
public class AirlineResultsDisplay extends AbstractFullRelationDisplay {

	public AirlineResultsDisplay(FullRelationQueryServiceAsync dataQueryService) {
		super(TableNames.AIRLINES, dataQueryService);
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		dataQueryService.getAirlines(new TableGeneratingCallback());
	}

}
