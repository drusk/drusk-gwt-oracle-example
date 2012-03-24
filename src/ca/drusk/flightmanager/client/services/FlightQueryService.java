package ca.drusk.flightmanager.client.services;

import ca.drusk.flightmanager.client.data.Relation;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the service which performs business-oriented queries
 * about flights.
 * 
 * @author drusk
 * 
 */
@RemoteServiceRelativePath("flight-query")
public interface FlightQueryService extends RemoteService {

	Relation getOperatedFlights(String airlineCode);

	Relation getIncomingAndOutgoingFlights(String airportCode);

	Relation getDeparturesAroundTime(String targetTime, String bufferTime)
			throws Exception;

	Relation getArrivalsAroundTime(String targetTime, String bufferTime)
			throws Exception;

	Relation getPassengers(String flightInstanceId);

	Relation getBaggage(String passengerId, String flightId);

	Relation getConnectingFlights(String maxWait) throws Exception;

	Relation getMostFrequentPassengers(String topN);

	Relation getPassengersInTransit();

	Relation getMostDelayedAirlines();

}
