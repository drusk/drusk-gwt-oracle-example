package ca.drusk.flightmanager.client.ui.main_pages;

import ca.drusk.flightmanager.client.services.DataDeletionServiceAsync;
import ca.drusk.flightmanager.client.services.DataEntryServiceAsync;
import ca.drusk.flightmanager.client.services.FlightQueryServiceAsync;
import ca.drusk.flightmanager.client.services.FullRelationQueryServiceAsync;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * The main tab panel whose tabs provide access to the different services.
 * 
 * @author drusk
 * 
 */
public class MainTabPanel implements IsWidget {

	private TabLayoutPanel tabPanel = new TabLayoutPanel(barHeight, Unit.PX);

	private static double barHeight = 100;

	private static String ENTER_DATA = "Enter Data";

	private static String DELETE_DATA = "Delete Data";

	private static String VIEW_DATA = "View Data";

	private static String QUERIES = "Queries";

	private final DataEntryServiceAsync dataEntryService;

	private final DataDeletionServiceAsync dataDeletionService;

	private final FullRelationQueryServiceAsync dataQueryService;

	private final FlightQueryServiceAsync flightQueryService;

	public MainTabPanel(DataEntryServiceAsync dataEntryService,
			DataDeletionServiceAsync dataDeletionService,
			FullRelationQueryServiceAsync dataQueryService,
			FlightQueryServiceAsync flightQueryService) {
		this.dataEntryService = dataEntryService;
		this.dataDeletionService = dataDeletionService;
		this.dataQueryService = dataQueryService;
		this.flightQueryService = flightQueryService;
		initTabContents();
	}

	private void initTabContents() {
		tabPanel.add(new DataEntryTabContents(dataEntryService), ENTER_DATA);
		tabPanel.add(new DataDeletionTabContents(dataDeletionService),
				DELETE_DATA);
		tabPanel.add(new DataViewerTabContents(dataQueryService), VIEW_DATA);
		tabPanel.add(new QueryTabContents(flightQueryService), QUERIES);
		// default to first tab
		tabPanel.selectTab(0);
	}

	@Override
	public Widget asWidget() {
		return tabPanel;
	}
}
