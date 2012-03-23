package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry;

import ca.drusk.flightmanager.client.services.DataEntryServiceAsync;
import ca.drusk.flightmanager.client.table_data.AllFlights;
import ca.drusk.flightmanager.client.table_data.Flights;
import ca.drusk.flightmanager.client.table_data.IncomingFlights;
import ca.drusk.flightmanager.client.table_data.OutgoingFlights;
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
		super(new AllFlights().getEntryFields());
		this.dataEntryService = dataEntryService;
	}

	@Override
	protected String getTitle() {
		return TableNames.FLIGHTS;
	}

	@Override
	protected Button createSubmissionButton() {
		Button submitButton = new Button(SUBMIT);
		submitButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String flightNumber = inputForm
						.getEnteredText(Flights.FLIGHT_NUMBER);
				String source = inputForm.getEnteredText(Flights.SOURCE);
				String destination = inputForm
						.getEnteredText(Flights.DESTINATION);
				String airlineCode = inputForm
						.getEnteredText(Flights.AIRLINE_CODE);
				String planeCode = inputForm.getEnteredText(Flights.PLANE_CODE);
				String plannedArrivalTime = inputForm
						.getEnteredText(IncomingFlights.PLANNED_ARRIVAL_TIME);
				String plannedDepartureTime = inputForm
						.getEnteredText(OutgoingFlights.PLANNED_DEPARTURE_TIME);

				dataEntryService.addFlight(flightNumber, source, destination,
						airlineCode, planeCode, plannedArrivalTime,
						plannedDepartureTime, new LoggingCallback(
								"Added flight (" + flightNumber + ")"));
			}

		});

		return submitButton;
	}

}
