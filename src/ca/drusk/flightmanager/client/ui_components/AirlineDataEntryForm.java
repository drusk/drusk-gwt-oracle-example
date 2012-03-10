package ca.drusk.flightmanager.client.ui_components;

import java.util.HashMap;
import java.util.Map;

import ca.drusk.flightmanager.client.services.DataEntryServiceAsync;
import ca.drusk.flightmanager.client.table_field_constants.AirlinesFields;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Contains form for entering airline data
 * 
 * @author drusk
 * 
 */
public class AirlineDataEntryForm extends VerticalPanel {

	private Map<String, TextBox> textBoxes = new HashMap<String, TextBox>();

	private final DataEntryServiceAsync dataEntryService;

	public AirlineDataEntryForm(DataEntryServiceAsync dataEntryService) {
		this.dataEntryService = dataEntryService;
		initEntryForm();
		initDataSubmissionButton();
	}

	private void initDataSubmissionButton() {
		Button submitButton = new Button("Submit data");
		submitButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String name = textBoxes.get(AirlinesFields.NAME).getText();
				String code = textBoxes.get(AirlinesFields.CODE).getText();
				String website = textBoxes.get(AirlinesFields.WEBSITE)
						.getText();

				dataEntryService.addAirline(name, code, website,
						new AsyncCallback<Integer>() {

							@Override
							public void onFailure(Throwable caught) {
								add(new Label(
										"An error occured while communicating with the server: "
												+ caught.getMessage()));
							}

							@Override
							public void onSuccess(Integer result) {
								add(new Label(
										"Data received successfully by server"));
							}

						});
			}

		});

		add(submitButton);
	}

	private void initEntryForm() {
		for (String label : new AirlinesFields().getFields()) {
			add(new Label(label));
			TextBox textBox = new TextBox();
			add(textBox);
			textBoxes.put(label, textBox);
		}
	}

}
