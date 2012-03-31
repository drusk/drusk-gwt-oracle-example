package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry;

import ca.drusk.flightmanager.client.services.DataEntryServiceAsync;
import ca.drusk.flightmanager.client.table_data.TableNames;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.AbstractDataModificationForm;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;

/**
 * UI elements for entering passenger class data.
 * 
 * @author drusk
 * 
 */
public class PassengerClassDataEntryForm extends AbstractDataModificationForm {

	private final DataEntryServiceAsync dataEntryService;

	private CheckBox includesMealCheckbox;

	public PassengerClassDataEntryForm(DataEntryServiceAsync dataEntryService) {
		this.dataEntryService = dataEntryService;
		includesMealCheckbox = addCheckbox("Includes meal");
	}

	@Override
	public void clearUI() {
		inputForm.clearTextBoxes();
		includesMealCheckbox.setValue(false);
	}

	private String getCheckboxResponse(CheckBox checkbox) {
		if (checkbox.getValue()) {
			return "y";
		} else {
			return "n";
		}
	}

	@Override
	protected String getTitle() {
		return TableNames.PASSENGER_CLASS;
	}

	@Override
	protected Button createSubmissionButton() {
		Button submitButton = new Button(SUBMIT);
		submitButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String travelClass = inputForm.getEnteredText(0);
				String includesMeal = getCheckboxResponse(includesMealCheckbox);

				dataEntryService.addPassengerClass(travelClass, includesMeal,
						new LoggingCallback("Added passenger class: "
								+ travelClass));
			}

		});

		return submitButton;
	}

	@Override
	protected String[] getInputFieldLabels() {
		return new String[] { "Travel class (1 character)" };
	}

}
