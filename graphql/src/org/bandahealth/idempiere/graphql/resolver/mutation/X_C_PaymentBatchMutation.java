package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_PaymentBatchInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_PaymentBatchInput;
import org.compiere.model.MPaymentBatch;

import java.util.List;

/**
 * Generated Query Resolver for C_PaymentBatch - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_PaymentBatchMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_PaymentBatchInput.Table_Name;
	}

	public MPaymentBatch C_PaymentBatchSave(I_C_PaymentBatchInput input, DataFetchingEnvironment environment) {
		return (MPaymentBatch) super.save((X_C_PaymentBatchInput) input, environment);
	}

	public boolean C_PaymentBatchDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
