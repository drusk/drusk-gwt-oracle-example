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
		super(flightQueryService, TARGET_TIME, TIME_BUFFER);
	}

	@Override
	public String getShortDescription() {
		return DESC;
	}

	@Override
	protected String getInstructions() {
		return "Find arrivals, departures and their status around a specified time";
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		String targetTime = inputForm.getEnteredText(TARGET_TIME);
		String bufferTime = inputForm.getEnteredText(TIME_BUFFER);
		flightQueryService.getDeparturesAroundTime(targetTime, bufferTime,
				new TableGeneratingCallback());
		flightQueryService.getArrivalsAroundTime(targetTime, bufferTime,
				new TableGeneratingCallback());
	}

}
