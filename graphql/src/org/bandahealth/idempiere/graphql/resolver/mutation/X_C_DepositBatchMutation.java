package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_DepositBatchInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_DepositBatchInput;
import org.compiere.model.MDepositBatch;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_DepositBatch - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_DepositBatchMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_DepositBatchInput.Table_Name;
	}

	public MDepositBatch C_DepositBatchSave(I_C_DepositBatchInput Entity, DataFetchingEnvironment environment) {
		return (MDepositBatch) super.save((X_C_DepositBatchInput) Entity, environment);
	}

	public List<MDepositBatch> C_DepositBatchSaveMany(List<I_C_DepositBatchInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_DepositBatchInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MDepositBatch) entity).collect(Collectors.toList());
	}

	public boolean C_DepositBatchDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
