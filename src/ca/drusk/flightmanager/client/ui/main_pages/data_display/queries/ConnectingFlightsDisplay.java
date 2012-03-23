package ca.drusk.flightmanager.client.ui.main_pages.data_display.queries;

import ca.drusk.flightmanager.client.services.FlightQueryServiceAsync;

/**
 * Displays connecting flights where the wait time is within some specified
 * threshold value.
 * 
 * @author drusk
 * 
 */
public class ConnectingFlightsDisplay extends AbstractQueryInterface {

	public static final String DESC = "Find connecting flights";

	private static final String MAX_WAIT_TIME = "Max wait time";

	public ConnectingFlightsDisplay(FlightQueryServiceAsync flightQueryService) {
		super(flightQueryService, MAX_WAIT_TIME);
	}

	@Override
	public String getShortDescription() {
		return DESC;
	}

	@Override
	protected String getInstructions() {
		return "Enter a max wait time for connecting flights";
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		String maxWaitTime = inputForm.getEnteredText(MAX_WAIT_TIME);
		flightQueryService.getConnectingFlights(maxWaitTime,
				new TableGeneratingCallback());
	}

}
