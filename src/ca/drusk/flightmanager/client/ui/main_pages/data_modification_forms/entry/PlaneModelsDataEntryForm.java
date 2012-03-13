package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry;

import ca.drusk.flightmanager.client.services.DataEntryServiceAsync;
import ca.drusk.flightmanager.client.table_data.PlaneModelsFields;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.AbstractDataModificationForm;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

/**
 * UI elements for entering plane models data
 * 
 * @author drusk
 * 
 */
public class PlaneModelsDataEntryForm extends AbstractDataModificationForm {

	private final DataEntryServiceAsync dataEntryService;

	public PlaneModelsDataEntryForm(DataEntryServiceAsync dataEntryService) {
		super(new PlaneModelsFields().getFields());
		this.dataEntryService = dataEntryService;
	}

	@Override
	protected Button createSubmissionButton() {
		Button submitButton = new Button("Submit data");
		submitButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String code = textBoxes.get(PlaneModelsFields.CODE).getText();
				String capacity = textBoxes.get(PlaneModelsFields.CAPACITY)
						.getText();

				dataEntryService.addPlaneModel(code, capacity,
						new LoggingCallback(
								"Data received successfully by server"));
			}

		});

		return submitButton;
	}

}
