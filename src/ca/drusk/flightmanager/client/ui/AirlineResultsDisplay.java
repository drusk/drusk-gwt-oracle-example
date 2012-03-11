package ca.drusk.flightmanager.client.ui;

import ca.drusk.flightmanager.client.data.Relation;
import ca.drusk.flightmanager.client.services.DataQueryServiceAsync;
import ca.drusk.flightmanager.client.ui.custom_widgets.ResultsTable;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Holds a {@link ResultsTable} and a button to refresh its contents.
 * 
 * @author drusk
 * 
 */
public class AirlineResultsDisplay implements IsWidget {

	private VerticalPanel display = new VerticalPanel();

	private ResultsTable results;

	private final DataQueryServiceAsync dataQueryService;

	private Label errorLabel;

	public AirlineResultsDisplay(DataQueryServiceAsync dataQueryService) {
		this.dataQueryService = dataQueryService;
		createRefreshButton();
		retrieveResultsAndAddToDisplay();
		display.setSpacing(10);
	}

	private void createRefreshButton() {
		Button refreshButton = new Button("Refresh");
		refreshButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				removeFromDisplayIfNotNull(errorLabel);
				removeFromDisplayIfNotNull(results);

				retrieveResultsAndAddToDisplay();
			}

		});

		display.add(refreshButton);
	}

	@Override
	public Widget asWidget() {
		return display;
	}

	private void retrieveResultsAndAddToDisplay() {
		dataQueryService.getAirlines(new AsyncCallback<Relation>() {

			@Override
			public void onFailure(Throwable caught) {
				errorLabel = new Label(
						"An error occured while communicating with the server: "
								+ caught.getMessage());
				display.add(errorLabel);
			}

			@Override
			public void onSuccess(Relation result) {
				results = new ResultsTable(result);
				display.add(results);
			}

		});
	}

	private void removeFromDisplayIfNotNull(IsWidget isWidget) {
		if (isWidget != null) {
			display.remove(isWidget);
		}
	}

}
