package ca.drusk.flightmanager.client.services;

import ca.drusk.flightmanager.client.data.Relation;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The asynchronous counterpart of {@link DataQueryService}.
 * 
 * @author drusk
 * 
 */
public interface DataQueryServiceAsync {

	void getAirlines(AsyncCallback<Relation> callback);

	void getPlaneModels(AsyncCallback<Relation> callback);

	void getCitizenships(AsyncCallback<Relation> callback);

	void getLocations(AsyncCallback<Relation> callback);

	void getFlights(AsyncCallback<Relation> callback);

	void getGates(AsyncCallback<Relation> callback);

	void getArrivals(AsyncCallback<Relation> callback);

	void getDepartures(AsyncCallback<Relation> callback);

}
