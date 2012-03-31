package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry;

import ca.drusk.flightmanager.client.services.DataEntryServiceAsync;
import ca.drusk.flightmanager.client.table_data.TableNames;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.AbstractDataModificationForm;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

/**
 * UI elements for entering the baggage taken by a passenger on a specific
 * flight.
 * 
 * @author drusk
 * 
 */
public class FlightInventoryDataEntryForm extends AbstractDataModificationForm {

	private final DataEntryServiceAsync dataEntryService;

	public FlightInventoryDataEntryForm(DataEntryServiceAsync dataEntryService) {
		this.dataEntryService = dataEntryService;
	}

	@Override
	protected String getTitle() {
		return TableNames.FLIGHT_INVENTORY;
	}

	@Override
	protected Button createSubmissionButton() {
		Button submitButton = new Button(SUBMIT);
		submitButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String passengerId = inputForm.getEnteredText(0);
				String flightId = inputForm.getEnteredText(1);
				String baggageId = inputForm.getEnteredText(2);

				dataEntryService.addBaggageForFlight(passengerId, flightId,
						baggageId, new LoggingCallback("Added baggage with id="
								+ baggageId + " to flight instance " + flightId
								+ " for passenger " + passengerId));
			}

		});

		return submitButton;
	}

	@Override
	protected String[] getInputFieldLabels() {
		return new String[] { "Passenger id", "Flight instance id",
				"Baggage id" };
	}

}
