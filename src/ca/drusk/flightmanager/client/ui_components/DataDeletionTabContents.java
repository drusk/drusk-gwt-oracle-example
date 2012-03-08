package ca.drusk.flightmanager.client.ui_components;

import ca.drusk.flightmanager.client.services.DataDeletionServiceAsync;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DeckLayoutPanel;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Allows selection of table to delete from, and holds forms for making
 * deletions
 * 
 * @author drusk
 * 
 */
public class DataDeletionTabContents extends DockLayoutPanel {

	private double tableSelectorWidth = 100;

	private final DataDeletionServiceAsync dataDeletionService;

	private DeckLayoutPanel formPanel;

	public DataDeletionTabContents(DataDeletionServiceAsync dataDeletionService) {
		super(Unit.PX);
		this.dataDeletionService = dataDeletionService;
		// TODO
		// Widget dataDeletionForm = initDataDeletionForms();
		// // Connects buttons to above forms
		// Widget tableSelector = initTableSelector();
		// addWest(tableSelector);
		// add(dataEntryForms);
		initTableSelector();
		initDataDeletionForms();
	}

	private void initTableSelector() {
		VerticalPanel buttonHolder = new VerticalPanel();
		Button airlinesButton = new Button("Airlines");
		buttonHolder.add(airlinesButton);
		// TODO onclick handler, show widget on
		addWest(buttonHolder, tableSelectorWidth);
	}

	private void initDataDeletionForms() {
		formPanel = new DeckLayoutPanel();
		formPanel.add(new AirlineDataDeletionForm(dataDeletionService));

		formPanel.showWidget(0);
		add(formPanel);
	}

}
