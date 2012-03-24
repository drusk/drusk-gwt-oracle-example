package ca.drusk.flightmanager.client.ui.main_pages.data_display.queries;

import ca.drusk.flightmanager.client.services.FlightQueryServiceAsync;

/**
 * Displays the airline with the most delays for each route.
 * 
 * @author drusk
 * 
 */
public class RouteDelaysDisplay extends AbstractQueryInterface {

	public static final String DESC = "Route Delays";

	public RouteDelaysDisplay(FlightQueryServiceAsync flightQueryService) {
		super(flightQueryService);
	}

	@Override
	public String getShortDescription() {
		return DESC;
	}

	@Override
	protected String getInstructions() {
		return "Press submit to view the airline with the most delays for each route";
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		flightQueryService
				.getMostDelayedAirlines(new TableGeneratingCallback());
	}

}
