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

	void getMostFrequentPassengers(String topN, AsyncCallback<Relation> callback);

	void getPassengersInTransit(AsyncCallback<Relation> callback);

	void getDeparturesAroundTime(String targetTime, String bufferTime,
			AsyncCallback<Relation> callback);

	void getMostDelayedAirlines(AsyncCallback<Relation> callback);

	void getArrivalsAroundTime(String targetTime, String bufferTime,
			AsyncCallback<Relation> callback);

}
