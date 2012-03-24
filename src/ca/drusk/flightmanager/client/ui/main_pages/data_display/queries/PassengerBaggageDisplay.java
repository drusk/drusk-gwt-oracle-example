package ca.drusk.flightmanager.client.ui.main_pages.data_display.queries;

import ca.drusk.flightmanager.client.services.FlightQueryServiceAsync;
import ca.drusk.flightmanager.client.table_data.FlightInventory;

/**
 * Displays the baggage for a passenger on a specific flight.
 * 
 * @author drusk
 * 
 */
public class PassengerBaggageDisplay extends AbstractQueryInterface {

	public static final String DESC = "Find Passenger Baggage";

	public PassengerBaggageDisplay(FlightQueryServiceAsync flightQueryService) {
		super(flightQueryService, FlightInventory.PASSENGER_ID,
				FlightInventory.FLIGHT_ID);
	}

	@Override
	public String getShortDescription() {
		return DESC;
	}

	@Override
	protected String getInstructions() {
		return "Enter a passenger id and specific flight id to see their baggage";
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		String passengerId = inputForm
				.getEnteredText(FlightInventory.PASSENGER_ID);
		String flightId = inputForm.getEnteredText(FlightInventory.FLIGHT_ID);
		flightQueryService.getBaggage(passengerId, flightId,
				new TableGeneratingCallback());
	}

}
