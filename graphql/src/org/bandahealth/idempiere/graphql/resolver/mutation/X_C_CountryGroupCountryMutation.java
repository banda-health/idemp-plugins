package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_CountryGroupCountryInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_CountryGroupCountryInput;
import org.compiere.model.MCountryGroupCountry;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_CountryGroupCountry - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_CountryGroupCountryMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_CountryGroupCountryInput.Table_Name;
	}

	public MCountryGroupCountry C_CountryGroupCountrySave(I_C_CountryGroupCountryInput entity, DataFetchingEnvironment environment) {
		return (MCountryGroupCountry) super.save((X_C_CountryGroupCountryInput) entity, environment);
	}

	public List<MCountryGroupCountry> C_CountryGroupCountrySaveMany(List<I_C_CountryGroupCountryInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_CountryGroupCountryInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MCountryGroupCountry) entity).collect(Collectors.toList());
	}

	public boolean C_CountryGroupCountryDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
