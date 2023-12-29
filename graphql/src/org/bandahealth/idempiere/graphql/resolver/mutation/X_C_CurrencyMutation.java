package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_CurrencyInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_CurrencyInput;
import org.compiere.model.MCurrency;

import java.util.List;

/**
 * Generated Query Resolver for C_Currency - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CurrencyMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_CurrencyInput.Table_Name;
	}

	public MCurrency C_CurrencySave(I_C_CurrencyInput input, DataFetchingEnvironment environment) {
		return (MCurrency) super.save((X_C_CurrencyInput) input, environment);
	}

	public boolean C_CurrencyDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
