package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry;

import ca.drusk.flightmanager.client.services.DataEntryServiceAsync;
import ca.drusk.flightmanager.client.table_data.FlightAttendance;
import ca.drusk.flightmanager.client.table_data.TableNames;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.AbstractDataModificationForm;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

/**
 * UI elements for entering flight attendance data.
 * 
 * @author drusk
 * 
 */
public class FlightAttendanceDataEntryForm extends AbstractDataModificationForm {

	private final DataEntryServiceAsync dataEntryService;

	public FlightAttendanceDataEntryForm(DataEntryServiceAsync dataEntryService) {
		super(new FlightAttendance().getEntryFields());
		this.dataEntryService = dataEntryService;
	}

	@Override
	protected String getTitle() {
		return TableNames.FLIGHT_ATTENDANCE;
	}

	@Override
	protected Button createSubmissionButton() {
		Button submitButton = new Button(SUBMIT);
		submitButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String passengerId = getEnteredText(FlightAttendance.PASSENGER_ID);
				String flightId = getEnteredText(FlightAttendance.FLIGHT_ID);
				String travelClass = getEnteredText(FlightAttendance.TRAVEL_CLASS);
				dataEntryService.addPassengerToFlight(passengerId, flightId,
						travelClass, new LoggingCallback(
								"Data received successfully by server"));
			}

		});

		return submitButton;
	}

}
