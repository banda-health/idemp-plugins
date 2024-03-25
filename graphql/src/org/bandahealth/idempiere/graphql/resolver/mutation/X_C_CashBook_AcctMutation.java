package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_CashBook_AcctInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_CashBook_AcctInput;
import org.compiere.model.X_C_CashBook_Acct;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_CashBook_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_CashBook_AcctMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_CashBook_AcctInput.Table_Name;
	}

	public X_C_CashBook_Acct C_CashBook_AcctSave(I_C_CashBook_AcctInput entity, DataFetchingEnvironment environment) {
		return (X_C_CashBook_Acct) super.save((X_C_CashBook_AcctInput) entity, environment);
	}

	public List<X_C_CashBook_Acct> C_CashBook_AcctSaveMany(List<I_C_CashBook_AcctInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_CashBook_AcctInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_C_CashBook_Acct) entity).collect(Collectors.toList());
	}

	public boolean C_CashBook_AcctDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
