package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.delete;

import ca.drusk.flightmanager.client.services.DataDeletionServiceAsync;
import ca.drusk.flightmanager.client.table_data.TableNames;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.AbstractDataModificationForm;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

/**
 * UI elements for deleting flight attendance entries from the database.
 * 
 * @author drusk
 * 
 */
public class FlightAttendanceDataDeletionForm extends
		AbstractDataModificationForm {

	private final DataDeletionServiceAsync dataDeletionService;

	public FlightAttendanceDataDeletionForm(
			DataDeletionServiceAsync dataDeletionService) {
		this.dataDeletionService = dataDeletionService;
	}

	@Override
	protected String getTitle() {
		return TableNames.FLIGHT_ATTENDANCE;
	}

	@Override
	protected Button createSubmissionButton() {
		Button submitButton = new Button(DELETE);
		submitButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String passengerId = inputForm.getEnteredText(0);
				String flightId = inputForm.getEnteredText(1);

				dataDeletionService.removePassengerFromFlight(passengerId,
						flightId, new LoggingCallback("Deleted passenger "
								+ passengerId + " from flight " + flightId));
			}

		});

		return submitButton;
	}

	@Override
	protected String[] getInputFieldLabels() {
		return new String[] { "Passenger id", "Flight instance id" };
	}

}
