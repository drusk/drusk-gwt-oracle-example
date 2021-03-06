package ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms;

import ca.drusk.flightmanager.client.ui.custom_widgets.Log;
import ca.drusk.flightmanager.client.ui.custom_widgets.VerticalTextBoxInputForm;
import ca.drusk.flightmanager.shared.utils.HtmlBuilder;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.ScrollPanel;
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

	protected static final String DELETE = "Delete";

	protected static final String SUBMIT = "Submit Data";

	private static final int LOG_WIDTH = 300;

	private static final int LOG_HEIGHT = 150;

	private static final int TEXT_BOXES_TO_LOG_SPACING = 35;

	private static final int TEXTBOX_SPACING = 15;

	private HorizontalPanel horizontalContainer = new HorizontalPanel();

	private ScrollPanel scrollContainer = new ScrollPanel();

	protected VerticalPanel formDisplay = new VerticalPanel();

	private Log log = new Log("Log", LOG_WIDTH, LOG_HEIGHT);

	protected VerticalTextBoxInputForm inputForm;

	protected AbstractDataModificationForm() {
		formDisplay
				.add(new HtmlBuilder(getTitle()).bold().underline().asHtml());
		inputForm = new VerticalTextBoxInputForm(getInputFieldLabels());
		formDisplay.add(inputForm);
		formDisplay.add(createSubmissionButton());
		formDisplay.setSpacing(TEXTBOX_SPACING);
		horizontalContainer.add(formDisplay);
		horizontalContainer.add(log);
		horizontalContainer.setSpacing(TEXT_BOXES_TO_LOG_SPACING);
		// provides scrolling for the form
		scrollContainer.add(horizontalContainer);
	}

	/**
	 * Adds a checkbox, defaults to false.
	 * 
	 * @param caption
	 *            the text to be display with the checkbox
	 */
	protected CheckBox addCheckbox(String caption) {
		CheckBox checkbox = new CheckBox(caption);
		checkbox.setValue(false);
		formDisplay.insert(checkbox, formDisplay.getWidgetCount() - 1);
		return checkbox;
	}

	protected abstract String getTitle();

	protected abstract Button createSubmissionButton();

	protected void logMessage(String message) {
		log.addMessage(message);
	}

	protected abstract String[] getInputFieldLabels();

	protected void logErrorMessage(Throwable caught) {
		log.addMessage("An error occured while communicating with the server: "
				+ caught.getMessage());
	}

	protected void clearUI() {
		inputForm.clearTextBoxes();
	}

	@Override
	public Widget asWidget() {
		return scrollContainer;
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
			clearUI();
			logMessage(successMessage);
		}
	}

}
