package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_TransactionInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_TransactionInput;
import org.compiere.model.MTransaction;

import java.util.List;

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

	public MTransaction M_TransactionSave(I_M_TransactionInput input, DataFetchingEnvironment environment) {
		return (MTransaction) super.save((X_M_TransactionInput) input, environment);
	}

	public boolean M_TransactionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
