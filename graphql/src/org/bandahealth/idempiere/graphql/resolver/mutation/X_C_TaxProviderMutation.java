package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_TaxProviderInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_TaxProviderInput;
import org.compiere.model.MTaxProvider;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_TaxProvider - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_TaxProviderMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_TaxProviderInput.Table_Name;
	}

	public MTaxProvider C_TaxProviderSave(I_C_TaxProviderInput Entity, DataFetchingEnvironment environment) {
		return (MTaxProvider) super.save((X_C_TaxProviderInput) Entity, environment);
	}

	public List<MTaxProvider> C_TaxProviderSaveMany(List<I_C_TaxProviderInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_TaxProviderInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MTaxProvider) entity).collect(Collectors.toList());
	}

	public boolean C_TaxProviderDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
