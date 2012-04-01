package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry;

import ca.drusk.flightmanager.client.services.DataEntryServiceAsync;
import ca.drusk.flightmanager.client.table_data.TableNames;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.AbstractDataModificationForm;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

/**
 * UI elements for entering flight instances.
 * 
 * @author drusk
 * 
 */
public class FlightInstancesDataEntryForm extends AbstractDataModificationForm {

	private final DataEntryServiceAsync dataEntryService;

	public FlightInstancesDataEntryForm(DataEntryServiceAsync dataEntryService) {
		this.dataEntryService = dataEntryService;
		inputForm.addLabel(2,
				"(should be in 'MON DD, YYYY' format, ex: 'Apr 4, 2012')");
	}

	@Override
	protected String getTitle() {
		return TableNames.FLIGHT_INSTANCES;
	}

	@Override
	protected Button createSubmissionButton() {
		Button submitButton = new Button(SUBMIT);
		submitButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String airlineCode = inputForm.getEnteredText(0);
				String flightNumber = inputForm.getEnteredText(1);
				String flightDate = inputForm.getEnteredText(2);
				dataEntryService.addFlightInstance(airlineCode, flightNumber,
						flightDate, new LoggingCallback(
								"Added a flight instance for flight "
										+ airlineCode + flightNumber + " on "
										+ flightDate));
			}

		});

		return submitButton;
	}

	@Override
	protected String[] getInputFieldLabels() {
		return new String[] { "Airline code", "Flight number", "Flight date" };
	}

}
