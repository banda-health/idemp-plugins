package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_PreferenceInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_PreferenceInput;
import org.compiere.model.MPreference;

import java.util.List;

/**
 * Generated Query Resolver for AD_Preference - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_PreferenceMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_PreferenceInput.Table_Name;
	}

	public MPreference AD_PreferenceSave(I_AD_PreferenceInput input, DataFetchingEnvironment environment) {
		return (MPreference) super.save((X_AD_PreferenceInput) input, environment);
	}

	public boolean AD_PreferenceDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
