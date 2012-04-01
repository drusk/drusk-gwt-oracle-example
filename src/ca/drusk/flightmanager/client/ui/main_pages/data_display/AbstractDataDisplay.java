package ca.drusk.flightmanager.client.ui.main_pages.data_display;

import java.util.ArrayList;
import java.util.List;

import ca.drusk.flightmanager.client.data.Relation;
import ca.drusk.flightmanager.client.ui.custom_widgets.ResultsTable;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Provides common functionality for all data results displays. Holds a
 * {@link ResultsTable} and a button to refresh its contents;
 * 
 * @author drusk
 * 
 */
public abstract class AbstractDataDisplay implements IsWidget {

	private ScrollPanel scrollContainer = new ScrollPanel();

	protected VerticalPanel display = new VerticalPanel();

	private List<ResultsTable> results = new ArrayList<ResultsTable>();

	private Label errorLabel;

	protected static int SPACING = 10;

	public AbstractDataDisplay() {
		display.setSpacing(SPACING);
		scrollContainer.add(display);
	}

	private void clearResults() {
		for (ResultsTable result : results) {
			display.remove(result);
		}
		results.removeAll(results);
	}

	protected abstract void retrieveResultsAndAddToDisplay();

	protected void generateResultsTable(Relation result) {
		ResultsTable resultTable = new ResultsTable(result);
		results.add(resultTable);
		display.add(resultTable);
	}

	protected void addInstructions(String instructions) {
		display.add(new HTML(instructions));
	}

	protected void createSubmitButton() {
		Button refreshButton = new Button("Submit");
		refreshButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				removeFromDisplayIfNotNull(errorLabel);
				clearResults();

				retrieveResultsAndAddToDisplay();
			}

		});

		display.add(refreshButton);
	}

	private void removeFromDisplayIfNotNull(IsWidget isWidget) {
		if (isWidget != null) {
			display.remove(isWidget);
		}
	}

	protected void generateErrorLabel(Throwable caught) {
		errorLabel = new Label(
				"An error occured while communicating with the server: "
						+ caught.getMessage());
		display.add(errorLabel);
	}

	@Override
	public Widget asWidget() {
		return scrollContainer;
	}

	public final class TableGeneratingCallback implements
			AsyncCallback<Relation> {
		@Override
		public void onFailure(Throwable caught) {
			generateErrorLabel(caught);
		}

		@Override
		public void onSuccess(Relation result) {
			generateResultsTable(result);
		}
	}

}
