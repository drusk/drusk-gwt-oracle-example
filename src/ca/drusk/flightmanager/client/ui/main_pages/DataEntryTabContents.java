package ca.drusk.flightmanager.client.ui.main_pages;

import ca.drusk.flightmanager.client.services.DataEntryServiceAsync;
import ca.drusk.flightmanager.client.table_data.TableNames;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry.AirlineDataEntryForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry.AirportsDataEntryForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry.ArrivalsDataEntryForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry.CitizenshipsDataEntryForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry.DeparturesDataEntryForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry.FlightInstancesDataEntryForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry.FlightsDataEntryForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry.GateDataEntryForm;
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
		dockPanel.add(tabContents);
	}

	@Override
	protected String[] getTablesToShow() {
		return TableNames.getAll();
	}

	@Override
	protected DeckLayoutPanel initTabContents() {
		DeckLayoutPanel tabContents = new DeckLayoutPanel();

		AirlineDataEntryForm airlineForm = new AirlineDataEntryForm(
				dataEntryService);
		tableSelector.registerSwitchHandler(TableNames.AIRLINES, airlineForm,
				tabContents);
		tabContents.add(airlineForm);

		PlaneModelsDataEntryForm planeModelForm = new PlaneModelsDataEntryForm(
				dataEntryService);
		tableSelector.registerSwitchHandler(TableNames.PLANE_MODELS,
				planeModelForm, tabContents);
		tabContents.add(planeModelForm);

		CitizenshipsDataEntryForm citizenshipForm = new CitizenshipsDataEntryForm(
				dataEntryService);
		tableSelector.registerSwitchHandler(TableNames.CITIZENSHIPS,
				citizenshipForm, tabContents);
		tabContents.add(citizenshipForm);

		AirportsDataEntryForm locationsForm = new AirportsDataEntryForm(
				dataEntryService);
		tableSelector.registerSwitchHandler(TableNames.AIRPORTS, locationsForm,
				tabContents);
		tabContents.add(locationsForm);

		FlightsDataEntryForm flightsForm = new FlightsDataEntryForm(
				dataEntryService);
		tableSelector.registerSwitchHandler(TableNames.FLIGHTS, flightsForm,
				tabContents);
		tabContents.add(flightsForm);

		GateDataEntryForm gatesForm = new GateDataEntryForm(dataEntryService);
		tableSelector.registerSwitchHandler(TableNames.GATES, gatesForm,
				tabContents);
		tabContents.add(gatesForm);

		ArrivalsDataEntryForm arrivalsForm = new ArrivalsDataEntryForm(
				dataEntryService);
		tableSelector.registerSwitchHandler(TableNames.ARRIVALS, arrivalsForm,
				tabContents);
		tabContents.add(arrivalsForm);

		DeparturesDataEntryForm departuresForm = new DeparturesDataEntryForm(
				dataEntryService);
		tableSelector.registerSwitchHandler(TableNames.DEPARTURES,
				departuresForm, tabContents);
		tabContents.add(departuresForm);

		PassengersDataEntryForm passengersForm = new PassengersDataEntryForm(
				dataEntryService);
		tableSelector.registerSwitchHandler(TableNames.PASSENGERS,
				passengersForm, tabContents);
		tabContents.add(passengersForm);

		FlightInstancesDataEntryForm flightInstancesForm = new FlightInstancesDataEntryForm(
				dataEntryService);
		tableSelector.registerSwitchHandler(TableNames.FLIGHT_INSTANCES,
				flightInstancesForm, tabContents);
		tabContents.add(flightInstancesForm);

		tabContents.showWidget(0);

		return tabContents;
	}
}
