package ca.drusk.flightmanager.client.ui.main_pages;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.DeckLayoutPanel;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.ScrollPanel;
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

	protected ContentSelector contentSelector;

	protected DeckLayoutPanel tabContents;

	protected AbstractTabContents() {
		this(100);
	}

	protected AbstractTabContents(double contentSelectorWidth) {
		contentSelector = new ContentSelector(getButtonNamesForContents());
		// allow scrolling of content selector
		ScrollPanel scrollPanel = new ScrollPanel();
		scrollPanel.add(contentSelector);
		dockPanel.addWest(scrollPanel, contentSelectorWidth);
	}

	protected abstract String[] getButtonNamesForContents();

	protected abstract DeckLayoutPanel initTabContents();

	@Override
	public Widget asWidget() {
		return dockPanel;
	}

}
