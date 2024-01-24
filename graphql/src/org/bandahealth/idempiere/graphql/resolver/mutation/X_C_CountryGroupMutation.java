package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_CountryGroupInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_CountryGroupInput;
import org.compiere.model.MCountryGroup;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_CountryGroup - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_CountryGroupMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_CountryGroupInput.Table_Name;
	}

	public MCountryGroup C_CountryGroupSave(I_C_CountryGroupInput entity, DataFetchingEnvironment environment) {
		return (MCountryGroup) super.save((X_C_CountryGroupInput) entity, environment);
	}

	public List<MCountryGroup> C_CountryGroupSaveMany(List<I_C_CountryGroupInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_CountryGroupInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MCountryGroup) entity).collect(Collectors.toList());
	}

	public boolean C_CountryGroupDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
