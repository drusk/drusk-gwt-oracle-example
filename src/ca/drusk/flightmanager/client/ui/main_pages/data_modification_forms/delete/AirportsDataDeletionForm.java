package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.delete;

import ca.drusk.flightmanager.client.services.DataDeletionServiceAsync;
import ca.drusk.flightmanager.client.table_data.Airports;
import ca.drusk.flightmanager.client.table_data.TableNames;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.AbstractDataModificationForm;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

/**
 * UI elements for deleting locations from the database.
 * 
 * @author drusk
 * 
 */
public class AirportsDataDeletionForm extends AbstractDataModificationForm {

	private final DataDeletionServiceAsync dataDeletionService;

	public AirportsDataDeletionForm(
			DataDeletionServiceAsync dataDeletionService) {
		super(new Airports().getPrimaryKeys());
		this.dataDeletionService = dataDeletionService;
	}

	@Override
	protected String getTitle() {
		return TableNames.AIRPORTS;
	}

	@Override
	protected Button createSubmissionButton() {
		Button submitButton = new Button(DELETE);
		submitButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String airportCode = textBoxes.get(Airports.AIRPORT_CODE)
						.getText();
				dataDeletionService.removeLocation(airportCode,
						new LoggingCallback("Deletion sent to server"));
			}

		});

		return submitButton;
	}

}
