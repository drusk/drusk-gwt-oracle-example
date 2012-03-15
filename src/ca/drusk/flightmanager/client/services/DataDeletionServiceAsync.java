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

}
