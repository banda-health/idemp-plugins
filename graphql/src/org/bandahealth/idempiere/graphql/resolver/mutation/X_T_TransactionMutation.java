package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_T_TransactionInput;
import org.bandahealth.idempiere.graphql.model.input.X_T_TransactionInput;
import org.compiere.model.X_T_Transaction;

import java.util.List;

/**
 * Generated Query Resolver for T_Transaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_T_TransactionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_T_TransactionInput.Table_Name;
	}

	public X_T_Transaction T_TransactionSave(I_T_TransactionInput input, DataFetchingEnvironment environment) {
		return (X_T_Transaction) super.save((X_T_TransactionInput) input, environment);
	}

	public boolean T_TransactionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
