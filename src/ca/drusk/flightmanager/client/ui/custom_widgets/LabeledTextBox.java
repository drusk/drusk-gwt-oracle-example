package ca.drusk.flightmanager.client.ui.custom_widgets;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Allows the easy creation of a text box with a label on top, such as is
 * required for data entry forms.
 * 
 * @author drusk
 * 
 */
public class LabeledTextBox implements IsWidget {

	private VerticalPanel container = new VerticalPanel();

	private List<Label> labels = new ArrayList<Label>();

	private TextBox textBox = new TextBox();

	public LabeledTextBox(String... textLabels) {
		for (String textLabel : textLabels) {
			Label label = new Label(textLabel);
			container.add(label);
			labels.add(label);
		}
		container.add(textBox);
		container.setSpacing(0);
	}

	/**
	 * Adds an additional label above the text box. It will be placed below the
	 * existing labels, right above the text field.
	 * 
	 * @param text
	 *            the text for the new label.
	 */
	public void insertLabel(String text) {
		Label label = new Label(text);
		container.insert(label, labels.size());
		labels.add(label);
	}

	/**
	 * 
	 * @return the text currently entered in the text box.
	 */
	public String getText() {
		return textBox.getText();
	}

	/**
	 * Clears the text from this text box.
	 */
	public void clearText() {
		textBox.setText("");
	}

	@Override
	public Widget asWidget() {
		return container;
	}

}
