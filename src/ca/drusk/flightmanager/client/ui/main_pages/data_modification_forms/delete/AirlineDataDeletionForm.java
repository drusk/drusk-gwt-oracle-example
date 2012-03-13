package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.delete;

import ca.drusk.flightmanager.client.services.DataDeletionServiceAsync;
import ca.drusk.flightmanager.client.table_data.AirlinesFields;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.AbstractDataModificationForm;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

/**
 * UI elements for deleting airlines from the database
 * 
 * @author drusk
 * 
 */
public class AirlineDataDeletionForm extends AbstractDataModificationForm {

	private final DataDeletionServiceAsync dataDeletionService;

	public AirlineDataDeletionForm(DataDeletionServiceAsync dataDeletionService) {
		super(new AirlinesFields().getPrimaryKey());
		this.dataDeletionService = dataDeletionService;
	}

	@Override
	protected Button createSubmissionButton() {
		Button submitButton = new Button("Delete");
		submitButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String code = textBoxes.get(AirlinesFields.CODE).getText();

				dataDeletionService.removeAirline(code, new LoggingCallback(
						"Deletion sent to server"));
			}

		});

		return submitButton;
	}

}
