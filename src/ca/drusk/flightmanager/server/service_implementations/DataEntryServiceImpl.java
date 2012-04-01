package ca.drusk.flightmanager.server.service_implementations;

import java.text.ParseException;

import ca.drusk.flightmanager.client.services.DataEntryService;
import ca.drusk.flightmanager.server.database.DataInserter;
import ca.drusk.flightmanager.server.database.DataValueQuerier;
import ca.drusk.flightmanager.server.util.datetime.DefaultDayFormatter;
import ca.drusk.flightmanager.server.util.datetime.TimeStampUtils;

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
	public static String DEFAULT_DAY = "Jan 15, 1980";

	private DataInserter inserter = new DataInserter();

	private DataValueQuerier querier = new DataValueQuerier();

	private DefaultDayFormatter dayFormatter = new DefaultDayFormatter();

	@Override
	public int addAirline(String name, String code, String website) {
		return inserter.addAirline(name, code, website);
	}

	@Override
	public int addPlaneModel(String code, String name, String capacity) {
		return inserter.addPlaneModel(code, name, Integer.parseInt(capacity));
	}

	@Override
	public int addCitizenship(String citizenship) {
		return inserter.addCitizenship(citizenship);
	}

	@Override
	public int addAirport(String airportCode, String city, String country,
			String utcOffset) {
		return inserter.addAirport(airportCode, city, country, utcOffset);
	}

	@Override
	public int addFlight(String flightNumber, String source,
			String destination, String airlineCode, String planeCode,
			String plannedArrivalTime, String plannedDepartureTime)
			throws ParseException {

		String formattedDepartureTime = TimeStampUtils
				.toTimeStampWithTimeZone(DEFAULT_DAY, plannedDepartureTime,
						querier.getUtcOffset(source));
		String formattedArrivalTime = TimeStampUtils.toTimeStampWithTimeZone(
				DEFAULT_DAY, plannedArrivalTime,
				querier.getUtcOffset(destination));

		return inserter.addFlight(airlineCode, Integer.parseInt(flightNumber),
				source, destination, planeCode, formattedDepartureTime,
				formattedArrivalTime);
	}

	@Override
	public int addGate(String gate, String airportCode) {
		return inserter.addGate(gate, airportCode);
	}

	@Override
	public int addArrival(String airlineCode, String flightNumber,
			String plannedDepartureDay, String gate, String airportCode,
			String arrivalDay, String arrivalTime, String status)
			throws ParseException {

		int flightInstanceId = getFlightInstanceId(airlineCode, flightNumber,
				plannedDepartureDay);

		String utcOffset = querier.getUtcOffset(airportCode);
		String arrivalDate = TimeStampUtils.toTimeStampWithTimeZone(arrivalDay,
				arrivalTime, utcOffset);
		return inserter.addArrival(flightInstanceId, gate, airportCode,
				arrivalDate, status);
	}

	@Override
	public int addDeparture(String airlineCode, String flightNumber,
			String plannedDepartureDay, String gate, String airportCode,
			String departureDay, String departureTime, String status)
			throws ParseException {

		int flightInstanceId = getFlightInstanceId(airlineCode, flightNumber,
				plannedDepartureDay);

		String utcOffset = querier.getUtcOffset(airportCode);
		String departureDate = TimeStampUtils.toTimeStampWithTimeZone(
				departureDay, departureTime, utcOffset);
		return inserter.addDeparture(flightInstanceId, gate, airportCode,
				departureDate, status);
	}

	/**
	 * Retrieves the flight instance id for the specified airline code, flight
	 * number and date. If no flight instance exists yet, it creates it in the
	 * database first.
	 */
	private int getFlightInstanceId(String airlineCode, String flightNumber,
			String plannedDepartureDay) {
		int flightNumberInt = Integer.parseInt(flightNumber);
		int flightInstanceId = querier.getFlightInstanceId(airlineCode,
				flightNumberInt, plannedDepartureDay);
		System.out.println("Flight instance id=" + flightInstanceId);
		if (flightInstanceId < 0) {
			inserter.addFlightInstance(airlineCode, flightNumberInt,
					plannedDepartureDay);
			flightInstanceId = querier.getFlightInstanceId(airlineCode,
					flightNumberInt, plannedDepartureDay);
			System.out.println("Flight instance id=" + flightInstanceId);
		}
		return flightInstanceId;
	}

	@Override
	public int addPassenger(String firstName, String lastName,
			String citizenship, String placeOfBirth, String dateOfBirth,
			String dietaryRestrictions, String medicalConsiderations,
			String isAirlineEmployee, String isDoctor, String isInfant,
			String guardianId) throws ParseException {
		int modCount = 0;
		modCount += inserter.addPassenger(firstName, lastName, citizenship,
				placeOfBirth, dayFormatter.parseDay(dateOfBirth));
		if (isInfant.equals("y")) {
			modCount += inserter.addInfant(querier.getPassengerId(firstName,
					lastName, placeOfBirth, dateOfBirth), Integer
					.parseInt(guardianId));
		}
		return modCount;
	}

	@Override
	public int addFlightInstance(String airlineCode, String flightNumber,
			String flightDate) {
		return inserter.addFlightInstance(airlineCode,
				Integer.parseInt(flightNumber), flightDate);
	}

	@Override
	public int addPassengerToFlight(String passengerId, String flightId,
			String travelClass) {
		return inserter.addPassengerToFlight(Integer.parseInt(passengerId),
				Integer.parseInt(flightId), travelClass);
	}

	@Override
	public int addBaggage(String ownerId, String weight) {
		return inserter.addBaggage(Integer.parseInt(ownerId),
				Double.parseDouble(weight));
	}

	@Override
	public int addBaggageForFlight(String flightId, String baggageId) {
		return inserter.addBaggageForFlight(Integer.parseInt(flightId),
				Integer.parseInt(baggageId));
	}

	@Override
	public int addGuardian(String guardianId, String infantId) {
		return inserter.addGuardian(Integer.parseInt(guardianId),
				Integer.parseInt(infantId));
	}

	@Override
	public int addPassengerClass(String travelClass, String includesMeal) {
		return inserter.addPassengerClass(travelClass, includesMeal);
	}
}
