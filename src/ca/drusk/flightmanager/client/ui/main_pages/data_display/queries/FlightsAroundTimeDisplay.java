package ca.drusk.flightmanager.client.ui.main_pages.data_display.queries;

import ca.drusk.flightmanager.client.services.FlightQueryServiceAsync;

/**
 * Displays arrivals and departures within a specified time range around a
 * specified time.
 * 
 * @author drusk
 * 
 */
public class FlightsAroundTimeDisplay extends AbstractQueryInterface {

	public static final String DESC = "Find Flights By Time";

	private static final String TARGET_TIME = "Target time";

	private static final String TIME_BUFFER = "Buffer time";

	public FlightsAroundTimeDisplay(FlightQueryServiceAsync flightQueryService) {
		super(flightQueryService, TARGET_TIME, TIME_BUFFER, "Airport code");
	}

	@Override
	public String getShortDescription() {
		return DESC;
	}

	@Override
	protected String getInstructions() {
		return "Find arrivals, departures and their status around a specified time for a specific airport."
				+ "Enter times in hours and minutes (ex: 9:45, 14:20, 0:45)";
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		String targetTime = inputForm.getEnteredText(0);
		String bufferTime = inputForm.getEnteredText(1);
		String airportCode = inputForm.getEnteredText(2);
		flightQueryService.getDeparturesAroundTime(targetTime, bufferTime,
				airportCode, new TableGeneratingCallback());
		flightQueryService.getArrivalsAroundTime(targetTime, bufferTime,
				airportCode, new TableGeneratingCallback());
	}

}
