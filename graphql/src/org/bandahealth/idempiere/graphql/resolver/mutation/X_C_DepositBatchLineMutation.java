package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_DepositBatchLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_DepositBatchLineInput;
import org.compiere.model.MDepositBatchLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_DepositBatchLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_DepositBatchLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_DepositBatchLineInput.Table_Name;
	}

	public MDepositBatchLine C_DepositBatchLineSave(I_C_DepositBatchLineInput entity, DataFetchingEnvironment environment) {
		return (MDepositBatchLine) super.save((X_C_DepositBatchLineInput) entity, environment);
	}

	public List<MDepositBatchLine> C_DepositBatchLineSaveMany(List<I_C_DepositBatchLineInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_DepositBatchLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MDepositBatchLine) entity).collect(Collectors.toList());
	}

	public boolean C_DepositBatchLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
