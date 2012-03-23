package ca.drusk.flightmanager.client.ui.main_pages.data_display.full_relations;

import ca.drusk.flightmanager.client.services.FullRelationQueryServiceAsync;
import ca.drusk.flightmanager.client.table_data.TableNames;

/**
 * Display for data from the Guardians table.
 * 
 * @author drusk
 * 
 */
public class GuardiansDisplay extends AbstractFullRelationDisplay {

	public GuardiansDisplay(FullRelationQueryServiceAsync dataQueryService) {
		super(TableNames.GUARDIANS, dataQueryService);
	}

	@Override
	protected void retrieveResultsAndAddToDisplay() {
		dataQueryService.getGuardians(new TableGeneratingCallback());
	}

}
