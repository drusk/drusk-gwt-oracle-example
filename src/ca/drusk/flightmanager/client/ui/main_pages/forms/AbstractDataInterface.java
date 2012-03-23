package ca.drusk.flightmanager.client.ui.main_pages.forms;

import java.util.ArrayList;
import java.util.List;

import ca.drusk.flightmanager.client.ui.custom_widgets.Log;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Can be extended to create UIs for entering, deleting or viewing data, and
 * also running queries that require user input.
 * 
 * @author drusk
 * 
 */
public abstract class AbstractDataInterface {

	private static final int LOG_WIDTH = 300;

	private static final int LOG_HEIGHT = 150;

	protected VerticalPanel display = new VerticalPanel();

	public abstract void communicateWithServer();

	public abstract void cleanUpUI();

	protected List<IsWidget> widgets = new ArrayList<IsWidget>();

	private Log log = new Log("Log", LOG_WIDTH, LOG_HEIGHT);

	public void logMessage(String message) {
		log.addMessage(message);
	}

	public void logErrorMessage(Throwable caught) {
		log.addMessage("An error occured while communicating with the server: "
				+ caught.getMessage());
	}

	public void addWidget(IsWidget widget) {
		widgets.add(widget);
	}

	protected void addSubmissionButton(String label) {
		Button submitButton = new Button(label);
		submitButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				communicateWithServer();
				cleanUpUI();
			}
		});

		display.add(submitButton);
	}

}
