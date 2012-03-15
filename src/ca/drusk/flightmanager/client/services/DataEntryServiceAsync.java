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

}
