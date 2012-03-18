package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry;

import ca.drusk.flightmanager.client.services.DataEntryServiceAsync;
import ca.drusk.flightmanager.client.table_data.Airports;
import ca.drusk.flightmanager.client.table_data.TableNames;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.AbstractDataModificationForm;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

/**
 * UI elements for entering location data.
 * 
 * @author drusk
 * 
 */
public class AirportsDataEntryForm extends AbstractDataModificationForm {

	private final DataEntryServiceAsync dataEntryService;

	public AirportsDataEntryForm(DataEntryServiceAsync dataEntryService) {
		super(new Airports().getEntryFields());
		this.dataEntryService = dataEntryService;
	}

	@Override
	protected String getTitle() {
		return TableNames.AIRPORTS;
	}

	@Override
	protected Button createSubmissionButton() {
		Button submitButton = new Button(SUBMIT);
		submitButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String airportCode = textBoxes.get(Airports.AIRPORT_CODE)
						.getText();
				String city = textBoxes.get(Airports.CITY).getText();
				String country = textBoxes.get(Airports.COUNTRY).getText();
				int utcOffset = Integer.parseInt(textBoxes.get(
						Airports.UTC_OFFSET).getText());
				dataEntryService.addAirport(airportCode, city, country,
						utcOffset, new LoggingCallback(
								"Data received successfully by server"));
			}

		});

		return submitButton;
	}

}