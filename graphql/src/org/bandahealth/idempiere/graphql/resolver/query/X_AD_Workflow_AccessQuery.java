package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_Workflow_Access;

/**
 * Generated Query Resolver for AD_Workflow_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Workflow_AccessQuery extends POQuery<X_AD_Workflow_Access> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_Workflow_Access.Table_Name;
	}

	public Connection<X_AD_Workflow_Access> AD_Workflow_AccessGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
