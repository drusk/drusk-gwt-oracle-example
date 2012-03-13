package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.delete;

import ca.drusk.flightmanager.client.services.DataDeletionServiceAsync;
import ca.drusk.flightmanager.client.table_data.PlaneModelsFields;
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
		super(new PlaneModelsFields().getPrimaryKey());
		this.dataDeletionService = dataDeletionService;
	}

	@Override
	protected Button createSubmissionButton() {
		Button submitButton = new Button("Delete");
		submitButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String code = textBoxes.get(PlaneModelsFields.CODE).getText();
				dataDeletionService.removePlaneModel(code, new LoggingCallback(
						"Deletion sent to server"));
			}

		});

		return submitButton;
	}

}
