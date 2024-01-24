package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MUserPreference_BH;
import org.bandahealth.idempiere.graphql.model.input.I_AD_UserPreferenceInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_UserPreferenceInput;
import org.compiere.model.X_AD_UserPreference;

import java.util.List;
import java.util.stream.Collectors;

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

	public MUserPreference_BH AD_UserPreferenceSave(I_AD_UserPreferenceInput entity, DataFetchingEnvironment environment) {
		return (MUserPreference_BH) super.save((X_AD_UserPreferenceInput) entity, environment);
	}

	public List<MUserPreference_BH> AD_UserPreferenceSaveMany(List<I_AD_UserPreferenceInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_UserPreferenceInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MUserPreference_BH) entity).collect(Collectors.toList());
	}

	public boolean AD_UserPreferenceDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
