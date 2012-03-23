package ca.drusk.flightmanager.client.ui.main_pages.data_display.queries;

import ca.drusk.flightmanager.client.services.FlightQueryServiceAsync;
import ca.drusk.flightmanager.client.table_data.Airlines;

/**
 * Display the results of the queries for the flights operated by an airline.
 * 
 * @author drusk
 * 
 */
public class FlightsOperatedDisplay extends AbstractQueryInterface {

	public static final String DESC = "Find flights operated by an airline";

	public FlightsOperatedDisplay(FlightQueryServiceAsync flightQueryService) {
		super(flightQueryService, Airlines.CODE);
	}

	@Override
	protected String getInstructions() {
		return "Enter an airline code to see what flights that airline operates";
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		String airlineCode = inputForm.getEnteredText(Airlines.CODE);
		flightQueryService.getOperatedFlights(airlineCode,
				new TableGeneratingCallback());
	}

	@Override
	public String getShortDescription() {
		return DESC;
	}

}
