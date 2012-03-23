package ca.drusk.flightmanager.client.ui.main_pages.data_display.queries;

import java.util.HashMap;
import java.util.Map;

import ca.drusk.flightmanager.client.services.FlightQueryServiceAsync;
import ca.drusk.flightmanager.client.ui.custom_widgets.LabeledTextBox;
import ca.drusk.flightmanager.client.ui.custom_widgets.TextBoxInputForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_display.AbstractDataDisplay;

import com.google.gwt.user.client.ui.HTML;

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
		display.add(new HTML(getInstructions()));
		this.flightQueryService = flightQueryService;
		this.inputForm = new TextBoxInputForm(inputFields);
		display.add(inputForm);
		createSubmitButton();
	}

	public abstract String getShortDescription();

	protected abstract String getInstructions();

}
