package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry;

import ca.drusk.flightmanager.client.services.DataEntryServiceAsync;
import ca.drusk.flightmanager.client.table_data.Gates;
import ca.drusk.flightmanager.client.table_data.Locations;
import ca.drusk.flightmanager.client.table_data.TableNames;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.AbstractDataModificationForm;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

/**
 * UI elements for entering gate data.
 * 
 * @author drusk
 * 
 */
public class GateDataEntryForm extends AbstractDataModificationForm {

	private final DataEntryServiceAsync dataEntryService;

	public GateDataEntryForm(DataEntryServiceAsync dataEntryService) {
		super(new Gates().getEntryFields());
		this.dataEntryService = dataEntryService;
	}

	@Override
	protected String getTitle() {
		return TableNames.GATES;
	}

	@Override
	protected Button createSubmissionButton() {
		Button submitButton = new Button(SUBMIT);
		submitButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String gate = getEnteredText(Gates.GATE);
				String airportCode = getEnteredText(Locations.AIRPORT_CODE);
				dataEntryService.addGate(gate, airportCode,
						new LoggingCallback(
								"Data received successfully by server"));
			}

		});

		return submitButton;
	}

}
