package ca.drusk.flightmanager.client.ui.main_pages;

import ca.drusk.flightmanager.client.services.DataEntryServiceAsync;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry.AirlineDataEntryForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry.PlaneModelsDataEntryForm;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DeckLayoutPanel;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * UI components for data entry
 * 
 * @author drusk
 * 
 */
public class DataEntryTabContents implements IsWidget {

	private DockLayoutPanel dockPanel = new DockLayoutPanel(Unit.PX);

	private double tableSelectorWidth = 100;

	private final DataEntryServiceAsync dataEntryService;

	private DeckLayoutPanel formPanel;

	public DataEntryTabContents(DataEntryServiceAsync dataEntryService) {
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
		airlinesButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				formPanel.showWidget(0);
			}

		});
		buttonHolder.add(airlinesButton);

		Button planeModelsButton = new Button("Plane Models");
		planeModelsButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				formPanel.showWidget(1);
			}

		});
		buttonHolder.add(planeModelsButton);

		buttonHolder.setWidth("100%");
		buttonHolder.setHeight("100%");
		buttonHolder.setBorderWidth(1);
		dockPanel.addWest(buttonHolder, tableSelectorWidth);
	}

	private void initDataEntryForms() {
		formPanel = new DeckLayoutPanel();
		formPanel.add(new AirlineDataEntryForm(dataEntryService));
		formPanel.add(new PlaneModelsDataEntryForm(dataEntryService));

		formPanel.showWidget(0);
		dockPanel.add(formPanel);
	}

	@Override
	public Widget asWidget() {
		return dockPanel;
	}
}
