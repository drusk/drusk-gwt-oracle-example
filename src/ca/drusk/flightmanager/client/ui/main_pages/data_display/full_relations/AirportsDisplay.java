package ca.drusk.flightmanager.client.ui.main_pages.data_display.full_relations;

import ca.drusk.flightmanager.client.services.FullRelationQueryServiceAsync;
import ca.drusk.flightmanager.client.table_data.TableNames;

/**
 * Display for data from the Locations table.
 * 
 * @author drusk
 * 
 */
public class AirportsDisplay extends AbstractFullRelationDisplay {

	public AirportsDisplay(FullRelationQueryServiceAsync dataQueryService) {
		super(TableNames.AIRPORTS, dataQueryService);
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		dataQueryService.getLocations(new TableGeneratingCallback());
	}

}
