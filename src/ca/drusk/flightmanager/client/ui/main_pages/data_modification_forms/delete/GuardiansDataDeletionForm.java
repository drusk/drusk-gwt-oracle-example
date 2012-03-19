package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.delete;

import ca.drusk.flightmanager.client.services.DataDeletionServiceAsync;
import ca.drusk.flightmanager.client.table_data.Guardians;
import ca.drusk.flightmanager.client.table_data.TableNames;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.AbstractDataModificationForm;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

/**
 * UI elements for deleting guardians from the database.
 * 
 * @author drusk
 * 
 */
public class GuardiansDataDeletionForm extends AbstractDataModificationForm {

	private final DataDeletionServiceAsync dataDeletionService;

	public GuardiansDataDeletionForm(
			DataDeletionServiceAsync dataDeletionService) {
		super(new Guardians().getPrimaryKeyAttributes());
		this.dataDeletionService = dataDeletionService;
	}

	@Override
	protected String getTitle() {
		return TableNames.GUARDIANS;
	}

	@Override
	protected Button createSubmissionButton() {
		Button submitButton = new Button(DELETE);
		submitButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String guardianId = getEnteredText(Guardians.GUARDIAN_ID);
				String infantId = getEnteredText(Guardians.INFANT_ID);
				dataDeletionService.removeGuardian(guardianId, infantId,
						new LoggingCallback("Deletion sent to server"));
			}

		});

		return submitButton;
	}

}
