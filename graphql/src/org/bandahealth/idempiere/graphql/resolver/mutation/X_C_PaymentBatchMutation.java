package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_PaymentBatchInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_PaymentBatchInput;
import org.compiere.model.MPaymentBatch;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_PaymentBatch - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_PaymentBatchMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_PaymentBatchInput.Table_Name;
	}

	public MPaymentBatch C_PaymentBatchSave(I_C_PaymentBatchInput entity, DataFetchingEnvironment environment) {
		return (MPaymentBatch) super.save((X_C_PaymentBatchInput) entity, environment);
	}

	public List<MPaymentBatch> C_PaymentBatchSaveMany(List<I_C_PaymentBatchInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_PaymentBatchInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MPaymentBatch) entity).collect(Collectors.toList());
	}

	public boolean C_PaymentBatchDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
