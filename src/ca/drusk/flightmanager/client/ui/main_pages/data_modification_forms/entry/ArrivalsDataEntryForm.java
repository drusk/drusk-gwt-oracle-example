package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry;

import ca.drusk.flightmanager.client.services.DataEntryServiceAsync;
import ca.drusk.flightmanager.client.table_data.Airports;
import ca.drusk.flightmanager.client.table_data.Arrivals;
import ca.drusk.flightmanager.client.table_data.FlightInstances;
import ca.drusk.flightmanager.client.table_data.Gates;
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
				String id = inputForm.getEnteredText(FlightInstances.ID);
				String gate = inputForm.getEnteredText(Gates.GATE);
				String airportCode = inputForm
						.getEnteredText(Airports.AIRPORT_CODE);
				String arrivalDay = inputForm
						.getEnteredText(Arrivals.ARRIVAL_DAY);
				String arrivalTime = inputForm
						.getEnteredText(Arrivals.ARRIVAL_TIME);
				String status = inputForm.getEnteredText(Arrivals.STATUS);

				dataEntryService.addArrival(id, gate, airportCode, arrivalDay,
						arrivalTime, status, new LoggingCallback(
								"Data received successfully by server"));
			}

		});

		return submitButton;
	}

}
