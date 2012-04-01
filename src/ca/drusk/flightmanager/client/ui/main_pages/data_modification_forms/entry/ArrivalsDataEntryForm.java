package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry;

import ca.drusk.flightmanager.client.services.DataEntryServiceAsync;
import ca.drusk.flightmanager.client.table_data.TableNames;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.AbstractDataModificationForm;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

/**
 * UI elements for entering data about flight arrivals.
 * 
 * @author drusk
 * 
 */
public class ArrivalsDataEntryForm extends AbstractDataModificationForm {

	private final DataEntryServiceAsync dataEntryService;

	public ArrivalsDataEntryForm(DataEntryServiceAsync dataEntryService) {
		this.dataEntryService = dataEntryService;
		inputForm.addLabel(2,
				"(should be in 'MON DD, YYYY' format, ex: 'Apr 4, 2012')");
		inputForm.addLabel(5,
				"(should be in 'MON DD, YYYY' format, ex: 'Apr 4, 2012')");
		inputForm.addLabel(6,
				"(should be in 24 hour clock, 'HH:MI' format.  Ex: 14:20");
		inputForm
				.addLabel(7,
						"(should be in the form 'arrived at xx:xx' or 'delayed to xx:xx')");
	}

	@Override
	protected String getTitle() {
		return TableNames.ARRIVALS;
	}

	@Override
	protected Button createSubmissionButton() {
		Button submitButton = new Button(SUBMIT);
		submitButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String airlineCode = inputForm.getEnteredText(0);
				String flightNumber = inputForm.getEnteredText(1);
				String plannedDepartureDate = inputForm.getEnteredText(2);
				String gate = inputForm.getEnteredText(3);
				String airportCode = inputForm.getEnteredText(4);
				String arrivalDay = inputForm.getEnteredText(5);
				String arrivalTime = inputForm.getEnteredText(6);
				String status = inputForm.getEnteredText(7);

				dataEntryService.addArrival(airlineCode, flightNumber,
						plannedDepartureDate, gate, airportCode, arrivalDay,
						arrivalTime, status, new LoggingCallback(
								"Added arrival information for flight "
										+ airlineCode + flightNumber + " on "
										+ plannedDepartureDate));
			}

		});

		return submitButton;
	}

	@Override
	protected String[] getInputFieldLabels() {
		return new String[] { "Airline code", "Flight number",
				"Planned departure date", "Gate", "Airport",
				"Actual arrival day", "Actual arrival time", "Status" };
	}

}
