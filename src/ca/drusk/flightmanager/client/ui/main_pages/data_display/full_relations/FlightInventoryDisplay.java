package ca.drusk.flightmanager.client.ui.main_pages.data_display.full_relations;

import ca.drusk.flightmanager.client.services.FullRelationQueryServiceAsync;
import ca.drusk.flightmanager.client.table_data.TableNames;

/**
 * Display for data from the FlightInventory table.
 * 
 * @author drusk
 * 
 */
public class FlightInventoryDisplay extends AbstractFullRelationDisplay {

	public FlightInventoryDisplay(FullRelationQueryServiceAsync dataQueryService) {
		super(TableNames.FLIGHT_INVENTORY, dataQueryService);
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		dataQueryService.getFlightInventory(new TableGeneratingCallback());
	}

}
