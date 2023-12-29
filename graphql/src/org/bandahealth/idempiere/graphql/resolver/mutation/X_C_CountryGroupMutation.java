package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_CountryGroupInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_CountryGroupInput;
import org.compiere.model.MCountryGroup;

import java.util.List;

/**
 * Generated Query Resolver for C_CountryGroup - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CountryGroupMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_CountryGroupInput.Table_Name;
	}

	public MCountryGroup C_CountryGroupSave(I_C_CountryGroupInput input, DataFetchingEnvironment environment) {
		return (MCountryGroup) super.save((X_C_CountryGroupInput) input, environment);
	}

	public boolean C_CountryGroupDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
