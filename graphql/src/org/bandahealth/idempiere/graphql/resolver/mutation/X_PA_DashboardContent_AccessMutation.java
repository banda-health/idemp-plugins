package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_DashboardContent_AccessInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_DashboardContent_AccessInput;
import org.compiere.model.MDashboardContentAccess;

import java.util.List;

/**
 * Generated Query Resolver for PA_DashboardContent_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_DashboardContent_AccessMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_DashboardContent_AccessInput.Table_Name;
	}

	public MDashboardContentAccess PA_DashboardContent_AccessSave(I_PA_DashboardContent_AccessInput input, DataFetchingEnvironment environment) {
		return (MDashboardContentAccess) super.save((X_PA_DashboardContent_AccessInput) input, environment);
	}

	public boolean PA_DashboardContent_AccessDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
