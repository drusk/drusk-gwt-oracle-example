package ca.drusk.flightmanager.server.service_implementations;

import java.sql.Time;
import java.text.ParseException;

import ca.drusk.flightmanager.client.data.Relation;
import ca.drusk.flightmanager.client.services.FlightQueryService;
import ca.drusk.flightmanager.server.database.FlightDataQuerier;
import ca.drusk.flightmanager.server.table_formatting.DefaultTimeFormatter;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the {@link FlightQueryService}.
 * 
 * @author drusk
 * 
 */
public class FlightQueryServiceImpl extends RemoteServiceServlet implements
		FlightQueryService {

	private FlightDataQuerier dataQuerier = new FlightDataQuerier();

	private DefaultTimeFormatter timeFormatter = new DefaultTimeFormatter();

	@Override
	public Relation getOperatedFlights(String airlineCode) {
		return dataQuerier.getOperatedFlights(airlineCode);
	}

	@Override
	public Relation getIncomingAndOutgoingFlights(String airportCode) {
		return dataQuerier.getIncomingAndOutgoingFlights(airportCode);
	}

	@Override
	public Relation getPassengers(String flightInstanceId) {
		return dataQuerier.getPassengers(flightInstanceId);
	}

	@Override
	public Relation getBaggage(String passengerId, String flightId) {
		return dataQuerier.getBaggage(passengerId, flightId);
	}

	@Override
	public Relation getConnectingFlights(String maxWait) throws ParseException {
		Time maxWaitTime = timeFormatter.parseTime(maxWait);
		return dataQuerier.getConnectingFlights(maxWaitTime);
	}
}
