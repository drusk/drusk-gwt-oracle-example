package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry;

import ca.drusk.flightmanager.client.services.DataEntryServiceAsync;
import ca.drusk.flightmanager.client.table_data.Arrivals;
import ca.drusk.flightmanager.client.table_data.Flights;
import ca.drusk.flightmanager.client.table_data.Gates;
import ca.drusk.flightmanager.client.table_data.Locations;
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
		super(new Arrivals().getEntryFields());
		this.dataEntryService = dataEntryService;
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
				String gate = getEnteredText(Gates.GATE);
				String airportCode = getEnteredText(Locations.AIRPORT_CODE);
				String arrivalDay = getEnteredText(Arrivals.ARRIVAL_DAY);
				String arrivalTime = getEnteredText(Arrivals.ARRIVAL_TIME);
				String status = getEnteredText(Arrivals.STATUS);
				String flightNumber = getEnteredText(Flights.FLIGHT_NUMBER);

				dataEntryService.addArrival(gate, airportCode, arrivalDay,
						arrivalTime, status, flightNumber, new LoggingCallback(
								"Data received successfully by server"));
			}

		});

		return submitButton;
	}

}
