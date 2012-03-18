package ca.drusk.flightmanager.client.ui.main_pages;

import ca.drusk.flightmanager.client.services.DataQueryServiceAsync;
import ca.drusk.flightmanager.client.table_data.TableNames;
import ca.drusk.flightmanager.client.ui.main_pages.data_display.AirlineResultsDisplay;
import ca.drusk.flightmanager.client.ui.main_pages.data_display.AirportsDisplay;
import ca.drusk.flightmanager.client.ui.main_pages.data_display.ArrivalsDataDisplay;
import ca.drusk.flightmanager.client.ui.main_pages.data_display.CitizenshipsDisplay;
import ca.drusk.flightmanager.client.ui.main_pages.data_display.DeparturesDataDisplay;
import ca.drusk.flightmanager.client.ui.main_pages.data_display.FlightInstancesDataDisplay;
import ca.drusk.flightmanager.client.ui.main_pages.data_display.FlightsDisplay;
import ca.drusk.flightmanager.client.ui.main_pages.data_display.GatesDataDisplay;
import ca.drusk.flightmanager.client.ui.main_pages.data_display.PassengersDataDisplay;
import ca.drusk.flightmanager.client.ui.main_pages.data_display.PlaneModelsDisplay;

import com.google.gwt.user.client.ui.DeckLayoutPanel;

/**
 * Allows selection of database table to view contents of.
 * 
 * @author drusk
 * 
 */
public class DataViewerTabContents extends AbstractTabContents {

	private final DataQueryServiceAsync dataQueryService;

	public DataViewerTabContents(DataQueryServiceAsync dataQueryService) {
		super();
		this.dataQueryService = dataQueryService;
		tabContents = initTabContents();
		dockPanel.add(tabContents);
	}

	@Override
	protected String[] getTablesToShow() {
		return TableNames.getAll();
	}

	@Override
	protected DeckLayoutPanel initTabContents() {
		DeckLayoutPanel tabContents = new DeckLayoutPanel();

		AirlineResultsDisplay airlineDisplay = new AirlineResultsDisplay(
				dataQueryService);
		tableSelector.registerSwitchHandler(TableNames.AIRLINES,
				airlineDisplay, tabContents);
		tabContents.add(airlineDisplay);

		PlaneModelsDisplay planeModelDisplay = new PlaneModelsDisplay(
				dataQueryService);
		tableSelector.registerSwitchHandler(TableNames.PLANE_MODELS,
				planeModelDisplay, tabContents);
		tabContents.add(planeModelDisplay);

		CitizenshipsDisplay citizenshipDisplay = new CitizenshipsDisplay(
				dataQueryService);
		tableSelector.registerSwitchHandler(TableNames.CITIZENSHIPS,
				citizenshipDisplay, tabContents);
		tabContents.add(citizenshipDisplay);

		AirportsDisplay locationsDisplay = new AirportsDisplay(dataQueryService);
		tableSelector.registerSwitchHandler(TableNames.AIRPORTS,
				locationsDisplay, tabContents);
		tabContents.add(locationsDisplay);

		FlightsDisplay flightsDisplay = new FlightsDisplay(dataQueryService);
		tableSelector.registerSwitchHandler(TableNames.FLIGHTS, flightsDisplay,
				tabContents);
		tabContents.add(flightsDisplay);

		GatesDataDisplay gatesDisplay = new GatesDataDisplay(dataQueryService);
		tableSelector.registerSwitchHandler(TableNames.GATES, gatesDisplay,
				tabContents);
		tabContents.add(gatesDisplay);

		ArrivalsDataDisplay arrivalsDisplay = new ArrivalsDataDisplay(
				dataQueryService);
		tableSelector.registerSwitchHandler(TableNames.ARRIVALS,
				arrivalsDisplay, tabContents);
		tabContents.add(arrivalsDisplay);

		DeparturesDataDisplay departuresDisplay = new DeparturesDataDisplay(
				dataQueryService);
		tableSelector.registerSwitchHandler(TableNames.DEPARTURES,
				departuresDisplay, tabContents);
		tabContents.add(departuresDisplay);

		PassengersDataDisplay passengersDisplay = new PassengersDataDisplay(
				dataQueryService);
		tableSelector.registerSwitchHandler(TableNames.PASSENGERS,
				passengersDisplay, tabContents);
		tabContents.add(passengersDisplay);

		FlightInstancesDataDisplay flightInstancesDisplay = new FlightInstancesDataDisplay(
				dataQueryService);
		tableSelector.registerSwitchHandler(TableNames.FLIGHT_INSTANCES,
				flightInstancesDisplay, tabContents);
		tabContents.add(flightInstancesDisplay);

		tabContents.showWidget(0);
		return tabContents;
	}

}
