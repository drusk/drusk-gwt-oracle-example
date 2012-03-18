package ca.drusk.flightmanager.server.service_implementations;

import java.text.ParseException;

import ca.drusk.flightmanager.client.services.DataEntryService;
import ca.drusk.flightmanager.server.database.DataInserter;
import ca.drusk.flightmanager.server.table_formatting.DateTimeFormatter;
import ca.drusk.flightmanager.server.table_formatting.DefaultDayFormatter;
import ca.drusk.flightmanager.server.table_formatting.DefaultTimeFormatter;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the data entry service.
 * 
 * @author drusk
 * 
 */
public class DataEntryServiceImpl extends RemoteServiceServlet implements
		DataEntryService {

	private DataInserter inserter = new DataInserter();

	private DefaultTimeFormatter timeFormatter = new DefaultTimeFormatter();

	private DefaultDayFormatter dayFormatter = new DefaultDayFormatter();

	private DateTimeFormatter dateTimeFormatter = new DateTimeFormatter();

	public static void main(String args[]) {
		DataInserter inserter = new DataInserter();
		int addAirline = inserter.addAirline("AirCanada", "AC",
				"www.aircanada.ca");
		System.out.println(addAirline);
	}

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
		int inserted = 0;

		int flightNumberInt = Integer.parseInt(flightNumber);
		inserted += inserter.addFlight(flightNumberInt, source, destination,
				airlineCode, Integer.parseInt(planeCode));
		inserted += inserter.addIncomingFlight(flightNumberInt,
				timeFormatter.parseTime(plannedArrivalTime));
		inserted += inserter.addOutgoingFlight(flightNumberInt,
				timeFormatter.parseTime(plannedDepartureTime));

		return inserted;
	}

	@Override
	public int addGate(String gate, String airportCode) {
		return inserter.addGate(gate, airportCode);
	}

	@Override
	public int addArrival(String id, String gate, String airportCode,
			String arrivalDay, String arrivalTime, String status)
			throws ParseException {
		return inserter.addArrival(Integer.parseInt(id), gate, airportCode,
				dateTimeFormatter.parseDateTime(arrivalDay, arrivalTime),
				status);
	}

	@Override
	public int addDeparture(String id, String gate, String airportCode,
			String departureDay, String departureTime, String status)
			throws ParseException {
		return inserter.addDeparture(Integer.parseInt(id), gate, airportCode,
				dateTimeFormatter.parseDateTime(departureDay, departureTime),
				status);
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
}
