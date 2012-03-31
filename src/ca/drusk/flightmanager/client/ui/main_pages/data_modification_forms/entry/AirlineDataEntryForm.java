package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry;

import ca.drusk.flightmanager.client.services.DataEntryServiceAsync;
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
		this.dataEntryService = dataEntryService;
	}

	@Override
	protected Button createSubmissionButton() {
		Button submitButton = new Button(SUBMIT);
		submitButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String name = inputForm.getEnteredText(0);
				String code = inputForm.getEnteredText(1);
				String website = inputForm.getEnteredText(2);

				dataEntryService.addAirline(name, code, website,
						new LoggingCallback("Added airline " + name + " ("
								+ code + ")"));
			}

		});

		return submitButton;
	}

	@Override
	protected String getTitle() {
		return TableNames.AIRLINES;
	}

	@Override
	protected String[] getInputFieldLabels() {
		return new String[] { "Name", "Code (2 characters)", "Website" };
	}

}
