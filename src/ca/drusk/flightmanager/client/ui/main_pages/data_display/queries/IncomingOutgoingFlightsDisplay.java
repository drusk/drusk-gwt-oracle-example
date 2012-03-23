package ca.drusk.flightmanager.client.ui.main_pages.data_display.queries;

import ca.drusk.flightmanager.client.services.FlightQueryServiceAsync;
import ca.drusk.flightmanager.client.table_data.Airports;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

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
		super(flightQueryService, Airports.AIRPORT_CODE);
	}

	@Override
	protected ClickHandler getInputSubmissionClickHandler() {
		return new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String airportCode = inputForm
						.getEnteredText(Airports.AIRPORT_CODE);
				flightQueryService.getIncomingAndOutgoingFlights(airportCode,
						new TableGeneratingCallback());
			}
		};
	}

	@Override
	protected String getTitle() {
		return "Enter an airport code to see what incoming and outgoing flights that airport has";
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getDescription() {
		return DESC;
	}

}
