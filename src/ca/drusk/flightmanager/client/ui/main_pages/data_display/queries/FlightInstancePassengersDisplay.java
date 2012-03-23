package ca.drusk.flightmanager.client.ui.main_pages.data_display.queries;

import ca.drusk.flightmanager.client.services.FlightQueryServiceAsync;
import ca.drusk.flightmanager.client.table_data.FlightInstances;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

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
	public String getDescription() {
		return DESC;
	}

	@Override
	protected ClickHandler getInputSubmissionClickHandler() {
		return new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String flightInstanceId = inputForm
						.getEnteredText(FlightInstances.ID);
				flightQueryService.getPassengers(flightInstanceId,
						new TableGeneratingCallback());
			}
		};
	}

	@Override
	protected String getTitle() {
		return "Enter a particular flight's id to see what passengers are on board";
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		// TODO Auto-generated method stub

	}

}
