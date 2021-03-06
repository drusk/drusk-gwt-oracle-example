package ca.drusk.flightmanager.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The asynchronous counterpart of {@link DataDeletionService}.
 * 
 * @author drusk
 * 
 */
public interface DataDeletionServiceAsync {

	void removeAirline(String code, AsyncCallback<Integer> callback);

	void removePlaneModel(String code, AsyncCallback<Integer> callback);

	void removeCitizenship(String citizenship, AsyncCallback<Integer> callback);

	void removeLocation(String airportCode, AsyncCallback<Integer> callback);

	void removeFlight(String airlineCode, String flightNumber,
			AsyncCallback<Integer> callback);

	void removeGate(String gate, String airportCode,
			AsyncCallback<Integer> callback);

	void removeArrival(String id, AsyncCallback<Integer> callback);

	void removeDeparture(String id, AsyncCallback<Integer> callback);

	void removePassenger(String id, AsyncCallback<Integer> callback);

	void removeFlightInstance(String id, AsyncCallback<Integer> callback);

	void removePassengerFromFlight(String passengerId, String flightId,
			AsyncCallback<Integer> callback);

	void removeBaggage(String id, AsyncCallback<Integer> callback);

	void removeBaggageForFlight(String flightId, String baggageId,
			AsyncCallback<Integer> callback);

	void removeGuardian(String guardianId, String infantId,
			AsyncCallback<Integer> callback);

	void removePassengerClass(String passengerClass,
			AsyncCallback<Integer> loggingCallback);

}
