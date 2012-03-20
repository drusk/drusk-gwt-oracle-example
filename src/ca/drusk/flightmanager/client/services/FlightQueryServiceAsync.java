package ca.drusk.flightmanager.client.services;

import ca.drusk.flightmanager.client.data.Relation;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The asynchronous counterpart of {@link FlightQueryService}.
 * 
 * @author drusk
 * 
 */
public interface FlightQueryServiceAsync {

	void getOperatedFlights(String airlineCode, AsyncCallback<Relation> callback);

	void getIncomingAndOutgoingFlights(String airportCode,
			AsyncCallback<Relation> callback);

	void getPassengers(String flightInstanceId, AsyncCallback<Relation> callback);

	void getBaggage(String passengerId, String flightId,
			AsyncCallback<Relation> callback);

	void getConnectingFlights(String maxWait, AsyncCallback<Relation> callback);

}