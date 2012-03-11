package ca.drusk.flightmanager.client.ui.custom_widgets;

import ca.drusk.flightmanager.shared.utils.Css;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * A text area for log messages. Has a title and a button to clear its contents.
 * 
 * @author drusk
 * 
 */
public class Log implements IsWidget {

	private VerticalPanel outerContainer = new VerticalPanel();

	private TextArea logTextArea;

	private HorizontalPanel header;

	private String logContents = "";

	/**
	 * 
	 * @param title
	 *            the title to be placed at the top of the log
	 * @param width
	 *            the width of the log's text area
	 * @param height
	 *            the height of the log's text area
	 */
	public Log(String title, int width, int height) {
		createLogTextArea(width, height);
		createHeader(title, width);
		outerContainer.add(header);
		outerContainer.add(logTextArea);
	}

	private void createLogTextArea(int width, int height) {
		logTextArea = new TextArea();
		logTextArea.setReadOnly(true);
		logTextArea.setPixelSize(width, height);
	}

	private void createHeader(String title, int width) {
		header = new HorizontalPanel();

		HTML titleLabel = new HTML(title);
		Button clearButton = new Button("Clear");
		clearButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				logContents = "";
				updateLogContents();
			}

		});

		header.setWidth(Css.inPixels(width));
		header.add(titleLabel);
		header.add(clearButton);
		header.setCellHorizontalAlignment(titleLabel,
				HasHorizontalAlignment.ALIGN_LEFT);
		header.setCellHorizontalAlignment(clearButton,
				HasHorizontalAlignment.ALIGN_RIGHT);
	}

	private void updateLogContents() {
		logTextArea.setText(logContents);
	}

	/**
	 * 
	 * @param message
	 *            the message to be entered and displayed in the log.
	 */
	public void addMessage(String message) {
		if (!logContents.equals("")) {
			logContents += "\n";
		}
		logContents += message;
		updateLogContents();
	}

	@Override
	public Widget asWidget() {
		return outerContainer;
	}

}
