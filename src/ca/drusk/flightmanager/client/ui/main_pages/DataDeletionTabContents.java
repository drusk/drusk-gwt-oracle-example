package ca.drusk.flightmanager.client.ui.main_pages;

import ca.drusk.flightmanager.client.services.DataDeletionServiceAsync;
import ca.drusk.flightmanager.client.table_data.TableNames;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.delete.AirlineDataDeletionForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.delete.AirportsDataDeletionForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.delete.ArrivalsDataDeletionForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.delete.BaggageDataDeletionForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.delete.CitizenshipsDataDeletionForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.delete.DeparturesDataDeletionForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.delete.FlightAttendanceDataDeletionForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.delete.FlightInstancesDataDeletionForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.delete.FlightInventoryDataDeletionForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.delete.FlightsDataDeletionForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.delete.GateDataDeletionForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.delete.GuardiansDataDeletionForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.delete.PassengersDataDeletionForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.delete.PlaneModelsDataDeletionForm;

import com.google.gwt.user.client.ui.DeckLayoutPanel;

/**
 * Allows selection of table to delete from, and holds forms for making
 * deletions
 * 
 * @author drusk
 * 
 */
public class DataDeletionTabContents extends AbstractTabContents {

	private final DataDeletionServiceAsync dataDeletionService;

	public DataDeletionTabContents(DataDeletionServiceAsync dataDeletionService) {
		super();
		this.dataDeletionService = dataDeletionService;
		tabContents = initTabContents();
		dockPanel.add(tabContents);
	}

	@Override
	protected String[] getButtonNamesForContents() {
		return TableNames.getAll();
	}

	@Override
	protected DeckLayoutPanel initTabContents() {
		DeckLayoutPanel tabContents = new DeckLayoutPanel();

		AirlineDataDeletionForm airlineForm = new AirlineDataDeletionForm(
				dataDeletionService);
		contentSelector.registerSwitchHandler(TableNames.AIRLINES, airlineForm,
				tabContents);
		tabContents.add(airlineForm);

		PlaneModelsDataDeletionForm planeModelForm = new PlaneModelsDataDeletionForm(
				dataDeletionService);
		contentSelector.registerSwitchHandler(TableNames.PLANE_MODELS,
				planeModelForm, tabContents);
		tabContents.add(planeModelForm);

		CitizenshipsDataDeletionForm citizenshipForm = new CitizenshipsDataDeletionForm(
				dataDeletionService);
		contentSelector.registerSwitchHandler(TableNames.CITIZENSHIPS,
				citizenshipForm, tabContents);
		tabContents.add(citizenshipForm);

		AirportsDataDeletionForm locationsForm = new AirportsDataDeletionForm(
				dataDeletionService);
		contentSelector.registerSwitchHandler(TableNames.AIRPORTS, locationsForm,
				tabContents);
		tabContents.add(locationsForm);

		FlightsDataDeletionForm flightsForm = new FlightsDataDeletionForm(
				dataDeletionService);
		contentSelector.registerSwitchHandler(TableNames.FLIGHTS, flightsForm,
				tabContents);
		tabContents.add(flightsForm);

		GateDataDeletionForm gatesForm = new GateDataDeletionForm(
				dataDeletionService);
		contentSelector.registerSwitchHandler(TableNames.GATES, gatesForm,
				tabContents);
		tabContents.add(gatesForm);

		ArrivalsDataDeletionForm arrivalsForm = new ArrivalsDataDeletionForm(
				dataDeletionService);
		contentSelector.registerSwitchHandler(TableNames.ARRIVALS, arrivalsForm,
				tabContents);
		tabContents.add(arrivalsForm);

		DeparturesDataDeletionForm departuresForm = new DeparturesDataDeletionForm(
				dataDeletionService);
		contentSelector.registerSwitchHandler(TableNames.DEPARTURES,
				departuresForm, tabContents);
		tabContents.add(departuresForm);

		PassengersDataDeletionForm passengersForm = new PassengersDataDeletionForm(
				dataDeletionService);
		contentSelector.registerSwitchHandler(TableNames.PASSENGERS,
				passengersForm, tabContents);
		tabContents.add(passengersForm);

		FlightInstancesDataDeletionForm flightInstancesForm = new FlightInstancesDataDeletionForm(
				dataDeletionService);
		contentSelector.registerSwitchHandler(TableNames.FLIGHT_INSTANCES,
				flightInstancesForm, tabContents);
		tabContents.add(flightInstancesForm);

		FlightAttendanceDataDeletionForm flightAttendanceForm = new FlightAttendanceDataDeletionForm(
				dataDeletionService);
		contentSelector.registerSwitchHandler(TableNames.FLIGHT_ATTENDANCE,
				flightAttendanceForm, tabContents);
		tabContents.add(flightAttendanceForm);

		BaggageDataDeletionForm baggageForm = new BaggageDataDeletionForm(
				dataDeletionService);
		contentSelector.registerSwitchHandler(TableNames.BAGGAGE, baggageForm,
				tabContents);
		tabContents.add(baggageForm);

		FlightInventoryDataDeletionForm flightInventoryForm = new FlightInventoryDataDeletionForm(
				dataDeletionService);
		contentSelector.registerSwitchHandler(TableNames.FLIGHT_INVENTORY,
				flightInventoryForm, tabContents);
		tabContents.add(flightInventoryForm);

		GuardiansDataDeletionForm guardiansForm = new GuardiansDataDeletionForm(
				dataDeletionService);
		contentSelector.registerSwitchHandler(TableNames.GUARDIANS,
				guardiansForm, tabContents);
		tabContents.add(guardiansForm);

		tabContents.showWidget(0);

		return tabContents;
	}

}
