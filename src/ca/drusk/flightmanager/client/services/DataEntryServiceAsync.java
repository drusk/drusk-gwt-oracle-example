package ca.drusk.flightmanager.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The asynchronous counterpart of {@link DataEntryService}.
 * 
 * @author drusk
 * 
 */
public interface DataEntryServiceAsync {

	void addAirline(String name, String code, String website,
			AsyncCallback<Integer> callback);

	void addPlaneModel(String code, String name, String capacity,
			AsyncCallback<Integer> callback);

	void addCitizenship(String citizenship, AsyncCallback<Integer> callback);

	void addAirport(String airportCode, String city, String country,
			String utcOffset, AsyncCallback<Integer> callback);

	void addFlight(String flightNumber, String source, String destination,
			String airlineCode, String planeCode, String plannedArrivalTime,
			String plannedDepartureTime, AsyncCallback<Integer> callback);

	void addGate(String gate, String airportCode,
			AsyncCallback<Integer> callback);

	void addArrival(String airlineCode, String flightNumber,
			String plannedDepartureDate, String gate, String arrivalDay,
			String arrivalTime, String status, AsyncCallback<Integer> callback);

	void addDeparture(String airlineCode, String flightNumber,
			String plannedDepartureDay, String gate, String departureDay,
			String departureTime, String status, AsyncCallback<Integer> callback);

	void addPassenger(String firstName, String lastName, String citizenship,
			String placeOfBirth, String dateOfBirth,
			String dietaryRestrictions, String medicalConsiderations,
			String isAirlineEmployee, String isDoctor, String isInfant,
			String guardian, AsyncCallback<Integer> callback);

	void addFlightInstance(String airlineCode, String flightNumber,
			String flightDate, AsyncCallback<Integer> callback);

	void addPassengerToFlight(String passengerId, String flightId,
			String travelClass, AsyncCallback<Integer> callback);

	void addBaggage(String ownerId, String weight,
			AsyncCallback<Integer> callback);

	void addBaggageForFlight(String flightId, String baggageId,
			AsyncCallback<Integer> callback);

	void addGuardian(String guardianId, String infantId,
			AsyncCallback<Integer> callback);

	void addPassengerClass(String travelClass, String includesMeal,
			AsyncCallback<Integer> loggingCallback);

}
