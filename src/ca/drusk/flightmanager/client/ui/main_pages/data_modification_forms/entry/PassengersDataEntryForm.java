package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry;

import ca.drusk.flightmanager.client.services.DataEntryServiceAsync;
import ca.drusk.flightmanager.client.table_data.TableNames;
import ca.drusk.flightmanager.client.ui.custom_widgets.LabeledTextBox;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.AbstractDataModificationForm;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;

/**
 * UI elements for entering passenger data.
 * 
 * @author drusk
 * 
 */
public class PassengersDataEntryForm extends AbstractDataModificationForm {

	private final DataEntryServiceAsync dataEntryService;

	private CheckBox airlineEmployeeCheckbox;

	private CheckBox doctorCheckbox;

	private CheckBox infantCheckbox;

	private LabeledTextBox guardianInput;

	public PassengersDataEntryForm(DataEntryServiceAsync dataEntryService) {
		this.dataEntryService = dataEntryService;
		inputForm.addLabel(4, "(should be in form 'MON DD, YYYY'");
		inputForm.addLabel(4, "ex: 'Sep 22, 1990')");
		initCheckboxes();
	}

	@Override
	public void clearUI() {
		inputForm.clearTextBoxes();
		airlineEmployeeCheckbox.setValue(false);
		doctorCheckbox.setValue(false);
		infantCheckbox.setValue(false);
		guardianInput.clearText();
	}

	private void initCheckboxes() {
		airlineEmployeeCheckbox = addCheckbox("Is an airline employee");
		doctorCheckbox = addCheckbox("Is a doctor");
		infantCheckbox = addCheckbox("Is an infant");

		guardianInput = new LabeledTextBox("Guardian's id");

		infantCheckbox.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (infantCheckbox.getValue()) {
					formDisplay.insert(guardianInput,
							formDisplay.getWidgetCount() - 1);
				} else {
					formDisplay.remove(guardianInput);
				}
			}
		});
	}

	@Override
	protected String getTitle() {
		return TableNames.PASSENGERS;
	}

	private String getCheckboxResponse(CheckBox checkbox) {
		if (checkbox.getValue()) {
			return "y";
		} else {
			return "n";
		}
	}

	@Override
	protected Button createSubmissionButton() {
		Button submitButton = new Button(SUBMIT);
		submitButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String firstName = inputForm.getEnteredText(0);
				String lastName = inputForm.getEnteredText(1);
				String citizenship = inputForm.getEnteredText(2);
				String placeOfBirth = inputForm.getEnteredText(3);
				String dateOfBirth = inputForm.getEnteredText(4);
				String dietaryRestrictions = inputForm.getEnteredText(5);
				String medicalConsiderations = inputForm.getEnteredText(6);
				String isAirlineEmployee = getCheckboxResponse(airlineEmployeeCheckbox);
				String isDoctor = getCheckboxResponse(doctorCheckbox);
				String isInfact = getCheckboxResponse(infantCheckbox);
				String guardian = infantCheckbox.getValue() ? guardianInput
						.getText() : null;

				dataEntryService.addPassenger(firstName, lastName, citizenship,
						placeOfBirth, dateOfBirth, dietaryRestrictions,
						medicalConsiderations, isAirlineEmployee, isDoctor,
						isInfact, guardian,
						new LoggingCallback("Added passenger " + firstName
								+ " " + lastName));
			}

		});

		return submitButton;
	}

	@Override
	protected String[] getInputFieldLabels() {
		return new String[] { "First name", "Last name", "Citizenship",
				"Place of birth", "Date of birth",
				"Description of dietary restrictions",
				"Description of medical considerations" };
	}

}
