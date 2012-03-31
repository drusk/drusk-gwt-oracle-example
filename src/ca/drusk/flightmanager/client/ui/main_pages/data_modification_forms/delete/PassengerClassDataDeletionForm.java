package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.delete;

import ca.drusk.flightmanager.client.services.DataDeletionServiceAsync;
import ca.drusk.flightmanager.client.table_data.TableNames;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.AbstractDataModificationForm;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

/**
 * UI elements for deleting passenger classes.
 * 
 * @author drusk
 * 
 */
public class PassengerClassDataDeletionForm extends
		AbstractDataModificationForm {

	private final DataDeletionServiceAsync dataDeletionService;

	public PassengerClassDataDeletionForm(
			DataDeletionServiceAsync dataDeletionService) {
		this.dataDeletionService = dataDeletionService;
	}

	@Override
	protected String getTitle() {
		return TableNames.PASSENGER_CLASS;
	}

	@Override
	protected Button createSubmissionButton() {
		Button submitButton = new Button(DELETE);
		submitButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String passengerClass = inputForm.getEnteredText(0);
				dataDeletionService.removePassengerClass(passengerClass,
						new LoggingCallback("Deleted passenger class: "
								+ passengerClass));
			}

		});

		return submitButton;
	}

	@Override
	protected String[] getInputFieldLabels() {
		return new String[] { "Passenger class" };
	}

}
