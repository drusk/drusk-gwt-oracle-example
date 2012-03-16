package ca.drusk.flightmanager.client.ui.main_pages;

import ca.drusk.flightmanager.client.services.DataDeletionServiceAsync;
import ca.drusk.flightmanager.client.table_data.TableNames;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.delete.AirlineDataDeletionForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.delete.CitizenshipsDataDeletionForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.delete.FlightsDataDeletionForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.delete.LocationsDataDeletionForm;
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
	protected String[] getTablesToShow() {
		return TableNames.getAll();
	}

	@Override
	protected DeckLayoutPanel initTabContents() {
		DeckLayoutPanel tabContents = new DeckLayoutPanel();

		AirlineDataDeletionForm airlineForm = new AirlineDataDeletionForm(
				dataDeletionService);
		tableSelector.registerSwitchHandler(TableNames.AIRLINES, airlineForm,
				tabContents);
		tabContents.add(airlineForm);

		PlaneModelsDataDeletionForm planeModelForm = new PlaneModelsDataDeletionForm(
				dataDeletionService);
		tableSelector.registerSwitchHandler(TableNames.PLANE_MODELS,
				planeModelForm, tabContents);
		tabContents.add(planeModelForm);

		CitizenshipsDataDeletionForm citizenshipForm = new CitizenshipsDataDeletionForm(
				dataDeletionService);
		tableSelector.registerSwitchHandler(TableNames.CITIZENSHIPS,
				citizenshipForm, tabContents);
		tabContents.add(citizenshipForm);

		LocationsDataDeletionForm locationsForm = new LocationsDataDeletionForm(
				dataDeletionService);
		tableSelector.registerSwitchHandler(TableNames.LOCATIONS,
				locationsForm, tabContents);
		tabContents.add(locationsForm);

		FlightsDataDeletionForm flightsForm = new FlightsDataDeletionForm(
				dataDeletionService);
		tableSelector.registerSwitchHandler(TableNames.FLIGHTS, flightsForm,
				tabContents);
		tabContents.add(flightsForm);

		tabContents.showWidget(0);

		return tabContents;
	}

}
