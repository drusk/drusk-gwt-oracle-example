package ca.drusk.flightmanager.server;

import ca.drusk.flightmanager.client.services.DataQueryService;
import ca.drusk.flightmanager.shared.Relation;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the database querying service
 * 
 * @author drusk
 * 
 */
public class DataQueryServiceImpl extends RemoteServiceServlet implements
		DataQueryService {

	@Override
	public Relation getAirlines() {
		// TODO Auto-generated method stub
		return null;
	}

}
