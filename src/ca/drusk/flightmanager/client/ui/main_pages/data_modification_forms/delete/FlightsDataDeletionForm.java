package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.delete;

import ca.drusk.flightmanager.client.services.DataDeletionServiceAsync;
import ca.drusk.flightmanager.client.table_data.AllFlights;
import ca.drusk.flightmanager.client.table_data.Flights;
import ca.drusk.flightmanager.client.table_data.TableNames;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.AbstractDataModificationForm;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

/**
 * UI elements for deleting flights from the database.
 * 
 * @author drusk
 * 
 */
public class FlightsDataDeletionForm extends AbstractDataModificationForm {

	private final DataDeletionServiceAsync dataDeletionService;

	public FlightsDataDeletionForm(DataDeletionServiceAsync dataDeletionService) {
		super(new AllFlights().getPrimaryKey());
		this.dataDeletionService = dataDeletionService;
	}

	@Override
	protected String getTitle() {
		return TableNames.FLIGHTS;
	}

	@Override
	protected Button createSubmissionButton() {
		Button submitButton = new Button(DELETE);
		submitButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String flightNumber = getEnteredText(Flights.FLIGHT_NUMBER);
				dataDeletionService.removeFlight(flightNumber,
						new LoggingCallback("Deleted flight (" + flightNumber
								+ ")"));
			}

		});

		return submitButton;
	}

}
