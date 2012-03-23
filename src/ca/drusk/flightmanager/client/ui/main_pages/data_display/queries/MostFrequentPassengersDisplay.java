package ca.drusk.flightmanager.client.ui.main_pages.data_display.queries;

import ca.drusk.flightmanager.client.services.FlightQueryServiceAsync;

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
	public String getShortDescription() {
		return DESC;
	}

	@Override
	protected String getInstructions() {
		return "Displays top passengers in terms of number of flights taken.  Enter a number to limit the number of results.";
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		String topN = inputForm.getEnteredText(TOP);
		flightQueryService.getMostFrequentPassengers(topN,
				new TableGeneratingCallback());
	}

}
