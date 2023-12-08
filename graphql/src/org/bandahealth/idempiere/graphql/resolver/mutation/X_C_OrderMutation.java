package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.graphql.model.input.M_C_OrderInput;

import java.util.List;

public class X_C_OrderMutation implements GraphQLMutationResolver {
	public MOrder_BH C_OrderSave(M_C_OrderInput input) {
		input.saveEx();
		// get by uuid for visit input
		return input;
	}

	public boolean C_OrderDelete(List<String> uuids) {
		return true;
	}
}
