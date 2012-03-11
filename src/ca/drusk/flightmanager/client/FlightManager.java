package ca.drusk.flightmanager.client;

import ca.drusk.flightmanager.client.services.DataDeletionService;
import ca.drusk.flightmanager.client.services.DataDeletionServiceAsync;
import ca.drusk.flightmanager.client.services.DataEntryService;
import ca.drusk.flightmanager.client.services.DataEntryServiceAsync;
import ca.drusk.flightmanager.client.services.DataQueryService;
import ca.drusk.flightmanager.client.services.DataQueryServiceAsync;
import ca.drusk.flightmanager.client.ui.main_pages.MainTabPanel;

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

		HTML header = new HTML("Flight Management System");
		header.addStyleName("mainPageHeader");
		basePanel.addNorth(header, 80);
		basePanel.add(new MainTabPanel(dataEntryService, dataDeletionService,
				dataQueryService));

		RootLayoutPanel.get().add(basePanel);
	}
}
