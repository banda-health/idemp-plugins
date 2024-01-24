package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_PaymentAllocateInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_PaymentAllocateInput;
import org.compiere.model.MPaymentAllocate;

import java.util.List;

/**
 * Generated Query Resolver for C_PaymentAllocate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_PaymentAllocateMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_PaymentAllocateInput.Table_Name;
	}

	public MPaymentAllocate C_PaymentAllocateSave(I_C_PaymentAllocateInput input, DataFetchingEnvironment environment) {
		return (MPaymentAllocate) super.save((X_C_PaymentAllocateInput) input, environment);
	}

	public boolean C_PaymentAllocateDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
