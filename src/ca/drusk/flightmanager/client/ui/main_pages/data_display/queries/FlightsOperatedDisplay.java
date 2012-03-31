package ca.drusk.flightmanager.client.ui.main_pages.data_display.queries;

import ca.drusk.flightmanager.client.services.FlightQueryServiceAsync;

/**
 * Display the results of the queries for the flights operated by an airline.
 * 
 * @author drusk
 * 
 */
public class FlightsOperatedDisplay extends AbstractQueryInterface {

	public static final String DESC = "Find flights operated by an airline";

	public FlightsOperatedDisplay(FlightQueryServiceAsync flightQueryService) {
		super(flightQueryService, "Airline code");
	}

	@Override
	protected String getInstructions() {
		return "Enter an airline code to see what flights that airline operates";
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		String airlineCode = inputForm.getEnteredText(0);
		flightQueryService.getOperatedFlights(airlineCode,
				new TableGeneratingCallback());
	}

	@Override
	public String getShortDescription() {
		return DESC;
	}

}
