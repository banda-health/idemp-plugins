package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.bandahealth.idempiere.graphql.model.input.M_M_InOutInput;

import java.util.List;

public class X_M_InOutMutation implements GraphQLMutationResolver {
	public MInOut_BH M_InOutSave(M_M_InOutInput input) {
		input.saveEx();
		// get by uuid for visit input
		return input;
	}

	public boolean M_InOutDelete(List<String> uuids) {
		return true;
	}
}
