package ca.drusk.flightmanager.client.ui.main_pages;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.DeckLayoutPanel;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

/**
 * Base class providing common functionality for the different tabs in the
 * application.
 * 
 * @author drusk
 * 
 */
public abstract class AbstractTabContents implements IsWidget {

	protected DockLayoutPanel dockPanel = new DockLayoutPanel(Unit.PX);

	private double tableSelectorWidth = 100;

	protected TableSelector tableSelector;

	protected DeckLayoutPanel tabContents;

	protected AbstractTabContents() {
		tableSelector = new TableSelector(getTablesToShow());
		dockPanel.addWest(tableSelector, tableSelectorWidth);
	}

	protected abstract String[] getTablesToShow();

	protected abstract DeckLayoutPanel initTabContents();

	@Override
	public Widget asWidget() {
		return dockPanel;
	}

}
