package ca.drusk.flightmanager.client.ui.main_pages.data_display.queries;

import ca.drusk.flightmanager.client.services.FlightQueryServiceAsync;
import ca.drusk.flightmanager.client.table_data.FlightInstances;

/**
 * Displays the passengers on a particular flight.
 * 
 * @author drusk
 * 
 */
public class FlightInstancePassengersDisplay extends AbstractQueryInterface {

	public static final String DESC = "Find passengers on a particular flight";

	public FlightInstancePassengersDisplay(
			FlightQueryServiceAsync flightQueryService) {
		super(flightQueryService, FlightInstances.ID);
	}

	@Override
	public String getShortDescription() {
		return DESC;
	}

	@Override
	protected String getInstructions() {
		return "Enter a particular flight's id to see what passengers are on board";
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		String flightInstanceId = inputForm.getEnteredText(FlightInstances.ID);
		flightQueryService.getPassengers(flightInstanceId,
				new TableGeneratingCallback());

	}

}
