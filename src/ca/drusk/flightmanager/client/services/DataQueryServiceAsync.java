package ca.drusk.flightmanager.client.services;

import ca.drusk.flightmanager.shared.Relation;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The asynchronous counterpart of {@link DataQueryService}.
 * 
 * @author drusk
 * 
 */
public interface DataQueryServiceAsync {

	void getAirlines(AsyncCallback<Relation> callback);

}
