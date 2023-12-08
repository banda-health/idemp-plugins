package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import org.bandahealth.idempiere.graphql.model.input.M_AD_Ref_ListInput;
import org.compiere.model.MRefList;

import java.util.List;

public class X_AD_Ref_ListMutation implements GraphQLMutationResolver {
	public MRefList AD_Ref_ListSave(M_AD_Ref_ListInput input) {
		input.saveEx();
		// get by uuid for visit input
		return input;
	}

	public boolean AD_Ref_ListDelete(List<String> uuids) {
		return true;
	}
}
