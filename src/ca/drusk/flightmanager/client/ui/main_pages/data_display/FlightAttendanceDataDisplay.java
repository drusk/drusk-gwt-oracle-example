package ca.drusk.flightmanager.client.ui.main_pages.data_display;

import ca.drusk.flightmanager.client.services.DataQueryServiceAsync;

/**
 * Display for data from the FlightAttendance table.
 * 
 * @author drusk
 * 
 */
public class FlightAttendanceDataDisplay extends AbstractDataDisplay {

	public FlightAttendanceDataDisplay(DataQueryServiceAsync dataQueryService) {
		super(dataQueryService);
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		dataQueryService.getFlightAttendance(new TableGeneratingCallback());
	}

}
