package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.graphql.model.input.BH_VisitInput;

public class BH_VisitMutation implements GraphQLMutationResolver {
	public MBHVisit BH_VisitSave(BH_VisitInput visitInput) {
		visitInput.saveEx();
		// get by uuid for visit input
	}

	public MOrder_BH process(String id) {

	}
}
