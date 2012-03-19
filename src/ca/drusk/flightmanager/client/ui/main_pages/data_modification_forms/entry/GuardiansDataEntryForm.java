package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry;

import ca.drusk.flightmanager.client.services.DataEntryServiceAsync;
import ca.drusk.flightmanager.client.table_data.Guardians;
import ca.drusk.flightmanager.client.table_data.TableNames;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.AbstractDataModificationForm;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

/**
 * UI elements for entering guardians for infant passengers
 * 
 * @author drusk
 * 
 */
public class GuardiansDataEntryForm extends AbstractDataModificationForm {

	private final DataEntryServiceAsync dataEntryService;

	public GuardiansDataEntryForm(DataEntryServiceAsync dataEntryService) {
		super(new Guardians().getEntryFields());
		this.dataEntryService = dataEntryService;
	}

	@Override
	protected String getTitle() {
		return TableNames.GUARDIANS;
	}

	@Override
	protected Button createSubmissionButton() {
		Button submitButton = new Button(SUBMIT);
		submitButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String guardianId = getEnteredText(Guardians.GUARDIAN_ID);
				String infantId = getEnteredText(Guardians.INFANT_ID);
				dataEntryService.addGuardian(guardianId, infantId,
						new LoggingCallback(
								"Data received successfully by server"));
			}

		});

		return submitButton;
	}

}
