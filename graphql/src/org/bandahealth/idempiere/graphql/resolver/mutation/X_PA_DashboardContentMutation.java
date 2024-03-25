package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_DashboardContentInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_DashboardContentInput;
import org.compiere.model.MDashboardContent;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for PA_DashboardContent - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_DashboardContentMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_DashboardContentInput.Table_Name;
	}

	public MDashboardContent PA_DashboardContentSave(I_PA_DashboardContentInput entity, DataFetchingEnvironment environment) {
		return (MDashboardContent) super.save((X_PA_DashboardContentInput) entity, environment);
	}

	public List<MDashboardContent> PA_DashboardContentSaveMany(List<I_PA_DashboardContentInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_PA_DashboardContentInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MDashboardContent) entity).collect(Collectors.toList());
	}

	public boolean PA_DashboardContentDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
