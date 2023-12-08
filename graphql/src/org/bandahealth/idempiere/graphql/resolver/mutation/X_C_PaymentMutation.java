package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.graphql.model.input.M_C_PaymentInput;

import java.util.List;

public class X_C_PaymentMutation implements GraphQLMutationResolver {
	public MPayment_BH C_PaymentSave(M_C_PaymentInput input) {
		input.saveEx();
		// get by uuid for visit input
		return input;
	}

	public boolean C_PaymentDelete(List<String> uuids) {
		return true;
	}
}
