package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import org.bandahealth.idempiere.graphql.model.input.M_AD_OrgInput;
import org.compiere.model.MOrg;

import java.util.List;

public class X_AD_OrgMutation implements GraphQLMutationResolver {
	public MOrg AD_OrgSave(M_AD_OrgInput input) {
		input.saveEx();
		// get by uuid for visit input
		return input;
	}

	public boolean AD_OrgDelete(List<String> uuids) {
		return true;
	}
}
