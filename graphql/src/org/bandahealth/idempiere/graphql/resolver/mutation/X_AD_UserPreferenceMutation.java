package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MUserPreference_BH;
import org.bandahealth.idempiere.graphql.model.input.I_AD_UserPreferenceInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_UserPreferenceInput;

import java.util.List;

/**
 * Generated Query Resolver for AD_UserPreference - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_UserPreferenceMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_UserPreferenceInput.Table_Name;
	}

	public MUserPreference_BH AD_UserPreferenceSave(I_AD_UserPreferenceInput input, DataFetchingEnvironment environment) {
		return (MUserPreference_BH) super.save((X_AD_UserPreferenceInput) input, environment);
	}

	public boolean AD_UserPreferenceDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
