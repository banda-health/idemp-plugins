package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MUserQuery;

/**
 * Generated Query Resolver for AD_UserQuery - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_UserQueryQuery extends POQuery<MUserQuery> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MUserQuery.Table_Name;
	}

	public Connection<MUserQuery> AD_UserQueryGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
