package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry;

import ca.drusk.flightmanager.client.services.DataEntryServiceAsync;
import ca.drusk.flightmanager.client.table_data.Airlines;
import ca.drusk.flightmanager.client.table_data.TableNames;
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
		super(new Airlines().getFields());
		this.dataEntryService = dataEntryService;
	}

	@Override
	protected Button createSubmissionButton() {
		Button submitButton = new Button(SUBMIT);
		submitButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String name = textBoxes.get(Airlines.NAME).getText();
				String code = textBoxes.get(Airlines.CODE).getText();
				String website = textBoxes.get(Airlines.WEBSITE)
						.getText();

				dataEntryService.addAirline(name, code, website,
						new LoggingCallback(
								"Data received successfully by server"));
			}

		});

		return submitButton;
	}

	@Override
	protected String getTitle() {
		return TableNames.AIRLINES;
	}

}
