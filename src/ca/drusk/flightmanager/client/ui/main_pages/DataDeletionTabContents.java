package ca.drusk.flightmanager.client.ui.main_pages;

import ca.drusk.flightmanager.client.services.DataDeletionServiceAsync;
import ca.drusk.flightmanager.client.ui.AirlineDataDeletionForm;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DeckLayoutPanel;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Allows selection of table to delete from, and holds forms for making
 * deletions
 * 
 * @author drusk
 * 
 */
public class DataDeletionTabContents implements IsWidget {

	private DockLayoutPanel dockPanel = new DockLayoutPanel(Unit.PX);

	private double tableSelectorWidth = 100;

	private final DataDeletionServiceAsync dataDeletionService;

	private DeckLayoutPanel formPanel;

	public DataDeletionTabContents(DataDeletionServiceAsync dataDeletionService) {
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
		buttonHolder.setWidth("100%");
		buttonHolder.setHeight("100%");
		buttonHolder.setBorderWidth(1);
		dockPanel.addWest(buttonHolder, tableSelectorWidth);
	}

	private void initDataDeletionForms() {
		formPanel = new DeckLayoutPanel();
		formPanel.add(new AirlineDataDeletionForm(dataDeletionService));

		formPanel.showWidget(0);
		dockPanel.add(formPanel);
	}

	@Override
	public Widget asWidget() {
		return dockPanel;
	}

}
