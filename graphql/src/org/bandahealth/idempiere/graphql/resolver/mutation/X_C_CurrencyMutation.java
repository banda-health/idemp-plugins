package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.graphql.model.input.I_C_CurrencyInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_CurrencyInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_Currency - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_CurrencyMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_CurrencyInput.Table_Name;
	}

	public MCurrency_BH C_CurrencySave(I_C_CurrencyInput Entity, DataFetchingEnvironment environment) {
		return (MCurrency_BH) super.save((X_C_CurrencyInput) Entity, environment);
	}

	public List<MCurrency_BH> C_CurrencySaveMany(List<I_C_CurrencyInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_CurrencyInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MCurrency_BH) entity).collect(Collectors.toList());
	}

	public boolean C_CurrencyDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
