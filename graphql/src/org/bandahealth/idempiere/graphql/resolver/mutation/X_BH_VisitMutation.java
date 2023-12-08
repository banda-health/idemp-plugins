package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.graphql.model.input.M_BH_VisitInput;

import java.util.List;

public class X_BH_VisitMutation implements GraphQLMutationResolver {
	public MBHVisit BH_VisitSave(M_BH_VisitInput visitInput) {
		visitInput.saveEx();
		return visitInput;
	}

	public boolean BH_VisitDelete(List<String> uuids) {
		return true;
	}
}
