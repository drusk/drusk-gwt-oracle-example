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

	public PassengersDataEntryForm(DataEntryServiceAsync dataEntryService) {
		super(new Passengers().getEntryFields());
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
				String firstName = getEnteredText(Passengers.FIRST_NAME);
				String lastName = getEnteredText(Passengers.LAST_NAME);
				String citizenship = getEnteredText(Citizenships.CITIZENSHIP);
				String placeOfBirth = getEnteredText(Passengers.PLACE_OF_BIRTH);
				String dateOfBirth = getEnteredText(Passengers.DATE_OF_BIRTH);

				dataEntryService.addPassenger(firstName, lastName, citizenship,
						placeOfBirth, dateOfBirth, new LoggingCallback(
								"Data received successfully by server"));
			}

		});

		return submitButton;
	}

}
