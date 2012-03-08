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

}
