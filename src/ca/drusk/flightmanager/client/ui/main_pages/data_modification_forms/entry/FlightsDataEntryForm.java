package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry;

import ca.drusk.flightmanager.client.services.DataEntryServiceAsync;
import ca.drusk.flightmanager.client.table_data.TableNames;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.AbstractDataModificationForm;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

/**
 * UI elements for entering flight data.
 * 
 * @author drusk
 * 
 */
public class FlightsDataEntryForm extends AbstractDataModificationForm {

	private final DataEntryServiceAsync dataEntryService;

	public FlightsDataEntryForm(DataEntryServiceAsync dataEntryService) {
		this.dataEntryService = dataEntryService;
		inputForm.addLabel(5,
				" (use source's local time in 24 hour clock ex: 8:45)");
		inputForm.addLabel(6,
				" (use destination's local time in 24 hour clock ex: 14:20)");
	}

	@Override
	protected String getTitle() {
		return TableNames.FLIGHTS;
	}

	@Override
	protected String[] getInputFieldLabels() {
		return new String[] { "Airline code (2 characters)", "Flight number",
				"Source (airport code)", "Destination (airport code)",
				"Plane model code", "Planned Departure Time",
				"Planned Arrival Time" };
	}

	@Override
	protected Button createSubmissionButton() {
		Button submitButton = new Button(SUBMIT);
		submitButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String airlineCode = inputForm.getEnteredText(0);
				String flightNumber = inputForm.getEnteredText(1);
				String source = inputForm.getEnteredText(2);
				String destination = inputForm.getEnteredText(3);
				String planeCode = inputForm.getEnteredText(4);
				String plannedDepartureTime = inputForm.getEnteredText(5);
				String plannedArrivalTime = inputForm.getEnteredText(6);

				dataEntryService.addFlight(flightNumber, source, destination,
						airlineCode, planeCode, plannedArrivalTime,
						plannedDepartureTime, new LoggingCallback(
								"Added flight (" + airlineCode + flightNumber
										+ ")"));
			}

		});

		return submitButton;
	}

}
