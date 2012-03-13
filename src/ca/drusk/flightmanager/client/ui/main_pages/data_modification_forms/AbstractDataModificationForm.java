package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms;

import java.util.HashMap;
import java.util.Map;

import ca.drusk.flightmanager.client.ui.custom_widgets.LabeledTextBox;
import ca.drusk.flightmanager.client.ui.custom_widgets.Log;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Contains the parts of the forms which are common to all data manipulation
 * forms.
 * 
 * @author drusk
 * 
 */
public abstract class AbstractDataModificationForm implements IsWidget {

	private static final int LOG_WIDTH = 300;

	private static final int LOG_HEIGHT = 150;

	private static final int TEXT_BOXES_TO_LOG_SPACING = 35;

	private static final int TEXTBOX_SPACING = 15;

	private HorizontalPanel container = new HorizontalPanel();

	protected VerticalPanel formDisplay = new VerticalPanel();

	private Log log = new Log("Log", LOG_WIDTH, LOG_HEIGHT);

	protected Map<String, LabeledTextBox> textBoxes = new HashMap<String, LabeledTextBox>();

	protected AbstractDataModificationForm(String... fields) {
		initTextBoxes(fields);
		formDisplay.add(createSubmissionButton());
		formDisplay.setSpacing(TEXTBOX_SPACING);
		container.add(formDisplay);
		container.add(log);
		container.setSpacing(TEXT_BOXES_TO_LOG_SPACING);
	}

	protected abstract Button createSubmissionButton();

	private void initTextBoxes(String[] fields) {
		for (String field : fields) {
			LabeledTextBox labeledTextBox = new LabeledTextBox(field);
			textBoxes.put(field, labeledTextBox);
			formDisplay.add(labeledTextBox);
		}
	}

	protected void clearTextBoxes() {
		for (LabeledTextBox textBox : textBoxes.values()) {
			textBox.clearText();
		}
	}

	protected void logMessage(String message) {
		log.addMessage(message);
	}

	protected void logErrorMessage(Throwable caught) {
		log.addMessage("An error occured while communicating with the server: "
				+ caught.getMessage());
	}

	@Override
	public Widget asWidget() {
		return container;
	}

	public final class LoggingCallback implements AsyncCallback<Integer> {
		private String successMessage;

		public LoggingCallback(String successMessage) {
			this.successMessage = successMessage;
		}

		@Override
		public void onFailure(Throwable caught) {
			logErrorMessage(caught);
		}

		@Override
		public void onSuccess(Integer result) {
			clearTextBoxes();
			logMessage(successMessage);
		}
	}

}
