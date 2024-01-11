package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_RequestProcessor_RouteInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_RequestProcessor_RouteInput;
import org.compiere.model.MRequestProcessorRoute;

import java.util.List;

/**
 * Generated Query Resolver for R_RequestProcessor_Route - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_RequestProcessor_RouteMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_RequestProcessor_RouteInput.Table_Name;
	}

	public MRequestProcessorRoute R_RequestProcessor_RouteSave(I_R_RequestProcessor_RouteInput input, DataFetchingEnvironment environment) {
		return (MRequestProcessorRoute) super.save((X_R_RequestProcessor_RouteInput) input, environment);
	}

	public boolean R_RequestProcessor_RouteDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
