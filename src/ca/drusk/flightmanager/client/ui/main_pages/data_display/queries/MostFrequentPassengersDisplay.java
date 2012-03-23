package ca.drusk.flightmanager.client.ui.main_pages.data_display.queries;

import ca.drusk.flightmanager.client.services.FlightQueryServiceAsync;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

/**
 * Displays the top passengers in terms of number of flights taken.
 * 
 * @author drusk
 * 
 */
public class MostFrequentPassengersDisplay extends AbstractQueryInterface {

	private static final String TOP = "Number of results";

	public static final String DESC = "Most Frequent Fliers";

	public MostFrequentPassengersDisplay(
			FlightQueryServiceAsync flightQueryService) {
		super(flightQueryService, TOP);
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
				String topN = inputForm.getEnteredText(TOP);
				flightQueryService.getMostFrequentPassengers(topN,
						new TableGeneratingCallback());
			}
		};
	}

	@Override
	protected String getTitle() {
		return "Displays top passengers in terms of number of flights taken.  Enter a number to limit the number of results.";
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		// TODO Auto-generated method stub

	}

}
