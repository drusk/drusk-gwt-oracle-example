package ca.drusk.flightmanager.client.ui.main_pages;

import ca.drusk.flightmanager.client.services.DataEntryServiceAsync;
import ca.drusk.flightmanager.client.table_data.TableNames;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry.AirlineDataEntryForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry.AirportsDataEntryForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry.ArrivalsDataEntryForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry.BaggageDataEntryForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry.CitizenshipsDataEntryForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry.DeparturesDataEntryForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry.FlightAttendanceDataEntryForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry.FlightInventoryDataEntryForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry.FlightsDataEntryForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry.GateDataEntryForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry.PassengerClassDataEntryForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry.PassengersDataEntryForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry.PlaneModelsDataEntryForm;

import com.google.gwt.user.client.ui.DeckLayoutPanel;

/**
 * UI components for data entry
 * 
 * @author drusk
 * 
 */
public class DataEntryTabContents extends AbstractTabContents {

	private final DataEntryServiceAsync dataEntryService;

	public DataEntryTabContents(DataEntryServiceAsync dataEntryService) {
		super();
		this.dataEntryService = dataEntryService;
		tabContents = initTabContents();
		// ScrollPanel scrollPanel = new ScrollPanel(tabContents);
		dockPanel.add(tabContents);
	}

	@Override
	protected String[] getButtonNamesForContents() {
		return TableNames.getEntryTables();
	}

	@Override
	protected DeckLayoutPanel initTabContents() {
		DeckLayoutPanel tabContents = new DeckLayoutPanel();

		AirlineDataEntryForm airlineForm = new AirlineDataEntryForm(
				dataEntryService);
		contentSelector.registerSwitchHandler(TableNames.AIRLINES, airlineForm,
				tabContents);
		tabContents.add(airlineForm);

		PlaneModelsDataEntryForm planeModelForm = new PlaneModelsDataEntryForm(
				dataEntryService);
		contentSelector.registerSwitchHandler(TableNames.PLANE_MODELS,
				planeModelForm, tabContents);
		tabContents.add(planeModelForm);

		CitizenshipsDataEntryForm citizenshipForm = new CitizenshipsDataEntryForm(
				dataEntryService);
		contentSelector.registerSwitchHandler(TableNames.CITIZENSHIPS,
				citizenshipForm, tabContents);
		tabContents.add(citizenshipForm);

		AirportsDataEntryForm locationsForm = new AirportsDataEntryForm(
				dataEntryService);
		contentSelector.registerSwitchHandler(TableNames.AIRPORTS,
				locationsForm, tabContents);
		tabContents.add(locationsForm);

		FlightsDataEntryForm flightsForm = new FlightsDataEntryForm(
				dataEntryService);
		contentSelector.registerSwitchHandler(TableNames.FLIGHTS, flightsForm,
				tabContents);
		tabContents.add(flightsForm);

		GateDataEntryForm gatesForm = new GateDataEntryForm(dataEntryService);
		contentSelector.registerSwitchHandler(TableNames.GATES, gatesForm,
				tabContents);
		tabContents.add(gatesForm);

		ArrivalsDataEntryForm arrivalsForm = new ArrivalsDataEntryForm(
				dataEntryService);
		contentSelector.registerSwitchHandler(TableNames.ARRIVALS,
				arrivalsForm, tabContents);
		tabContents.add(arrivalsForm);

		DeparturesDataEntryForm departuresForm = new DeparturesDataEntryForm(
				dataEntryService);
		contentSelector.registerSwitchHandler(TableNames.DEPARTURES,
				departuresForm, tabContents);
		tabContents.add(departuresForm);

		PassengersDataEntryForm passengersForm = new PassengersDataEntryForm(
				dataEntryService);
		contentSelector.registerSwitchHandler(TableNames.PASSENGERS,
				passengersForm, tabContents);
		tabContents.add(passengersForm);

		// FlightInstancesDataEntryForm flightInstancesForm = new
		// FlightInstancesDataEntryForm(
		// dataEntryService);
		// contentSelector.registerSwitchHandler(TableNames.FLIGHT_INSTANCES,
		// flightInstancesForm, tabContents);
		// tabContents.add(flightInstancesForm);

		FlightAttendanceDataEntryForm flightAttendanceForm = new FlightAttendanceDataEntryForm(
				dataEntryService);
		contentSelector.registerSwitchHandler(TableNames.FLIGHT_ATTENDANCE,
				flightAttendanceForm, tabContents);
		tabContents.add(flightAttendanceForm);

		BaggageDataEntryForm baggageForm = new BaggageDataEntryForm(
				dataEntryService);
		contentSelector.registerSwitchHandler(TableNames.BAGGAGE, baggageForm,
				tabContents);
		tabContents.add(baggageForm);

		FlightInventoryDataEntryForm flightInventoryForm = new FlightInventoryDataEntryForm(
				dataEntryService);
		contentSelector.registerSwitchHandler(TableNames.FLIGHT_INVENTORY,
				flightInventoryForm, tabContents);
		tabContents.add(flightInventoryForm);

		PassengerClassDataEntryForm passengerClassForm = new PassengerClassDataEntryForm(
				dataEntryService);
		contentSelector.registerSwitchHandler(TableNames.PASSENGER_CLASS,
				passengerClassForm, tabContents);
		tabContents.add(passengerClassForm);

		tabContents.showWidget(0);

		return tabContents;
	}
}
