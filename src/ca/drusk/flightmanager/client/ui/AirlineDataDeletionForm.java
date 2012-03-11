package ca.drusk.flightmanager.client.ui;

import ca.drusk.flightmanager.client.services.DataDeletionServiceAsync;
import ca.drusk.flightmanager.client.table_field_constants.AirlinesFields;
import ca.drusk.flightmanager.client.ui.custom_widgets.LabeledTextBox;
import ca.drusk.flightmanager.client.ui.custom_widgets.Log;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Contains form for deleting airlines from the database
 * 
 * @author drusk
 * 
 */
public class AirlineDataDeletionForm implements IsWidget {

	private static final int LOG_WIDTH = 300;

	private static final int LOG_HEIGHT = 150;

	private static final int LOG_SPACING = 35;

	private static final int SPACING = 15;

	private HorizontalPanel container = new HorizontalPanel();

	private VerticalPanel formDisplay = new VerticalPanel();

	private Log log = new Log("Log", LOG_WIDTH, LOG_HEIGHT);

	private final DataDeletionServiceAsync dataDeletionService;

	private LabeledTextBox codeEntryBox;

	public AirlineDataDeletionForm(DataDeletionServiceAsync dataDeletionService) {
		this.dataDeletionService = dataDeletionService;
		initDeletionForm();
		initSubmissionButton();
		formDisplay.setSpacing(SPACING);
		container.add(formDisplay);
		container.add(log);
		container.setSpacing(LOG_SPACING);
	}

	private void initSubmissionButton() {
		Button submitButton = new Button("Delete");
		submitButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String code = codeEntryBox.getText();

				dataDeletionService.removeAirline(code,
						new AsyncCallback<Integer>() {

							@Override
							public void onSuccess(Integer result) {
								log.addMessage("Deletion sent to server");
							}

							@Override
							public void onFailure(Throwable caught) {
								// extract to superclass
								log.addMessage("An error occured while communicating with the server: "
										+ caught.getMessage());
							}
						});
			}

		});

		formDisplay.add(submitButton);
	}

	private void initDeletionForm() {
		codeEntryBox = new LabeledTextBox(AirlinesFields.CODE);
		formDisplay.add(codeEntryBox);
	}

	@Override
	public Widget asWidget() {
		return container;
	}

}
