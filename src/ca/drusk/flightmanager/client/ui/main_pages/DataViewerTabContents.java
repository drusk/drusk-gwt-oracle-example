package ca.drusk.flightmanager.client.ui.main_pages;

import ca.drusk.flightmanager.client.services.FullRelationQueryServiceAsync;
import ca.drusk.flightmanager.client.table_data.TableNames;
import ca.drusk.flightmanager.client.ui.main_pages.data_display.full_relations.AirlineResultsDisplay;
import ca.drusk.flightmanager.client.ui.main_pages.data_display.full_relations.AirportsDisplay;
import ca.drusk.flightmanager.client.ui.main_pages.data_display.full_relations.ArrivalsDataDisplay;
import ca.drusk.flightmanager.client.ui.main_pages.data_display.full_relations.BaggageDisplay;
import ca.drusk.flightmanager.client.ui.main_pages.data_display.full_relations.CitizenshipsDisplay;
import ca.drusk.flightmanager.client.ui.main_pages.data_display.full_relations.DeparturesDataDisplay;
import ca.drusk.flightmanager.client.ui.main_pages.data_display.full_relations.FlightAttendanceDataDisplay;
import ca.drusk.flightmanager.client.ui.main_pages.data_display.full_relations.FlightInstancesDataDisplay;
import ca.drusk.flightmanager.client.ui.main_pages.data_display.full_relations.FlightInventoryDisplay;
import ca.drusk.flightmanager.client.ui.main_pages.data_display.full_relations.FlightsDisplay;
import ca.drusk.flightmanager.client.ui.main_pages.data_display.full_relations.GatesDataDisplay;
import ca.drusk.flightmanager.client.ui.main_pages.data_display.full_relations.InfantsDisplay;
import ca.drusk.flightmanager.client.ui.main_pages.data_display.full_relations.PassengerClassDataDisplay;
import ca.drusk.flightmanager.client.ui.main_pages.data_display.full_relations.PassengersDataDisplay;
import ca.drusk.flightmanager.client.ui.main_pages.data_display.full_relations.PlaneModelsDisplay;

import com.google.gwt.user.client.ui.DeckLayoutPanel;

/**
 * Allows selection of database table to view contents of.
 * 
 * @author drusk
 * 
 */
public class DataViewerTabContents extends AbstractTabContents {

	private final FullRelationQueryServiceAsync dataQueryService;

	public DataViewerTabContents(FullRelationQueryServiceAsync dataQueryService) {
		super();
		this.dataQueryService = dataQueryService;
		tabContents = initTabContents();
		// ScrollPanel scrollPanel = new ScrollPanel(tabContents);
		dockPanel.add(tabContents);
	}

	@Override
	protected String[] getButtonNamesForContents() {
		return TableNames.getViewingTables();
	}

	@Override
	protected DeckLayoutPanel initTabContents() {
		DeckLayoutPanel tabContents = new DeckLayoutPanel();

		AirlineResultsDisplay airlineDisplay = new AirlineResultsDisplay(
				dataQueryService);
		contentSelector.registerSwitchHandler(TableNames.AIRLINES,
				airlineDisplay, tabContents);
		tabContents.add(airlineDisplay);

		PlaneModelsDisplay planeModelDisplay = new PlaneModelsDisplay(
				dataQueryService);
		contentSelector.registerSwitchHandler(TableNames.PLANE_MODELS,
				planeModelDisplay, tabContents);
		tabContents.add(planeModelDisplay);

		CitizenshipsDisplay citizenshipDisplay = new CitizenshipsDisplay(
				dataQueryService);
		contentSelector.registerSwitchHandler(TableNames.CITIZENSHIPS,
				citizenshipDisplay, tabContents);
		tabContents.add(citizenshipDisplay);

		AirportsDisplay locationsDisplay = new AirportsDisplay(dataQueryService);
		contentSelector.registerSwitchHandler(TableNames.AIRPORTS,
				locationsDisplay, tabContents);
		tabContents.add(locationsDisplay);

		FlightsDisplay flightsDisplay = new FlightsDisplay(dataQueryService);
		contentSelector.registerSwitchHandler(TableNames.FLIGHTS,
				flightsDisplay, tabContents);
		tabContents.add(flightsDisplay);

		GatesDataDisplay gatesDisplay = new GatesDataDisplay(dataQueryService);
		contentSelector.registerSwitchHandler(TableNames.GATES, gatesDisplay,
				tabContents);
		tabContents.add(gatesDisplay);

		ArrivalsDataDisplay arrivalsDisplay = new ArrivalsDataDisplay(
				dataQueryService);
		contentSelector.registerSwitchHandler(TableNames.ARRIVALS,
				arrivalsDisplay, tabContents);
		tabContents.add(arrivalsDisplay);

		DeparturesDataDisplay departuresDisplay = new DeparturesDataDisplay(
				dataQueryService);
		contentSelector.registerSwitchHandler(TableNames.DEPARTURES,
				departuresDisplay, tabContents);
		tabContents.add(departuresDisplay);

		PassengersDataDisplay passengersDisplay = new PassengersDataDisplay(
				dataQueryService);
		contentSelector.registerSwitchHandler(TableNames.PASSENGERS,
				passengersDisplay, tabContents);
		tabContents.add(passengersDisplay);

		FlightInstancesDataDisplay flightInstancesDisplay = new FlightInstancesDataDisplay(
				dataQueryService);
		contentSelector.registerSwitchHandler(TableNames.FLIGHT_INSTANCES,
				flightInstancesDisplay, tabContents);
		tabContents.add(flightInstancesDisplay);

		FlightAttendanceDataDisplay flightAttendanceDisplay = new FlightAttendanceDataDisplay(
				dataQueryService);
		contentSelector.registerSwitchHandler(TableNames.FLIGHT_ATTENDANCE,
				flightAttendanceDisplay, tabContents);
		tabContents.add(flightAttendanceDisplay);

		BaggageDisplay baggageDisplay = new BaggageDisplay(dataQueryService);
		contentSelector.registerSwitchHandler(TableNames.BAGGAGE,
				baggageDisplay, tabContents);
		tabContents.add(baggageDisplay);

		FlightInventoryDisplay flightInventoryDisplay = new FlightInventoryDisplay(
				dataQueryService);
		contentSelector.registerSwitchHandler(TableNames.FLIGHT_INVENTORY,
				flightInventoryDisplay, tabContents);
		tabContents.add(flightInventoryDisplay);

		InfantsDisplay infantsDisplay = new InfantsDisplay(dataQueryService);
		contentSelector.registerSwitchHandler(TableNames.INFANTS,
				infantsDisplay, tabContents);
		tabContents.add(infantsDisplay);

		PassengerClassDataDisplay passengerClassesDisplay = new PassengerClassDataDisplay(
				dataQueryService);
		contentSelector.registerSwitchHandler(TableNames.PASSENGER_CLASS,
				passengerClassesDisplay, tabContents);
		tabContents.add(passengerClassesDisplay);

		tabContents.showWidget(0);
		return tabContents;
	}

}
