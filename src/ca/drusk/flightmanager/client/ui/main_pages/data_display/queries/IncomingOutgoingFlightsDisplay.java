package ca.drusk.flightmanager.client.ui.main_pages.data_display.queries;

import ca.drusk.flightmanager.client.services.FlightQueryServiceAsync;

/**
 * Displays incoming and outgoing flights for a location.
 * 
 * @author drusk
 * 
 */
public class IncomingOutgoingFlightsDisplay extends AbstractQueryInterface {

	public static final String DESC = "Find incoming and outgoing flights";

	public IncomingOutgoingFlightsDisplay(
			FlightQueryServiceAsync flightQueryService) {
		super(flightQueryService, "Airport code");
	}

	@Override
	protected String getInstructions() {
		return "Enter an airport code to see what incoming and outgoing flights that airport has";
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		String airportCode = inputForm.getEnteredText(0);
		flightQueryService.getIncomingAndOutgoingFlights(airportCode,
				new TableGeneratingCallback());
	}

	@Override
	public String getShortDescription() {
		return DESC;
	}

}
