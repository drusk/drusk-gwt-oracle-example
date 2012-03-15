package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.delete;

import ca.drusk.flightmanager.client.services.DataDeletionServiceAsync;
import ca.drusk.flightmanager.client.table_data.Citizenships;
import ca.drusk.flightmanager.client.table_data.TableNames;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.AbstractDataModificationForm;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

/**
 * UI elements for deleting citizenships from the database.
 * 
 * @author drusk
 * 
 */
public class CitizenshipsDataDeletionForm extends AbstractDataModificationForm {

	private final DataDeletionServiceAsync dataDeletionService;

	public CitizenshipsDataDeletionForm(
			DataDeletionServiceAsync dataDeletionService) {
		super(new Citizenships().getPrimaryKey());
		this.dataDeletionService = dataDeletionService;
	}

	@Override
	protected String getTitle() {
		return TableNames.CITIZENSHIPS;
	}

	@Override
	protected Button createSubmissionButton() {
		Button submitButton = new Button(DELETE);
		submitButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String citizenship = textBoxes.get(
						Citizenships.CITIZENSHIP).getText();
				dataDeletionService.removeCitizenship(citizenship,
						new LoggingCallback("Deletion sent to server"));
			}

		});

		return submitButton;
	}

}
