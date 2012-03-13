package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry;

import ca.drusk.flightmanager.client.services.DataEntryServiceAsync;
import ca.drusk.flightmanager.client.table_data.AirlinesFields;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.AbstractDataModificationForm;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

/**
 * UI elements for entering airline data
 * 
 * @author drusk
 * 
 */
public class AirlineDataEntryForm extends AbstractDataModificationForm {

	private final DataEntryServiceAsync dataEntryService;

	public AirlineDataEntryForm(DataEntryServiceAsync dataEntryService) {
		super(new AirlinesFields().getFields());
		this.dataEntryService = dataEntryService;
	}

	@Override
	protected Button createSubmissionButton() {
		Button submitButton = new Button("Submit data");
		submitButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String name = textBoxes.get(AirlinesFields.NAME).getText();
				String code = textBoxes.get(AirlinesFields.CODE).getText();
				String website = textBoxes.get(AirlinesFields.WEBSITE)
						.getText();

				dataEntryService.addAirline(name, code, website,
						new LoggingCallback(
								"Data received successfully by server"));
			}

		});

		return submitButton;
	}

}
