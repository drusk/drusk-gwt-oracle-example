package ca.drusk.flightmanager.client.ui.main_pages;

import ca.drusk.flightmanager.client.services.DataEntryServiceAsync;
import ca.drusk.flightmanager.client.table_data.TableNames;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry.AirlineDataEntryForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry.CitizenshipsDataEntryForm;
import ca.drusk.flightmanager.client.ui.main_pages.data_modification_forms.entry.LocationsDataEntryForm;
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

		LocationsDataEntryForm locationsForm = new LocationsDataEntryForm(
				dataEntryService);
		tableSelector.registerSwitchHandler(TableNames.LOCATIONS,
				locationsForm, tabContents);
		tabContents.add(locationsForm);

		tabContents.showWidget(0);

		return tabContents;
	}
}
