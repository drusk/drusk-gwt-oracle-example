package ca.drusk.flightmanager.client.ui.custom_widgets;

import java.util.HashMap;
import java.util.Map;

import ca.drusk.flightmanager.shared.utils.HtmlBuilder;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Form for entering text using {@link LabeledTextBox} and submitting with a
 * button click.
 * 
 * @author drusk
 * 
 */
public class TextBoxInputForm implements IsWidget {

	private int DEFAULT_TEXTBOX_SPACING = 15;

	private VerticalPanel inputForm = new VerticalPanel();

	private Map<String, LabeledTextBox> textBoxes = new HashMap<String, LabeledTextBox>();

	/**
	 * Creates a vertical panel with {@link LabeledTextBox}s for input.
	 * 
	 * @param buttonLabel
	 *            the message to be displayed on the UI input submission button
	 * @param clickHandler
	 *            specifies what to do with the input data when the submission
	 *            button is clicked
	 * @param inputFields
	 *            the names of the input fields to display
	 */
	public TextBoxInputForm(String title, String buttonLabel,
			ClickHandler clickHandler, String... inputFields) {
		addTitle(title);
		initTextBoxes(inputFields);
		initSubmissionButton(buttonLabel, clickHandler);
		setSpacing(DEFAULT_TEXTBOX_SPACING);
	}

	private void addTitle(String title) {
		inputForm.add(new HtmlBuilder(title).bold().underline().asHtml());
	}

	private void initSubmissionButton(String buttonLabel,
			ClickHandler clickHandler) {
		Button submitButton = new Button(buttonLabel);
		submitButton.addClickHandler(clickHandler);
		inputForm.add(submitButton);
	}

	private void initTextBoxes(String[] inputFields) {
		for (String field : inputFields) {
			LabeledTextBox labeledTextBox = new LabeledTextBox(field);
			textBoxes.put(field, labeledTextBox);
			inputForm.add(labeledTextBox);
		}
	}

	public void clearTextBoxes() {
		for (LabeledTextBox textBox : textBoxes.values()) {
			textBox.clearText();
		}
	}

	public String getEnteredText(String textbox) {
		return textBoxes.get(textbox).getText();
	}

	public void setSpacing(int spacing) {
		inputForm.setSpacing(spacing);
	}

	@Override
	public Widget asWidget() {
		return inputForm;
	}

}
