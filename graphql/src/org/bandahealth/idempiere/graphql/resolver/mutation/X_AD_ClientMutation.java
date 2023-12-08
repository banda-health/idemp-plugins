package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import org.bandahealth.idempiere.base.model.MClient_BH;
import org.bandahealth.idempiere.graphql.model.input.M_AD_ClientInput;

import java.util.List;

public class X_AD_ClientMutation implements GraphQLMutationResolver {
	public MClient_BH AD_ClientSave(M_AD_ClientInput input) {
		input.saveEx();
		// get by uuid for visit input
		return input;
	}

	public boolean AD_ClientDelete(List<String> uuids) {
		return true;
	}
}
