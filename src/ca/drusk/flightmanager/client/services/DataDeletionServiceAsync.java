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

	void removeFlight(String flightNumber, AsyncCallback<Integer> callback);

	void removeGate(String gate, String airportCode,
			AsyncCallback<Integer> callback);

	void removeArrival(String id, AsyncCallback<Integer> callback);

	void removeDeparture(String id, AsyncCallback<Integer> callback);

	void removePassenger(String id, AsyncCallback<Integer> callback);

	void removeFlightInstance(String id, AsyncCallback<Integer> callback);

}
