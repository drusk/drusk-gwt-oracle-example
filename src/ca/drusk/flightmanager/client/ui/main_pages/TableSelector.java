package ca.drusk.flightmanager.client.ui.main_pages;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DeckLayoutPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Widget for selecting database tables.
 * 
 * @author drusk
 * 
 */
public class TableSelector implements IsWidget {

	private VerticalPanel buttonHolder = new VerticalPanel();

	private Map<String, Button> buttonsByTableName = new HashMap<String, Button>();

	public TableSelector(String... tables) {
		generateButtons(tables);
		formatButtonHolder();
	}

	private void formatButtonHolder() {
		buttonHolder.setWidth("100%");
		buttonHolder.setHeight("100%");
		buttonHolder.setBorderWidth(1);
	}

	private void generateButtons(String[] tables) {
		for (String table : tables) {
			Button button = new Button(table);
			buttonHolder.add(button);
			buttonsByTableName.put(table, button);
		}
	}

	/**
	 * Sets the click handler for the button corresponding to
	 * <code>tableName</code>.
	 * 
	 */
	public void registerSwitchHandler(String tableName,
			final IsWidget widgetToShow, final DeckLayoutPanel deckPanel) {
		buttonsByTableName.get(tableName).addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				deckPanel.showWidget(widgetToShow.asWidget());
			}

		});
	}

	@Override
	public Widget asWidget() {
		return buttonHolder;
	}

}
