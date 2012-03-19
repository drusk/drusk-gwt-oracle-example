package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry;

import ca.drusk.flightmanager.client.services.DataEntryServiceAsync;
import ca.drusk.flightmanager.client.table_data.FlightInventory;
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
		super(new FlightInventory().getEntryFields());
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
				String passengerId = getEnteredText(FlightInventory.PASSENGER_ID);
				String flightId = getEnteredText(FlightInventory.FLIGHT_ID);
				String baggageId = getEnteredText(FlightInventory.BAGGAGE_ID);

				dataEntryService.addBaggageForFlight(passengerId, flightId,
						baggageId, new LoggingCallback(
								"Data received successfully by server"));
			}

		});

		return submitButton;
	}

}
