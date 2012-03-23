package ca.drusk.flightmanager.client.ui.main_pages.data_display.full_relations;

import ca.drusk.flightmanager.client.services.FullRelationQueryServiceAsync;
import ca.drusk.flightmanager.client.table_data.TableNames;

/**
 * Display for data from the Passengers table.
 * 
 * @author drusk
 * 
 */
public class PassengersDataDisplay extends AbstractFullRelationDisplay {

	public PassengersDataDisplay(FullRelationQueryServiceAsync dataQueryService) {
		super(TableNames.PASSENGERS, dataQueryService);
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		dataQueryService.getPassengers(new TableGeneratingCallback());
	}

}
