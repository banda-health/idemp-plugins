package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import org.bandahealth.idempiere.base.model.MBHVoidedReason;
import org.bandahealth.idempiere.graphql.model.input.M_BH_Voided_ReasonInput;

import java.util.List;

public class X_BH_Voided_ReasonMutation implements GraphQLMutationResolver {
	public MBHVoidedReason BH_Voided_ReasonSave(M_BH_Voided_ReasonInput input) {
		input.saveEx();
		// get by uuid for visit input
		return input;
	}

	public boolean BH_Voided_ReasonDelete(List<String> uuids) {
		return true;
	}
}
