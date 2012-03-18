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

	void addPlaneModel(String code, String capacity,
			AsyncCallback<Integer> callback);

	void addCitizenship(String citizenship, AsyncCallback<Integer> callback);

	void addLocation(String airportCode, String city, String country,
			int utcOffset, AsyncCallback<Integer> callback);

	void addFlight(String flightNumber, String source, String destination,
			String airlineCode, String planeCode, String plannedArrivalTime,
			String plannedDepartureTime, AsyncCallback<Integer> callback);

	void addGate(String gate, String airportCode,
			AsyncCallback<Integer> callback);

	void addArrival(String gate, String airportCode, String arrivalDay,
			String arrivalTime, String status, String flightNumber,
			AsyncCallback<Integer> callback);

	void addDeparture(String gate, String airportCode, String departureDay,
			String departureTime, String status, String flightNumber,
			AsyncCallback<Integer> callback);

}
