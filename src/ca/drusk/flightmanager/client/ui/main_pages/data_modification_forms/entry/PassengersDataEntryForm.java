package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry;

import ca.drusk.flightmanager.client.services.DataEntryServiceAsync;
import ca.drusk.flightmanager.client.table_data.Citizenships;
import ca.drusk.flightmanager.client.table_data.Passengers;
import ca.drusk.flightmanager.client.table_data.TableNames;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.AbstractDataModificationForm;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

/**
 * UI elements for entering passenger data.
 * 
 * @author drusk
 * 
 */
public class PassengersDataEntryForm extends AbstractDataModificationForm {

	private final DataEntryServiceAsync dataEntryService;

	// private CheckBox infantCheckbox;

	public PassengersDataEntryForm(DataEntryServiceAsync dataEntryService) {
		super(new Passengers().getEntryFields());
		// infantCheckbox = addCheckbox(Passengers.INFANT);
		this.dataEntryService = dataEntryService;
	}

	@Override
	protected String getTitle() {
		return TableNames.PASSENGERS;
	}

	@Override
	protected Button createSubmissionButton() {
		Button submitButton = new Button(SUBMIT);
		submitButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String firstName = inputForm
						.getEnteredText(Passengers.FIRST_NAME);
				String lastName = inputForm
						.getEnteredText(Passengers.LAST_NAME);
				String citizenship = inputForm
						.getEnteredText(Citizenships.CITIZENSHIP);
				String placeOfBirth = inputForm
						.getEnteredText(Passengers.PLACE_OF_BIRTH);
				String dateOfBirth = inputForm
						.getEnteredText(Passengers.DATE_OF_BIRTH);

				// boolean isInfant = infantCheckbox.getValue();

				dataEntryService.addPassenger(firstName, lastName, citizenship,
						placeOfBirth, dateOfBirth, new LoggingCallback(
								"Data received successfully by server"));
			}

		});

		return submitButton;
	}

}
