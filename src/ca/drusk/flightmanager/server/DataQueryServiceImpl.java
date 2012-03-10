package ca.drusk.flightmanager.server;

import ca.drusk.flightmanager.client.data.Relation;
import ca.drusk.flightmanager.client.services.DataQueryService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the database querying service
 * 
 * @author drusk
 * 
 */
public class DataQueryServiceImpl extends RemoteServiceServlet implements
		DataQueryService {

	private DataQuerier dataQuerier = new DataQuerier();

	@Override
	public Relation getAirlines() {
		return dataQuerier.getAirlineFullRelation();
	}

}
