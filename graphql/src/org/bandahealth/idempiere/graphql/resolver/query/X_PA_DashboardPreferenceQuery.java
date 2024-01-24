package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDashboardPreference;

/**
 * Generated Query Resolver for PA_DashboardPreference - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_DashboardPreferenceQuery extends POQuery<MDashboardPreference> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDashboardPreference.Table_Name;
	}

	public Connection<MDashboardPreference> PA_DashboardPreferenceGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
