package ca.drusk.flightmanager.client;

import ca.drusk.flightmanager.client.services.DataDeletionService;
import ca.drusk.flightmanager.client.services.DataDeletionServiceAsync;
import ca.drusk.flightmanager.client.services.DataEntryService;
import ca.drusk.flightmanager.client.services.DataEntryServiceAsync;
import ca.drusk.flightmanager.client.services.DataQueryService;
import ca.drusk.flightmanager.client.services.DataQueryServiceAsync;
import ca.drusk.flightmanager.client.ui_components.MainTabPanel;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * Project entry point. Sets up UI and services for talking to the server.
 * 
 * @author drusk
 * 
 */
public class FlightManager implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxies to talk to the server
	 */
	private final DataEntryServiceAsync dataEntryService = GWT
			.create(DataEntryService.class);

	private final DataDeletionServiceAsync dataDeletionService = GWT
			.create(DataDeletionService.class);

	private final DataQueryServiceAsync dataQueryService = GWT
			.create(DataQueryService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		DockLayoutPanel basePanel = new DockLayoutPanel(Unit.PX);
		HTML header = new HTML("Welcome to the Flight Management System");
		header.addStyleName("mainPageHeader");
		basePanel.addNorth(header, 80);
		basePanel.add(new MainTabPanel(dataEntryService, dataDeletionService,
				dataQueryService));

		// DockLayoutPanel insertionsDockPanel = new DockLayoutPanel(Unit.PX);
		// final DeckLayoutPanel insertionsDeckPanel = new DeckLayoutPanel();
		// final HTML personnelHtml = new HTML(
		// "Form for entering personnel data goes here.");
		// final HTML flightsHtml = new HTML(
		// "Form for entering flights data goes here.");
		// insertionsDeckPanel.add(personnelHtml);
		// insertionsDeckPanel.add(flightsHtml);
		// VerticalPanel insertionsSelectionPanel = new VerticalPanel();
		// Button insertionPersonnelButton = new Button("Personnel");
		// insertionPersonnelButton.addClickHandler(new ClickHandler() {
		// @Override
		// public void onClick(ClickEvent event) {
		// insertionsDeckPanel.showWidget(personnelHtml);
		// }
		// });
		// insertionsSelectionPanel.setSpacing(0);
		// insertionsSelectionPanel
		// .setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
		// insertionsSelectionPanel.add(insertionPersonnelButton);
		//
		// insertionsDockPanel.addWest(insertionsSelectionPanel, 98.0);
		// Button insertionFlightsButton = new Button("Flights");
		// insertionFlightsButton.addClickHandler(new ClickHandler() {
		// @Override
		// public void onClick(ClickEvent event) {
		// insertionsDeckPanel.showWidget(flightsHtml);
		// }
		// });
		//
		// Button btnArrivals = new Button("Arrivals");
		// insertionsSelectionPanel.add(btnArrivals);
		//
		// Button btnDepartures = new Button("Departures");
		// insertionsSelectionPanel.add(btnDepartures);
		//
		// Button btnAirlines = new Button("Airlines");
		// insertionsSelectionPanel.add(btnAirlines);
		//
		// Button btnPlaneModels = new Button("Plane Models");
		// insertionsSelectionPanel.add(btnPlaneModels);
		// btnPlaneModels.setWidth("104px");
		//
		// Button btnGates = new Button("Gates");
		// insertionsSelectionPanel.add(btnGates);
		//
		// Button btnBaggage = new Button("Baggage");
		// insertionsSelectionPanel.add(btnBaggage);
		// insertionsSelectionPanel.add(insertionFlightsButton);
		//
		// Button btnCitizenships = new Button("Citizenships");
		// insertionsSelectionPanel.add(btnCitizenships);
		// insertionsDockPanel.add(insertionsDeckPanel);
		//
		// DockLayoutPanel deletionsDockPanel = new DockLayoutPanel(Unit.PX);
		// DockLayoutPanel queryingDockPanel = new DockLayoutPanel(Unit.PX);
		//
		// DeckLayoutPanel deletionsDeckPanel = new DeckLayoutPanel();
		// DeckLayoutPanel queryingDeckPanel = new DeckLayoutPanel();
		//
		// TabLayoutPanel tabPanel = new TabLayoutPanel(30, Unit.PX);
		// tabPanel.add(insertionsDockPanel, "Enter Data");
		// tabPanel.add(deletionsDockPanel, "Delete Data");
		// tabPanel.add(queryingDockPanel, "Query Data");
		//
		// basePanel.add(tabPanel);

		RootLayoutPanel.get().add(basePanel);
	}
}
