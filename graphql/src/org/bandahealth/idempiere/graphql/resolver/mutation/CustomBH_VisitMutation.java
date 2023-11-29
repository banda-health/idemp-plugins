package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.graphql.model.input.BH_VisitInput;

public class CustomBH_VisitMutation extends BH_VisitMutation {
	@Override
	public MBHVisit BH_VisitSave(BH_VisitInput visitInput, DataFetchingEnvironment environment) {
		super.BH_VisitSave(visitInput);
		// Update the cache if anything there
		environment.getCacheControl();
		CustomBH_EncounterMutation.BH_EncounterSave();
	}

	public MBHVisit BH_VisitProcess(String uuid) {
		// Update the cache if anything there
	}
}
