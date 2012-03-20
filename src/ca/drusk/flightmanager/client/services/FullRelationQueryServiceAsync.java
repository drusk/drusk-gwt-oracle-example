package ca.drusk.flightmanager.client.services;

import ca.drusk.flightmanager.client.data.Relation;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The asynchronous counterpart of {@link FullRelationQueryService}.
 * 
 * @author drusk
 * 
 */
public interface FullRelationQueryServiceAsync {

	void getAirlines(AsyncCallback<Relation> callback);

	void getPlaneModels(AsyncCallback<Relation> callback);

	void getCitizenships(AsyncCallback<Relation> callback);

	void getLocations(AsyncCallback<Relation> callback);

	void getFlights(AsyncCallback<Relation> callback);

	void getGates(AsyncCallback<Relation> callback);

	void getArrivals(AsyncCallback<Relation> callback);

	void getDepartures(AsyncCallback<Relation> callback);

	void getPassengers(AsyncCallback<Relation> callback);

	void getFlightInstances(AsyncCallback<Relation> callback);

	void getFlightAttendance(AsyncCallback<Relation> callback);

	void getBaggage(AsyncCallback<Relation> callback);

	void getFlightInventory(AsyncCallback<Relation> callback);

	void getGuardians(AsyncCallback<Relation> callback);

}
