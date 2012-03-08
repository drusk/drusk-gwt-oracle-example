package ca.drusk.flightmanager.client.ui_components;

import ca.drusk.flightmanager.client.services.DataEntryServiceAsync;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DeckLayoutPanel;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * UI components for data entry
 * 
 * @author drusk
 * 
 */
public class DataEntryTabContents extends DockLayoutPanel {

	private double tableSelectorWidth = 100;

	private final DataEntryServiceAsync dataEntryService;

	private DeckLayoutPanel formPanel;

	public DataEntryTabContents(DataEntryServiceAsync dataEntryService) {
		super(Unit.PX);
		this.dataEntryService = dataEntryService;
		// TODO
		// Widget dataEntryForm = initDataEntryForms();
		// // Connects buttons to above forms
		// Widget tableSelector = initTableSelector();
		// addWest(tableSelector);
		// add(dataEntryForms);
		initTableSelector();
		initDataEntryForms();
	}

	private void initTableSelector() {
		VerticalPanel buttonHolder = new VerticalPanel();
		Button airlinesButton = new Button("Airlines");
		buttonHolder.add(airlinesButton);
		// TODO onclick handler, show widget on
		addWest(buttonHolder, tableSelectorWidth);
	}

	private void initDataEntryForms() {
		formPanel = new DeckLayoutPanel();
		formPanel.add(new AirlineDataEntryForm(dataEntryService));

		formPanel.showWidget(0);
		add(formPanel);
	}
}
