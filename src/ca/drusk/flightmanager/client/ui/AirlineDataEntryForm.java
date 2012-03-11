package ca.drusk.flightmanager.client.ui;

import java.util.HashMap;
import java.util.Map;

import ca.drusk.flightmanager.client.services.DataEntryServiceAsync;
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
 * Contains form for entering airline data
 * 
 * @author drusk
 * 
 */
public class AirlineDataEntryForm implements IsWidget {

	private static final int LOG_WIDTH = 300;

	private static final int LOG_HEIGHT = 150;

	private static final int LOG_SPACING = 35;

	private static final int TEXTBOX_SPACING = 15;

	private HorizontalPanel container = new HorizontalPanel();

	private VerticalPanel formDisplay = new VerticalPanel();

	private Log log = new Log("Log", LOG_WIDTH, LOG_HEIGHT);

	private Map<String, LabeledTextBox> textBoxes = new HashMap<String, LabeledTextBox>();

	private final DataEntryServiceAsync dataEntryService;

	public AirlineDataEntryForm(DataEntryServiceAsync dataEntryService) {
		this.dataEntryService = dataEntryService;
		initEntryForm();
		initDataSubmissionButton();
		formDisplay.setSpacing(TEXTBOX_SPACING);
		container.add(formDisplay);
		container.add(log);
		container.setSpacing(LOG_SPACING);
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
								log.addMessage("An error occured while communicating with the server: "
										+ caught.getMessage());
							}

							@Override
							public void onSuccess(Integer result) {
								clearTextBoxes();
								log.addMessage("Data received successfully by server");
							}

						});
			}

		});

		formDisplay.add(submitButton);
	}

	private void clearTextBoxes() {
		for (LabeledTextBox textBox : textBoxes.values()) {
			textBox.clearText();
		}
	}

	private void initEntryForm() {
		for (String label : new AirlinesFields().getFields()) {
			LabeledTextBox labeledTextBox = new LabeledTextBox(label);
			textBoxes.put(label, labeledTextBox);
			formDisplay.add(labeledTextBox);
		}
	}

	@Override
	public Widget asWidget() {
		return container;
	}

}
