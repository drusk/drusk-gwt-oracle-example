package ca.drusk.flightmanager.client.services;

import ca.drusk.flightmanager.shared.Relation;

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

}
