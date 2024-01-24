package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_DepositBatchInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_DepositBatchInput;
import org.compiere.model.MDepositBatch;

import java.util.List;

/**
 * Generated Query Resolver for C_DepositBatch - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_DepositBatchMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_DepositBatchInput.Table_Name;
	}

	public MDepositBatch C_DepositBatchSave(I_C_DepositBatchInput input, DataFetchingEnvironment environment) {
		return (MDepositBatch) super.save((X_C_DepositBatchInput) input, environment);
	}

	public boolean C_DepositBatchDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
