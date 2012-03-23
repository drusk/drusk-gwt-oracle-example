package ca.drusk.flightmanager.client.ui.main_pages.data_display.full_relations;

import ca.drusk.flightmanager.client.services.FullRelationQueryServiceAsync;

/**
 * Display for data from the FlightAttendance table.
 * 
 * @author drusk
 * 
 */
public class FlightAttendanceDataDisplay extends AbstractFullRelationDisplay {

	public FlightAttendanceDataDisplay(
			FullRelationQueryServiceAsync dataQueryService) {
		super(dataQueryService);
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		dataQueryService.getFlightAttendance(new TableGeneratingCallback());
	}

}
