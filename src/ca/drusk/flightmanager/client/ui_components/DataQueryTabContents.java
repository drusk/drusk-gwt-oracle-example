package ca.drusk.flightmanager.client.ui_components;

import ca.drusk.flightmanager.client.data.Relation;
import ca.drusk.flightmanager.client.services.DataQueryServiceAsync;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DeckLayoutPanel;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Allows selection of database table to view contents of.
 * 
 * @author drusk
 * 
 */
public class DataQueryTabContents extends DockLayoutPanel {

	private double tableSelectorWidth = 100;

	private final DataQueryServiceAsync dataQueryService;

	private DeckLayoutPanel resultsDeckPanel;

	public DataQueryTabContents(DataQueryServiceAsync dataQueryService) {
		super(Unit.PX);
		this.dataQueryService = dataQueryService;
		initTableSelector();
		initResultsDeckPanel();
	}

	private void initTableSelector() {
		VerticalPanel buttonHolder = new VerticalPanel();
		Button airlinesButton = new Button("Airlines");
		buttonHolder.add(airlinesButton);
		// TODO onclick handler, show widget on
		addWest(buttonHolder, tableSelectorWidth);
	}

	private void initResultsDeckPanel() {
		resultsDeckPanel = new DeckLayoutPanel();
		dataQueryService.getAirlines(new AsyncCallback<Relation>() {

			@Override
			public void onFailure(Throwable caught) {
				resultsDeckPanel.add(new Label(
						"an error occured while communicating with the server: "
								+ caught.getMessage()));
				resultsDeckPanel.showWidget(0);
			}

			@Override
			public void onSuccess(Relation result) {
				resultsDeckPanel.add(new RelationTable(result).asWidget());
				resultsDeckPanel.showWidget(0);
			}

		});

		add(resultsDeckPanel);
	}
}
