package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry;

import ca.drusk.flightmanager.client.services.DataEntryServiceAsync;
import ca.drusk.flightmanager.client.table_data.TableNames;
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
		this.dataEntryService = dataEntryService;
	}

	@Override
	protected Button createSubmissionButton() {
		Button submitButton = new Button(SUBMIT);
		submitButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String code = inputForm.getEnteredText(0);
				String name = inputForm.getEnteredText(1);
				String capacity = inputForm.getEnteredText(2);

				dataEntryService.addPlaneModel(code, name, capacity,
						new LoggingCallback("Added plane model " + code));
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
		return new String[] { "Code", "Name", "Capacity" };
	}

}
