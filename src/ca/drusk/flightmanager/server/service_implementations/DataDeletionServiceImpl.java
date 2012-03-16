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

	public static void main(String args[]) {
		DataDeleter deleter = new DataDeleter();
		int removePlane = deleter.removePlaneModel("450");
		System.out.println(removePlane);
	}

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
		return deleter.removeLocation(airportCode);
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

}
