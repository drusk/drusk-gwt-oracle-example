package ca.drusk.flightmanager.client.ui.main_pages.data_display.full_relations;

import ca.drusk.flightmanager.client.services.FullRelationQueryServiceAsync;
import ca.drusk.flightmanager.client.table_data.TableNames;

/**
 * Display for data from the FlightAttendance table.
 * 
 * @author drusk
 * 
 */
public class FlightAttendanceDataDisplay extends AbstractFullRelationDisplay {

	public FlightAttendanceDataDisplay(
			FullRelationQueryServiceAsync dataQueryService) {
		super(TableNames.FLIGHT_ATTENDANCE, dataQueryService);
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		dataQueryService.getFlightAttendance(new TableGeneratingCallback());
	}

}
