package ca.drusk.flightmanager.client.ui.main_pages.forms;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Adds a log message for the caller.
 * 
 * @author drusk
 * 
 */
public class LoggingCallback implements AsyncCallback<Integer> {

	private final AbstractDataInterface dataInterface;

	private final String successMessage;

	public LoggingCallback(String successMessage,
			AbstractDataInterface dataInterface) {
		this.successMessage = successMessage;
		this.dataInterface = dataInterface;
	}

	@Override
	public void onFailure(Throwable caught) {
		dataInterface.logErrorMessage(caught);
	}

	@Override
	public void onSuccess(Integer result) {
		dataInterface.cleanUpUI();
		dataInterface.logMessage(successMessage);
	}
}
