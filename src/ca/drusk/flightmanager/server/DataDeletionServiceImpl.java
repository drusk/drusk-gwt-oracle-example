package ca.drusk.flightmanager.server;

import ca.drusk.flightmanager.client.services.DataDeletionService;

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
		int removeAirline = deleter.removeAirline("AC");
		System.out.println(removeAirline);
	}

	@Override
	public int removeAirline(String code) {
		return deleter.removeAirline(code);
	}

}
