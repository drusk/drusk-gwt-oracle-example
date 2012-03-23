package ca.drusk.flightmanager.client.ui.main_pages.forms;

import ca.drusk.flightmanager.client.data.Relation;
import ca.drusk.flightmanager.client.ui.custom_widgets.ResultsTable;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Generates a {@link ResultsTable} for the caller.
 * 
 * @author drusk
 * 
 */
public class TableGeneratingCallback implements AsyncCallback<Relation> {

	private final AbstractDataInterface dataInterface;

	public TableGeneratingCallback(AbstractDataInterface dataInterface) {
		this.dataInterface = dataInterface;
	}

	@Override
	public void onFailure(Throwable caught) {
	}

	@Override
	public void onSuccess(Relation result) {
		dataInterface.addWidget(new ResultsTable(result));
	}

}
