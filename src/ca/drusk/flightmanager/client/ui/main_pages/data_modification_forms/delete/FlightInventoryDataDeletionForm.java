package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.delete;

import ca.drusk.flightmanager.client.services.DataDeletionServiceAsync;
import ca.drusk.flightmanager.client.table_data.FlightInventory;
import ca.drusk.flightmanager.client.table_data.TableNames;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.AbstractDataModificationForm;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

/**
 * UI elements for deleting records of a passenger's baggage for a flight.
 * 
 * @author drusk
 * 
 */
public class FlightInventoryDataDeletionForm extends
		AbstractDataModificationForm {

	private final DataDeletionServiceAsync dataDeletionService;

	public FlightInventoryDataDeletionForm(
			DataDeletionServiceAsync dataDeletionService) {
		super(new FlightInventory().getPrimaryKeyAttributes());
		this.dataDeletionService = dataDeletionService;
	}

	@Override
	protected String getTitle() {
		return TableNames.FLIGHT_INVENTORY;
	}

	@Override
	protected Button createSubmissionButton() {
		Button submitButton = new Button(DELETE);
		submitButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String passengerId = getEnteredText(FlightInventory.PASSENGER_ID);
				String flightId = getEnteredText(FlightInventory.FLIGHT_ID);
				String baggageId = getEnteredText(FlightInventory.BAGGAGE_ID);

				dataDeletionService.removeBaggageForFlight(passengerId,
						flightId, baggageId, new LoggingCallback(
								"Deletion sent to server"));
			}

		});

		return submitButton;
	}

}