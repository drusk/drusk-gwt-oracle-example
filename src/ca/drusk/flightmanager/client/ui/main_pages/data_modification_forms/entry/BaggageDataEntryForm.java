package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry;

import ca.drusk.flightmanager.client.services.DataEntryServiceAsync;
import ca.drusk.flightmanager.client.table_data.Baggage;
import ca.drusk.flightmanager.client.table_data.TableNames;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.AbstractDataModificationForm;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

/**
 * UI elements for entering baggage data.
 * 
 * @author drusk
 * 
 */
public class BaggageDataEntryForm extends AbstractDataModificationForm {

	private final DataEntryServiceAsync dataEntryService;

	public BaggageDataEntryForm(DataEntryServiceAsync dataEntryService) {
		super(new Baggage().getEntryFields());
		this.dataEntryService = dataEntryService;
	}

	@Override
	protected String getTitle() {
		return TableNames.BAGGAGE;
	}

	@Override
	protected Button createSubmissionButton() {
		Button submitButton = new Button(SUBMIT);
		submitButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String weight = inputForm.getEnteredText(Baggage.WEIGHT);
				dataEntryService.addBaggage(weight, new LoggingCallback(
						"Data received successfully by server"));
			}

		});

		return submitButton;
	}

}
