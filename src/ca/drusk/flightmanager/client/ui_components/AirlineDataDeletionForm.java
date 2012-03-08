package ca.drusk.flightmanager.client.ui_components;

import ca.drusk.flightmanager.client.services.DataDeletionServiceAsync;
import ca.drusk.flightmanager.client.table_field_constants.AirlinesFields;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Contains form for deleting airlines from the database
 * 
 * @author drusk
 * 
 */
public class AirlineDataDeletionForm extends VerticalPanel {

	private final DataDeletionServiceAsync dataDeletionService;

	private TextBox codeEntryBox;

	public AirlineDataDeletionForm(DataDeletionServiceAsync dataDeletionService) {
		this.dataDeletionService = dataDeletionService;
		initDeletionForm();
		initSubmissionButton();
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
								add(new Label("Deletion sent to server"));
							}

							@Override
							public void onFailure(Throwable caught) {
								// extract to superclass
								add(new Label(
										"An error occured while communicating with the server: "
												+ caught.getMessage()));
							}
						});
			}

		});

		add(submitButton);
	}

	private void initDeletionForm() {
		add(new Label(AirlinesFields.CODE));
		codeEntryBox = new TextBox();
		add(codeEntryBox);
	}

}
