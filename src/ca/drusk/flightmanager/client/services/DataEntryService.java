package ca.drusk.flightmanager.client.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the service which handles insertions of data into
 * the database.
 * 
 * @author drusk
 * 
 */
@RemoteServiceRelativePath("data-entry")
public interface DataEntryService extends RemoteService {

	int addAirline(String name, String code, String website);

	int addPlaneModel(String code, String capacity);

	int addCitizenship(String citizenship);

}
