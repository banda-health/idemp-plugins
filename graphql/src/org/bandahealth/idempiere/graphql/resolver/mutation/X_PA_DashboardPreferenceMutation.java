package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_DashboardPreferenceInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_DashboardPreferenceInput;
import org.compiere.model.MDashboardPreference;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for PA_DashboardPreference - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_DashboardPreferenceMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_DashboardPreferenceInput.Table_Name;
	}

	public MDashboardPreference PA_DashboardPreferenceSave(I_PA_DashboardPreferenceInput Entity, DataFetchingEnvironment environment) {
		return (MDashboardPreference) super.save((X_PA_DashboardPreferenceInput) Entity, environment);
	}

	public List<MDashboardPreference> PA_DashboardPreferenceSaveMany(List<I_PA_DashboardPreferenceInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_PA_DashboardPreferenceInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MDashboardPreference) entity).collect(Collectors.toList());
	}

	public boolean PA_DashboardPreferenceDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
