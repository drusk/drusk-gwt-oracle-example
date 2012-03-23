package ca.drusk.flightmanager.client.ui.main_pages;

import ca.drusk.flightmanager.client.services.FlightQueryServiceAsync;
import ca.drusk.flightmanager.client.ui.main_pages.data_display.queries.ConnectingFlightsDisplay;
import ca.drusk.flightmanager.client.ui.main_pages.data_display.queries.FlightInstancePassengersDisplay;
import ca.drusk.flightmanager.client.ui.main_pages.data_display.queries.FlightsAroundTimeDisplay;
import ca.drusk.flightmanager.client.ui.main_pages.data_display.queries.FlightsOperatedDisplay;
import ca.drusk.flightmanager.client.ui.main_pages.data_display.queries.IncomingOutgoingFlightsDisplay;
import ca.drusk.flightmanager.client.ui.main_pages.data_display.queries.MostFrequentPassengersDisplay;
import ca.drusk.flightmanager.client.ui.main_pages.data_display.queries.PassengerBaggageDisplay;
import ca.drusk.flightmanager.client.ui.main_pages.data_display.queries.PassengersInTransitDisplay;

import com.google.gwt.user.client.ui.DeckLayoutPanel;

/**
 * Allows selection of a query, and holds the display forms for the results.
 * 
 * @author drusk
 * 
 */
public class QueryTabContents extends AbstractTabContents {

	private final FlightQueryServiceAsync flightQueryService;

	public QueryTabContents(FlightQueryServiceAsync flightQueryService) {
		super(200);
		this.flightQueryService = flightQueryService;
		tabContents = initTabContents();
		dockPanel.add(tabContents);
	}

	@Override
	protected String[] getButtonNamesForContents() {
		return new String[] { FlightsOperatedDisplay.DESC,
				IncomingOutgoingFlightsDisplay.DESC,
				FlightsAroundTimeDisplay.DESC,
				FlightInstancePassengersDisplay.DESC,
				PassengerBaggageDisplay.DESC, ConnectingFlightsDisplay.DESC,
				MostFrequentPassengersDisplay.DESC,
				PassengersInTransitDisplay.DESC };
	}

	@Override
	protected DeckLayoutPanel initTabContents() {
		DeckLayoutPanel tabContents = new DeckLayoutPanel();

		FlightsOperatedDisplay flightsOperatedDisplay = new FlightsOperatedDisplay(
				flightQueryService);
		contentSelector.registerSwitchHandler(flightsOperatedDisplay.DESC,
				flightsOperatedDisplay, tabContents);
		tabContents.add(flightsOperatedDisplay);

		IncomingOutgoingFlightsDisplay inOutFlightDisplay = new IncomingOutgoingFlightsDisplay(
				flightQueryService);
		contentSelector.registerSwitchHandler(inOutFlightDisplay.DESC,
				inOutFlightDisplay, tabContents);
		tabContents.add(inOutFlightDisplay);

		FlightInstancePassengersDisplay flightPassengersDisplay = new FlightInstancePassengersDisplay(
				flightQueryService);
		contentSelector.registerSwitchHandler(
				FlightInstancePassengersDisplay.DESC, flightPassengersDisplay,
				tabContents);
		tabContents.add(flightPassengersDisplay);

		PassengerBaggageDisplay passengerBaggageDisplay = new PassengerBaggageDisplay(
				flightQueryService);
		contentSelector.registerSwitchHandler(PassengerBaggageDisplay.DESC,
				passengerBaggageDisplay, tabContents);
		tabContents.add(passengerBaggageDisplay);

		ConnectingFlightsDisplay connectingFlightsDisplay = new ConnectingFlightsDisplay(
				flightQueryService);
		contentSelector.registerSwitchHandler(ConnectingFlightsDisplay.DESC,
				connectingFlightsDisplay, tabContents);
		tabContents.add(connectingFlightsDisplay);

		MostFrequentPassengersDisplay frequentPassengerDisplay = new MostFrequentPassengersDisplay(
				flightQueryService);
		contentSelector.registerSwitchHandler(
				MostFrequentPassengersDisplay.DESC, frequentPassengerDisplay,
				tabContents);
		tabContents.add(frequentPassengerDisplay);

		PassengersInTransitDisplay transitDisplay = new PassengersInTransitDisplay(
				flightQueryService);
		contentSelector.registerSwitchHandler(PassengersInTransitDisplay.DESC,
				transitDisplay, tabContents);
		tabContents.add(transitDisplay);

		FlightsAroundTimeDisplay flightsByTimeDisplay = new FlightsAroundTimeDisplay(
				flightQueryService);
		contentSelector.registerSwitchHandler(FlightsAroundTimeDisplay.DESC,
				flightsByTimeDisplay, tabContents);
		tabContents.add(flightsByTimeDisplay);

		tabContents.showWidget(0);
		return tabContents;
	}

}
