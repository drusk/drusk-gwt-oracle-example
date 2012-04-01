package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.delete;

import ca.drusk.flightmanager.client.services.DataDeletionServiceAsync;
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
				String flightId = inputForm.getEnteredText(0);
				String baggageId = inputForm.getEnteredText(1);

				dataDeletionService.removeBaggageForFlight(flightId, baggageId,
						new LoggingCallback("Deleted baggage with id="
								+ baggageId + " from flight instance "
								+ flightId));
			}

		});

		return submitButton;
	}

	@Override
	protected String[] getInputFieldLabels() {
		return new String[] { "Flight instance id", "Baggage id" };
	}

}
