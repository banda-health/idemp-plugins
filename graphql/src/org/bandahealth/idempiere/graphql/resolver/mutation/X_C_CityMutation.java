package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_CityInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_CityInput;
import org.compiere.model.MCity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_City - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_CityMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_CityInput.Table_Name;
	}

	public MCity C_CitySave(I_C_CityInput Entity, DataFetchingEnvironment environment) {
		return (MCity) super.save((X_C_CityInput) Entity, environment);
	}

	public List<MCity> C_CitySaveMany(List<I_C_CityInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_CityInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MCity) entity).collect(Collectors.toList());
	}

	public boolean C_CityDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
