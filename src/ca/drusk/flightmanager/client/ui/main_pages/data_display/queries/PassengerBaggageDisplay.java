package ca.drusk.flightmanager.client.ui.main_pages.data_display.queries;

import ca.drusk.flightmanager.client.services.FlightQueryServiceAsync;
import ca.drusk.flightmanager.client.table_data.FlightInstances;
import ca.drusk.flightmanager.client.table_data.Passengers;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

/**
 * Displays the baggage for a passenger on a specific flight.
 * 
 * @author drusk
 * 
 */
public class PassengerBaggageDisplay extends AbstractQueryInterface {

	public static final String DESC = "Find Passenger Baggage";

	public PassengerBaggageDisplay(FlightQueryServiceAsync flightQueryService) {
		super(flightQueryService, Passengers.ID, FlightInstances.ID);
	}

	@Override
	public String getDescription() {
		return DESC;
	}

	@Override
	protected ClickHandler getInputSubmissionClickHandler() {
		return new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String passengerId = inputForm.getEnteredText(Passengers.ID);
				String flightId = inputForm.getEnteredText(FlightInstances.ID);
				flightQueryService.getBaggage(passengerId, flightId,
						new TableGeneratingCallback());
			}
		};
	}

	@Override
	protected String getTitle() {
		return "Enter a passenger id and specific flight id to see their baggage";
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		// TODO Auto-generated method stub

	}

}
