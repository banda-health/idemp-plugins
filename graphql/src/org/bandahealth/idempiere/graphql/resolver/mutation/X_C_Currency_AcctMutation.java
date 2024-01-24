package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_Currency_AcctInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_Currency_AcctInput;
import org.compiere.model.MCurrencyAcct;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_Currency_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_Currency_AcctMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_Currency_AcctInput.Table_Name;
	}

	public MCurrencyAcct C_Currency_AcctSave(I_C_Currency_AcctInput entity, DataFetchingEnvironment environment) {
		return (MCurrencyAcct) super.save((X_C_Currency_AcctInput) entity, environment);
	}

	public List<MCurrencyAcct> C_Currency_AcctSaveMany(List<I_C_Currency_AcctInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_Currency_AcctInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MCurrencyAcct) entity).collect(Collectors.toList());
	}

	public boolean C_Currency_AcctDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
