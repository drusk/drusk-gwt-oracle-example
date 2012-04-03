package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry;

import ca.drusk.flightmanager.client.services.DataEntryServiceAsync;
import ca.drusk.flightmanager.client.table_data.TableNames;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.AbstractDataModificationForm;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

/**
 * UI elements for entering flight departure data.
 * 
 * @author drusk
 * 
 */
public class DeparturesDataEntryForm extends AbstractDataModificationForm {

	private final DataEntryServiceAsync dataEntryService;

	public DeparturesDataEntryForm(DataEntryServiceAsync dataEntryService) {
		this.dataEntryService = dataEntryService;
		inputForm.addLabel(2,
				"(should be in 'MON DD, YYYY' format, ex: 'Apr 4, 2012')");
		inputForm.addLabel(4,
				"(should be in 'MON DD, YYYY' format, ex: 'Apr 4, 2012')");
		inputForm.addLabel(5,
				"(should be in 24 hour clock, 'HH:MI' format.  Ex: 14:20");
		inputForm
				.addLabel(6,
						"(should be in the form 'departed at xx:xx' or 'delayed to xx:xx')");
	}

	@Override
	protected String getTitle() {
		return TableNames.DEPARTURES;
	}

	@Override
	protected Button createSubmissionButton() {
		Button submitButton = new Button(SUBMIT);
		submitButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String airlineCode = inputForm.getEnteredText(0);
				String flightNumber = inputForm.getEnteredText(1);
				String plannedDepartureDay = inputForm.getEnteredText(2);
				String gate = inputForm.getEnteredText(3);
				String departureDay = inputForm.getEnteredText(4);
				String departureTime = inputForm.getEnteredText(5);
				String status = inputForm.getEnteredText(6);

				dataEntryService.addDeparture(airlineCode, flightNumber,
						plannedDepartureDay, gate, departureDay, departureTime,
						status, new LoggingCallback(
								"Added departure information for flight  "
										+ airlineCode + flightNumber + " on "
										+ plannedDepartureDay));
			}

		});

		return submitButton;
	}

	@Override
	protected String[] getInputFieldLabels() {
		return new String[] { "Airline code", "Flight number",
				"Planned departure day", "Gate", "Actual departure day",
				"Actual departure time", "Status" };
	}

}
