package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.delete;

import ca.drusk.flightmanager.client.services.DataDeletionServiceAsync;
import ca.drusk.flightmanager.client.table_data.Arrivals;
import ca.drusk.flightmanager.client.table_data.FlightInstances;
import ca.drusk.flightmanager.client.table_data.TableNames;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.AbstractDataModificationForm;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

/**
 * UI elements for deleting flight arrival records from the database.
 * 
 * @author drusk
 * 
 */
public class ArrivalsDataDeletionForm extends AbstractDataModificationForm {

	private final DataDeletionServiceAsync dataDeletionService;

	public ArrivalsDataDeletionForm(DataDeletionServiceAsync dataDeletionService) {
		super(new Arrivals().getPrimaryKeys());
		this.dataDeletionService = dataDeletionService;
	}

	@Override
	protected String getTitle() {
		return TableNames.ARRIVALS;
	}

	@Override
	protected Button createSubmissionButton() {
		Button submitButton = new Button(DELETE);
		submitButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String id = getEnteredText(FlightInstances.ID);
				dataDeletionService.removeArrival(id, new LoggingCallback(
						"Deletion sent to server"));
			}

		});

		return submitButton;
	}

}
