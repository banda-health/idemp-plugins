package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.model.input.M_AD_UserInput;

import java.util.List;

public class X_AD_UserMutation implements GraphQLMutationResolver {
	public MUser_BH AD_UserSave(M_AD_UserInput input) {
		input.saveEx();
		// get by uuid for visit input
		return input;
	}

	public boolean AD_UserDelete(List<String> uuids) {
		return true;
	}
}
