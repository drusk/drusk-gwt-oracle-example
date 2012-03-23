package ca.drusk.flightmanager.client.ui.main_pages.data_display.queries;

import java.util.HashMap;
import java.util.Map;

import ca.drusk.flightmanager.client.services.FlightQueryServiceAsync;
import ca.drusk.flightmanager.client.ui.custom_widgets.LabeledTextBox;
import ca.drusk.flightmanager.client.ui.custom_widgets.TextBoxInputForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_display.AbstractDataDisplay;

import com.google.gwt.event.dom.client.ClickHandler;

/**
 * Provides common functionality for query interfaces where some input
 * parameters are collected from the user and a results table is generated.
 * 
 * @author drusk
 * 
 */
public abstract class AbstractQueryInterface extends AbstractDataDisplay {

	protected final FlightQueryServiceAsync flightQueryService;

	protected Map<String, LabeledTextBox> textBoxes = new HashMap<String, LabeledTextBox>();

	protected TextBoxInputForm inputForm;

	public AbstractQueryInterface(FlightQueryServiceAsync flightQueryService,
			String... inputFields) {
		this.flightQueryService = flightQueryService;
		this.inputForm = new TextBoxInputForm(getTitle(), "Submit",
				getInputSubmissionClickHandler(), inputFields);
		display.add(inputForm);
		// initInputFields(inputFields);
	}

	// private void initInputFields(String[] inputFields) {
	// for (String inputField : inputFields) {
	// LabeledTextBox labeledTextBox = new LabeledTextBox(inputField);
	// textBoxes.put(inputField, labeledTextBox);
	// display.add(labeledTextBox);
	// }
	//
	// display.add(createSubmissionButton());
	// }

	public abstract String getDescription();

	protected abstract ClickHandler getInputSubmissionClickHandler();

	protected abstract String getTitle();

	// protected abstract Button createSubmissionButton();

}
