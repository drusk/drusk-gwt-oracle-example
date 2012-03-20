package ca.drusk.flightmanager.server.service_implementations;

import ca.drusk.flightmanager.client.data.Relation;
import ca.drusk.flightmanager.client.services.FullRelationQueryService;
import ca.drusk.flightmanager.server.database.FullRelationDataQuerier;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the database querying service
 * 
 * @author drusk
 * 
 */
public class FullRelationQueryServiceImpl extends RemoteServiceServlet implements
		FullRelationQueryService {

	private FullRelationDataQuerier dataQuerier = new FullRelationDataQuerier();

	@Override
	public Relation getAirlines() {
		return dataQuerier.getAirlineFullRelation();
	}

	@Override
	public Relation getPlaneModels() {
		return dataQuerier.getPlaneModelsFullRelation();
	}

	@Override
	public Relation getCitizenships() {
		return dataQuerier.getCitizenshipsFullRelation();
	}

	@Override
	public Relation getLocations() {
		return dataQuerier.getAirportsFullRelation();
	}

	@Override
	public Relation getFlights() {
		return dataQuerier.getFlightsIncomingOutgoingFullRelation();
	}

	@Override
	public Relation getGates() {
		return dataQuerier.getGatesFullRelation();
	}

	@Override
	public Relation getArrivals() {
		return dataQuerier.getArrivalsFullRelation();
	}

	@Override
	public Relation getDepartures() {
		return dataQuerier.getDepartureFullRelation();
	}

	@Override
	public Relation getPassengers() {
		return dataQuerier.getPassengersFullRelation();
	}

	@Override
	public Relation getFlightInstances() {
		return dataQuerier.getFlightInstances();
	}

	@Override
	public Relation getFlightAttendance() {
		return dataQuerier.getFlightAttendanceFullRelation();
	}

	@Override
	public Relation getBaggage() {
		return dataQuerier.getBaggageFullRelation();
	}

	@Override
	public Relation getFlightInventory() {
		return dataQuerier.getFlightInventoryFullRelation();
	}

	@Override
	public Relation getGuardians() {
		return dataQuerier.getGuardiansFullRelation();
	}

}
