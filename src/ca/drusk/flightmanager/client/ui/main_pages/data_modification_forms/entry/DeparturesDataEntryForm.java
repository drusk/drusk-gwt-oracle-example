package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry;

import ca.drusk.flightmanager.client.services.DataEntryServiceAsync;
import ca.drusk.flightmanager.client.table_data.Departures;
import ca.drusk.flightmanager.client.table_data.Flights;
import ca.drusk.flightmanager.client.table_data.Gates;
import ca.drusk.flightmanager.client.table_data.Locations;
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
		super(new Departures().getEntryFields());
		this.dataEntryService = dataEntryService;
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
				String gate = getEnteredText(Gates.GATE);
				String airportCode = getEnteredText(Locations.AIRPORT_CODE);
				String departureDay = getEnteredText(Departures.DEPARTURE_DAY);
				String departureTime = getEnteredText(Departures.DEPARTURE_TIME);
				String status = getEnteredText(Departures.STATUS);
				String flightNumber = getEnteredText(Flights.FLIGHT_NUMBER);

				dataEntryService.addDeparture(gate, airportCode, departureDay,
						departureTime, status, flightNumber,
						new LoggingCallback(
								"Data received successfully by server"));
			}

		});

		return submitButton;
	}

}
