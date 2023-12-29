package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_CountryInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_CountryInput;
import org.compiere.model.MCountry;

import java.util.List;

/**
 * Generated Query Resolver for C_Country - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CountryMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_CountryInput.Table_Name;
	}

	public MCountry C_CountrySave(I_C_CountryInput input, DataFetchingEnvironment environment) {
		return (MCountry) super.save((X_C_CountryInput) input, environment);
	}

	public boolean C_CountryDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
