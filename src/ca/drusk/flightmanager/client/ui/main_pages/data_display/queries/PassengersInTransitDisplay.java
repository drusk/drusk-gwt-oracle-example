package ca.drusk.flightmanager.client.ui.main_pages.data_display.queries;

import ca.drusk.flightmanager.client.services.FlightQueryServiceAsync;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

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
	public String getDescription() {
		return DESC;
	}

	@Override
	protected ClickHandler getInputSubmissionClickHandler() {
		return new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				flightQueryService
						.getPassengersInTransit(new TableGeneratingCallback());
			}
		};
	}

	@Override
	protected String getTitle() {
		return "Find Passengers In Transit";
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		// TODO Auto-generated method stub

	}

}
