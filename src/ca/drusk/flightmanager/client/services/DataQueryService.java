package ca.drusk.flightmanager.client.services;

import ca.drusk.flightmanager.client.data.Relation;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the service which handles querying the database
 * 
 * @author drusk
 * 
 */
@RemoteServiceRelativePath("data-query")
public interface DataQueryService extends RemoteService {

	Relation getAirlines();

	Relation getCitizenships();

	Relation getPlaneModels();

	Relation getLocations();

	Relation getFlights();

	Relation getGates();

	Relation getArrivals();

	Relation getDepartures();

	Relation getPassengers();

	Relation getFlightInstances();

}
