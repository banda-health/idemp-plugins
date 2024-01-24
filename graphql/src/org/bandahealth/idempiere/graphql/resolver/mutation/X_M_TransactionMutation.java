package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_TransactionInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_TransactionInput;
import org.compiere.model.MTransaction;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_Transaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_TransactionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_TransactionInput.Table_Name;
	}

	public MTransaction M_TransactionSave(I_M_TransactionInput entity, DataFetchingEnvironment environment) {
		return (MTransaction) super.save((X_M_TransactionInput) entity, environment);
	}

	public List<MTransaction> M_TransactionSaveMany(List<I_M_TransactionInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_TransactionInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MTransaction) entity).collect(Collectors.toList());
	}

	public boolean M_TransactionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
