package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_DashboardPreferenceInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_DashboardPreferenceInput;
import org.compiere.model.MDashboardPreference;

import java.util.List;

/**
 * Generated Query Resolver for PA_DashboardPreference - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_PA_DashboardPreferenceMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_DashboardPreferenceInput.Table_Name;
	}

	public MDashboardPreference PA_DashboardPreferenceSave(I_PA_DashboardPreferenceInput input, DataFetchingEnvironment environment) {
		return (MDashboardPreference) super.save((X_PA_DashboardPreferenceInput) input, environment);
	}

	public boolean PA_DashboardPreferenceDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
