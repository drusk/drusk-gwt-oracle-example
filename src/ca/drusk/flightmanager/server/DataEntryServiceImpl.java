package ca.drusk.flightmanager.server;

import ca.drusk.flightmanager.client.services.DataEntryService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the data entry service.
 * 
 * @author drusk
 * 
 */
public class DataEntryServiceImpl extends RemoteServiceServlet implements
		DataEntryService {

	private DataInserter inserter = new DataInserter();

	public static void main(String args[]) {
		DataInserter inserter = new DataInserter();
		int addAirline = inserter.addAirline("AirCanada", "AC",
				"www.aircanada.ca");
		System.out.println(addAirline);
	}

	@Override
	public int addAirline(String name, String code, String website) {
		return inserter.addAirline(name, code, website);
	}

}
