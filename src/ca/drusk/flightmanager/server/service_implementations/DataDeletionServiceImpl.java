package ca.drusk.flightmanager.server.service_implementations;

import ca.drusk.flightmanager.client.services.DataDeletionService;
import ca.drusk.flightmanager.server.database.DataDeleter;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the data entry service.
 * 
 * @author drusk
 * 
 */
public class DataDeletionServiceImpl extends RemoteServiceServlet implements
		DataDeletionService {

	private DataDeleter deleter = new DataDeleter();

	@Override
	public int removeAirline(String code) {
		return deleter.removeAirline(code);
	}

	@Override
	public int removePlaneModel(String code) {
		return deleter.removePlaneModel(code);
	}

	@Override
	public int removeCitizenship(String citizenship) {
		return deleter.removeCitizenship(citizenship);
	}

	@Override
	public int removeLocation(String airportCode) {
		return deleter.removeAirport(airportCode);
	}

	@Override
	public int removeFlight(String flightNumber) {
		int deleted = 0;
		int flightNumberInt = Integer.parseInt(flightNumber);
		deleted += deleter.removeIncomingFlight(flightNumberInt);
		deleted += deleter.removeOutgoingFlight(flightNumberInt);
		deleted += deleter.removeFlight(flightNumberInt);
		return deleted;
	}

	@Override
	public int removeGate(String gate, String airportCode) {
		return deleter.removeGate(gate, airportCode);
	}

	public static void main(String[] args) {
		DataDeleter deleter = new DataDeleter();
		int removeGate = deleter.removeGate("A10", "YYJ");
		System.out.println(removeGate);
	}

	@Override
	public int removeArrival(String id) {
		return deleter.removeArrival(id);
	}

	@Override
	public int removeDeparture(String id) {
		return deleter.removeDeparture(id);
	}

	@Override
	public int removePassenger(String id) {
		return deleter.removePassenger(id);
	}

	@Override
	public int removeFlightInstance(String id) {
		return deleter.removeFlightInstance(id);
	}

	@Override
	public int removePassengerFromFlight(String passengerId, String flightId) {
		return deleter.removePassengerFromFlight(Integer.parseInt(passengerId),
				Integer.parseInt(flightId));
	}

	@Override
	public int removeBaggage(String id) {
		return deleter.removeBaggage(id);
	}

	@Override
	public int removeBaggageForFlight(String passengerId, String flightId,
			String baggageId) {
		return deleter.removeBaggageForFlight(Integer.parseInt(passengerId),
				Integer.parseInt(flightId), Integer.parseInt(baggageId));
	}

	@Override
	public int removeGuardian(String guardianId, String infantId) {
		return deleter.removeGuardian(Integer.parseInt(guardianId),
				Integer.parseInt(infantId));
	}
}
