package ca.drusk.flightmanager.client.ui.main_pages.data_display.full_relations;

import ca.drusk.flightmanager.client.services.FullRelationQueryServiceAsync;
import ca.drusk.flightmanager.client.table_data.TableNames;

/**
 * Display for data from the PassengerClass table.
 * 
 * @author drusk
 * 
 */
public class PassengerClassDataDisplay extends AbstractFullRelationDisplay {

	public PassengerClassDataDisplay(
			FullRelationQueryServiceAsync dataQueryService) {
		super(TableNames.PASSENGER_CLASS, dataQueryService);
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		dataQueryService.getPassengerClasses(new TableGeneratingCallback());
	}

}
