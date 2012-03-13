package ca.drusk.flightmanager.server.service_implementations;

import ca.drusk.flightmanager.client.data.Relation;
import ca.drusk.flightmanager.client.services.DataQueryService;
import ca.drusk.flightmanager.server.database.DataQuerier;

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

	@Override
	public Relation getPlaneModels() {
		return dataQuerier.getPlaneModelsFullRelation();
	}

}
