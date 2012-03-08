package ca.drusk.flightmanager.client.ui_components;

import ca.drusk.flightmanager.client.services.DataDeletionServiceAsync;
import ca.drusk.flightmanager.client.services.DataEntryServiceAsync;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.TabLayoutPanel;

/**
 * The main tab panel whose tabs provide access to the different services.
 * 
 * @author drusk
 * 
 */
public class MainTabPanel extends TabLayoutPanel {

	private static double barHeight = 100;

	private String ENTER_DATA = "Enter Data";

	private String DELETE_DATA = "Delete Data";

	private String QUERY_DATA = "Query Data";

	private final DataEntryServiceAsync dataEntryService;

	private final DataDeletionServiceAsync dataDeletionService;

	public MainTabPanel(DataEntryServiceAsync dataEntryService,
			DataDeletionServiceAsync dataDeletionService) {
		super(barHeight, Unit.PX);
		this.dataEntryService = dataEntryService;
		this.dataDeletionService = dataDeletionService;
		initTabContents();
	}

	private void initTabContents() {
		add(new DataEntryTabContents(dataEntryService), ENTER_DATA);
		add(new DataDeletionTabContents(dataDeletionService), DELETE_DATA);

		// default to first tab
		selectTab(0);
	}
}
