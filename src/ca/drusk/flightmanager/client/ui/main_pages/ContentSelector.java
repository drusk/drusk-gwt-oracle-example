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
 * Widget for holding buttons which can be registered to show different widgets
 * in a {@link DeckLayoutPanel}.
 * 
 * @author drusk
 * 
 */
public class ContentSelector implements IsWidget {

	private VerticalPanel buttonHolder = new VerticalPanel();

	private Map<String, Button> buttonsByName = new HashMap<String, Button>();

	public ContentSelector(String... buttonNames) {
		generateButtons(buttonNames);
		formatButtonHolder();
	}

	private void formatButtonHolder() {
		buttonHolder.setWidth("100%");
		buttonHolder.setHeight("100%");
		buttonHolder.setBorderWidth(1);
	}

	private void generateButtons(String[] buttonNames) {
		for (String table : buttonNames) {
			Button button = new Button(table);
			buttonHolder.add(button);
			buttonsByName.put(table, button);
		}
	}

	/**
	 * Sets the click handler for the button corresponding to
	 * <code>tableName</code>.
	 * 
	 */
	public void registerSwitchHandler(String buttonName,
			final IsWidget widgetToShow, final DeckLayoutPanel deckPanel) {
		buttonsByName.get(buttonName).addClickHandler(new ClickHandler() {

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
