package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry;

import ca.drusk.flightmanager.client.services.DataEntryServiceAsync;
import ca.drusk.flightmanager.client.table_data.Locations;
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
public class LocationsDataEntryForm extends AbstractDataModificationForm {

	private final DataEntryServiceAsync dataEntryService;

	public LocationsDataEntryForm(DataEntryServiceAsync dataEntryService) {
		super(new Locations().getFields());
		this.dataEntryService = dataEntryService;
	}

	@Override
	protected String getTitle() {
		return TableNames.LOCATIONS;
	}

	@Override
	protected Button createSubmissionButton() {
		Button submitButton = new Button(SUBMIT);
		submitButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String airportCode = textBoxes.get(Locations.AIRPORT_CODE)
						.getText();
				String city = textBoxes.get(Locations.CITY).getText();
				String country = textBoxes.get(Locations.COUNTRY).getText();
				int utcOffset = Integer.parseInt(textBoxes.get(
						Locations.UTC_OFFSET).getText());
				dataEntryService.addLocation(airportCode, city, country,
						utcOffset, new LoggingCallback(
								"Data received successfully by server"));
			}

		});

		return submitButton;
	}

}
