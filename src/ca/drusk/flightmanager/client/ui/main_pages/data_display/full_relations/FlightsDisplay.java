package ca.drusk.flightmanager.client.ui.main_pages.data_display.full_relations;

import ca.drusk.flightmanager.client.services.FullRelationQueryServiceAsync;
import ca.drusk.flightmanager.client.table_data.TableNames;

/**
 * Display for data from the Flights, IncomingFlights, and OutgoingFlights
 * tables.
 * 
 * @author drusk
 * 
 */
public class FlightsDisplay extends AbstractFullRelationDisplay {

	public FlightsDisplay(FullRelationQueryServiceAsync dataQueryService) {
		super(TableNames.FLIGHTS, dataQueryService);
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		dataQueryService.getFlights(new TableGeneratingCallback());
	}
}
