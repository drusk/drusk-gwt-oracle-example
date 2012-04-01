package ca.drusk.flightmanager.server.service_implementations;

import java.sql.Time;
import java.text.ParseException;

import ca.drusk.flightmanager.client.data.Relation;
import ca.drusk.flightmanager.client.services.FlightQueryService;
import ca.drusk.flightmanager.server.database.DataValueQuerier;
import ca.drusk.flightmanager.server.database.FlightDataQuerier;
import ca.drusk.flightmanager.server.util.datetime.DefaultTimeFormatter;
import ca.drusk.flightmanager.server.util.datetime.TimeStampUtils;
import ca.drusk.flightmanager.server.util.datetime.TimeUtils;

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

	private DataValueQuerier valueQuerier = new DataValueQuerier();

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
	public Relation getConnectingFlights(String airportCode, String maxWait)
			throws ParseException {
		Time maxWaitTime = timeFormatter.parseTime(maxWait);
		System.out.println("time= " + maxWaitTime);
		int convertToMinutes = TimeUtils.convertToMinutes(maxWaitTime);
		System.out.println("Minutes= " + convertToMinutes);
		return dataQuerier.getConnectingFlights(airportCode, convertToMinutes);
	}

	@Override
	public Relation getMostFrequentPassengers(String topN) {
		return dataQuerier.getMostFrequentPassengers(Integer.parseInt(topN));
	}

	@Override
	public Relation getPassengersInTransit() {
		return dataQuerier.getPassengersInTransit();
	}

	@Override
	public Relation getDeparturesAroundTime(String targetTimeStr,
			String bufferTimeStr, String airportCode) throws ParseException {

		// System.out.println("Get departures airport code=" + airportCode);
		String utcOffset = valueQuerier.getUtcOffset(airportCode);
		// System.out.println("Get departures utcOffset=" + utcOffset);
		String targetTime = TimeStampUtils.toTimeStampWithTimeZone(
				DataEntryServiceImpl.DEFAULT_DAY, targetTimeStr, utcOffset);

		// Time targetTime = timeFormatter.parseTime(targetTimeStr);
		Time bufferTime = timeFormatter.parseTime(bufferTimeStr);
		return dataQuerier.getDeparturesAround(airportCode, targetTime,
				TimeUtils.convertToMinutes(bufferTime));
	}

	@Override
	public Relation getMostDelayedAirlines() {
		return dataQuerier.getMostDelayedAirlines();
	}

	@Override
	public Relation getArrivalsAroundTime(String targetTimeStr,
			String bufferTimeStr, String airportCode) throws ParseException {

		// System.out.println("Get arrivals airport code=" + airportCode);
		String utcOffset = valueQuerier.getUtcOffset(airportCode);
		// System.out.println("Get arrivals utcOffset=" + utcOffset);
		String targetTime = TimeStampUtils.toTimeStampWithTimeZone(
				DataEntryServiceImpl.DEFAULT_DAY, targetTimeStr, utcOffset);

		Time bufferTime = timeFormatter.parseTime(bufferTimeStr);
		return dataQuerier.getArrivalsAround(airportCode, targetTime,
				TimeUtils.convertToMinutes(bufferTime));
	}
}
