package ca.drusk.flightmanager.client.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the service which handles deletion of data from the
 * database
 * 
 * @author drusk
 * 
 */
@RemoteServiceRelativePath("data-deletion")
public interface DataDeletionService extends RemoteService {

	int removeAirline(String code);

	int removeCitizenship(String citizenship);

	int removePlaneModel(String code);

	int removeLocation(String airportCode);

	int removeFlight(String flightNumber);

	int removeGate(String gate, String airportCode);

	int removeArrival(String id);

	int removeDeparture(String id);

}
