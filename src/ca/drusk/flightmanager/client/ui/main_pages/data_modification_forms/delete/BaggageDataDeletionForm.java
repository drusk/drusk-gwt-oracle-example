package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.delete;

import ca.drusk.flightmanager.client.services.DataDeletionServiceAsync;
import ca.drusk.flightmanager.client.table_data.Baggage;
import ca.drusk.flightmanager.client.table_data.TableNames;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.AbstractDataModificationForm;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

/**
 * UI elements for deleting baggage from the database.
 * 
 * @author drusk
 * 
 */
public class BaggageDataDeletionForm extends AbstractDataModificationForm {

	private final DataDeletionServiceAsync dataDeletionService;

	public BaggageDataDeletionForm(DataDeletionServiceAsync dataDeletionService) {
		super(new Baggage().getPrimaryKeyAttributes());
		this.dataDeletionService = dataDeletionService;
	}

	@Override
	protected String getTitle() {
		return TableNames.BAGGAGE;
	}

	@Override
	protected Button createSubmissionButton() {
		Button submitButton = new Button(DELETE);
		submitButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String id = inputForm.getEnteredText(Baggage.ID);
				dataDeletionService.removeBaggage(id, new LoggingCallback(
						"Deletion sent to server"));
			}

		});

		return submitButton;
	}

}
