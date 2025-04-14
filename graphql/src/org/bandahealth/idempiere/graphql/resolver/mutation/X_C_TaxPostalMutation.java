package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_TaxPostalInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_TaxPostalInput;
import org.compiere.model.MTaxPostal;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_TaxPostal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_TaxPostalMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_TaxPostalInput.Table_Name;
	}

	public MTaxPostal C_TaxPostalSave(I_C_TaxPostalInput Entity, DataFetchingEnvironment environment) {
		return (MTaxPostal) super.save((X_C_TaxPostalInput) Entity, environment);
	}

	public List<MTaxPostal> C_TaxPostalSaveMany(List<I_C_TaxPostalInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_TaxPostalInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MTaxPostal) entity).collect(Collectors.toList());
	}

	public boolean C_TaxPostalDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
