package ca.drusk.flightmanager.server.service_implementations;

import java.text.ParseException;

import ca.drusk.flightmanager.client.services.DataEntryService;
import ca.drusk.flightmanager.server.database.DataInserter;
import ca.drusk.flightmanager.server.database.DataValueQuerier;
import ca.drusk.flightmanager.server.util.datetime.DateTimeFormatter;
import ca.drusk.flightmanager.server.util.datetime.DefaultDayFormatter;
import ca.drusk.flightmanager.server.util.datetime.DefaultTimeFormatter;
import ca.drusk.flightmanager.server.util.datetime.OracleTimeStampUtils;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the data entry service.
 * 
 * @author drusk
 * 
 */
public class DataEntryServiceImpl extends RemoteServiceServlet implements
		DataEntryService {

	/*
	 * This is the default day used when storing times (which we don't care
	 * about the day for, but need to be consistent).
	 */
	private String DEFAULT_DAY = "Jan 15, 1980";

	private DataInserter inserter = new DataInserter();

	private DataValueQuerier querier = new DataValueQuerier();

	private DefaultTimeFormatter timeFormatter = new DefaultTimeFormatter();

	private DefaultDayFormatter dayFormatter = new DefaultDayFormatter();

	private DateTimeFormatter dateTimeFormatter = new DateTimeFormatter();

	@Override
	public int addAirline(String name, String code, String website) {
		return inserter.addAirline(name, code, website);
	}

	@Override
	public int addPlaneModel(String code, String capacity) {
		return inserter.addPlaneModel(Integer.parseInt(code),
				Integer.parseInt(capacity));
	}

	@Override
	public int addCitizenship(String citizenship) {
		return inserter.addCitizenship(citizenship);
	}

	@Override
	public int addAirport(String airportCode, String city, String country,
			int utcOffset) {
		return inserter.addAirport(airportCode, city, country, utcOffset);
	}

	@Override
	public int addFlight(String flightNumber, String source,
			String destination, String airlineCode, String planeCode,
			String plannedArrivalTime, String plannedDepartureTime)
			throws ParseException {

		System.out.println("airline code=" + airlineCode);
		System.out.println("source= " + source);
		System.out.println("dest= " + destination);
		String formattedDepartureTime = OracleTimeStampUtils
				.toTimeStampWithTimeZone(DEFAULT_DAY, plannedDepartureTime,
						querier.getUtcOffset(source));
		String formattedArrivalTime = OracleTimeStampUtils
				.toTimeStampWithTimeZone(DEFAULT_DAY, plannedArrivalTime,
						querier.getUtcOffset(destination));

		return inserter.addFlight(airlineCode, Integer.parseInt(flightNumber),
				source, destination, Integer.parseInt(planeCode),
				formattedDepartureTime, formattedArrivalTime);
	}

	@Override
	public int addGate(String gate, String airportCode) {
		return inserter.addGate(gate, airportCode);
	}

	@Override
	public int addArrival(String id, String gate, String airportCode,
			String arrivalDay, String arrivalTime, String status)
			throws ParseException {

		int utcOffset = querier.getUtcOffset(airportCode);
		String arrivalDate = OracleTimeStampUtils.toTimeStampWithTimeZone(
				arrivalDay, arrivalTime, utcOffset);
		return inserter.addArrival(Integer.parseInt(id), gate, airportCode,
				arrivalDate, status);
	}

	@Override
	public int addDeparture(String id, String gate, String airportCode,
			String departureDay, String departureTime, String status)
			throws ParseException {

		int utcOffset = querier.getUtcOffset(airportCode);
		String departureDate = OracleTimeStampUtils.toTimeStampWithTimeZone(
				departureDay, departureTime, utcOffset);
		return inserter.addDeparture(Integer.parseInt(id), gate, airportCode,
				departureDate, status);
	}

	@Override
	public int addPassenger(String firstName, String lastName,
			String citizenship, String placeOfBirth, String dateOfBirth)
			throws ParseException {
		return inserter.addPassenger(firstName, lastName, citizenship,
				placeOfBirth, dayFormatter.parseDay(dateOfBirth));
	}

	@Override
	public int addFlightInstance(String flightNumber) {
		return inserter.addFlightInstance(Integer.parseInt(flightNumber));
	}

	@Override
	public int addPassengerToFlight(String passengerId, String flightId,
			String travelClass) {
		return inserter.addPassengerToFlight(Integer.parseInt(passengerId),
				Integer.parseInt(flightId), travelClass);
	}

	@Override
	public int addBaggage(String weight) {
		return inserter.addBaggage(Double.parseDouble(weight));
	}

	@Override
	public int addBaggageForFlight(String passengerId, String flightId,
			String baggageId) {
		return inserter.addBaggageForFlight(Integer.parseInt(passengerId),
				Integer.parseInt(flightId), Integer.parseInt(baggageId));
	}

	@Override
	public int addGuardian(String guardianId, String infantId) {
		return inserter.addGuardian(Integer.parseInt(guardianId),
				Integer.parseInt(infantId));
	}
}
