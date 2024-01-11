package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MUserQuery;

/**
 * Generated Query Resolver for AD_UserQuery - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_UserQueryQuery extends POQuery<MUserQuery> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MUserQuery.Table_Name;
	}

	public Connection<MUserQuery> AD_UserQueryGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
