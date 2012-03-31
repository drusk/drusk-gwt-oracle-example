package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.delete;

import ca.drusk.flightmanager.client.services.DataDeletionServiceAsync;
import ca.drusk.flightmanager.client.table_data.TableNames;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.AbstractDataModificationForm;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

/**
 * UI elements for deleting plane models from the database
 * 
 * @author drusk
 * 
 */
public class PlaneModelsDataDeletionForm extends AbstractDataModificationForm {

	private final DataDeletionServiceAsync dataDeletionService;

	public PlaneModelsDataDeletionForm(
			DataDeletionServiceAsync dataDeletionService) {
		this.dataDeletionService = dataDeletionService;
	}

	@Override
	protected Button createSubmissionButton() {
		Button submitButton = new Button(DELETE);
		submitButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String code = inputForm.getEnteredText(0);
				dataDeletionService.removePlaneModel(code, new LoggingCallback(
						"Deleted plane model " + code));
			}

		});

		return submitButton;
	}

	@Override
	protected String getTitle() {
		return TableNames.PLANE_MODELS;
	}

	@Override
	protected String[] getInputFieldLabels() {
		return new String[] { "Code" };
	}

}
