package ca.drusk.flightmanager.client.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the service which handles insertions of data into
 * the database.
 * 
 * @author drusk
 * 
 */
@RemoteServiceRelativePath("data-entry")
public interface DataEntryService extends RemoteService {

	int addAirline(String name, String code, String website);

	int addPlaneModel(String code, String name, String capacity);

	int addCitizenship(String citizenship);

	int addAirport(String airportCode, String city, String country,
			String utcOffset);

	int addFlight(String flightNumber, String source, String destination,
			String airlineCode, String planeCode, String plannedArrivalTime,
			String plannedDepartureTime) throws Exception;

	int addGate(String gate, String airportCode);

	int addArrival(String airlineCode, String flightNumber,
			String plannedDepartureDay, String gate, String arrivalDay,
			String arrivalTime, String status) throws Exception;

	int addDeparture(String airlineCode, String flightNumber,
			String plannedDepartureDay, String gate, String departureDay,
			String departureTime, String status) throws Exception;

	int addPassenger(String firstName, String lastName, String citizenship,
			String placeOfBirth, String dateOfBirth,
			String dietaryRestrictions, String medicalConsiderations,
			String isAirlineEmployee, String isDoctor, String isInfant,
			String guardian) throws Exception;

	int addFlightInstance(String airlineCode, String flightNumber,
			String flightDate);

	int addPassengerToFlight(String passengerId, String flightId,
			String travelClass);

	int addBaggage(String ownerId, String weight);

	int addBaggageForFlight(String flightId, String baggageId);

	int addGuardian(String guardianId, String infantId);

	int addPassengerClass(String travelClass, String includesMeal);

}
