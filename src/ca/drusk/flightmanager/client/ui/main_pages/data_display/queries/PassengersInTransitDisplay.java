package ca.drusk.flightmanager.client.ui.main_pages.data_display.queries;

import ca.drusk.flightmanager.client.services.FlightQueryServiceAsync;

/**
 * Displays the passengers in transit (on a flight that has departed but not
 * arrived at its destination yet).
 * 
 * @author drusk
 * 
 */
public class PassengersInTransitDisplay extends AbstractQueryInterface {

	public static final String DESC = "Passengers in transit";

	public PassengersInTransitDisplay(FlightQueryServiceAsync flightQueryService) {
		super(flightQueryService);
	}

	@Override
	public String getShortDescription() {
		return DESC;
	}

	@Override
	protected String getInstructions() {
		return "Press submit to view the passengers in transit";
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		flightQueryService
				.getPassengersInTransit(new TableGeneratingCallback());
	}

}
