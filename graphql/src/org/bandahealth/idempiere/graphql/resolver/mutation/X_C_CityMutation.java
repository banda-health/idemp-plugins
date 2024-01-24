package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_CityInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_CityInput;
import org.compiere.model.MCity;

import java.util.List;

/**
 * Generated Query Resolver for C_City - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CityMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_CityInput.Table_Name;
	}

	public MCity C_CitySave(I_C_CityInput input, DataFetchingEnvironment environment) {
		return (MCity) super.save((X_C_CityInput) input, environment);
	}

	public boolean C_CityDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
