package ca.drusk.flightmanager.client.ui.custom_widgets;

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

	private Label label;

	private TextBox textBox = new TextBox();

	public LabeledTextBox(String textLabel) {
		init(textLabel);
	}

	private void init(String textLabel) {
		label = new Label(textLabel);

		container.add(label);
		container.add(textBox);

		container.setSpacing(0);
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
