package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry;

import ca.drusk.flightmanager.client.services.DataEntryServiceAsync;
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
				String airportCode = inputForm.getEnteredText(0);
				String city = inputForm.getEnteredText(1);
				String country = inputForm.getEnteredText(2);
				String utcOffset = inputForm.getEnteredText(3);
				dataEntryService.addAirport(airportCode, city, country,
						utcOffset, new LoggingCallback(
								"Added airport with code " + airportCode));
			}

		});

		return submitButton;
	}

	@Override
	protected String[] getInputFieldLabels() {
		return new String[] { "Airport code (3 characters)", "City", "Country",
				"UTC Offset (ex: +08:00)" };
	}
}
