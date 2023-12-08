package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import org.bandahealth.idempiere.base.model.MBHEncounter;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.graphql.model.input.M_BH_EncounterInput;
import org.bandahealth.idempiere.graphql.model.input.M_BH_VisitInput;

import java.util.List;

public class X_BH_EncounterMutation implements GraphQLMutationResolver {
	public MBHEncounter BH_EncounterSave(M_BH_EncounterInput input) {
		input.saveEx();
		// get by uuid for visit input
		return input;
	}

	public boolean BH_EncounterDelete(List<String> uuids) {
		return true;
	}
}
