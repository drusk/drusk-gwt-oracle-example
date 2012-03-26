package ca.drusk.flightmanager.client.ui.custom_widgets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class VerticalTextBoxInputForm implements IsWidget {

	private int DEFAULT_TEXTBOX_SPACING = 15;

	private VerticalPanel inputForm = new VerticalPanel();

	private Map<String, LabeledTextBox> textBoxes = new HashMap<String, LabeledTextBox>();

	private List<LabeledTextBox> textBoxList = new ArrayList<LabeledTextBox>();

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
	public VerticalTextBoxInputForm(String... inputFields) {
		initTextBoxes(inputFields);
		setSpacing(DEFAULT_TEXTBOX_SPACING);
	}

	private void initTextBoxes(String[] inputFields) {
		for (String field : inputFields) {
			LabeledTextBox labeledTextBox = new LabeledTextBox(field);
			textBoxes.put(field, labeledTextBox);
			textBoxList.add(labeledTextBox);
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

	public String getEnteredText(int index) {
		return textBoxList.get(index).getText();
	}

	public void setSpacing(int spacing) {
		inputForm.setSpacing(spacing);
	}

	public void addLabel(int inputIndex, String text) {
		textBoxList.get(inputIndex).insertLabel(text);
	}

	@Override
	public Widget asWidget() {
		return inputForm;
	}

}
