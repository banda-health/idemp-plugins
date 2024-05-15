package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_ASP_ClientLevel;

/**
 * Generated Query Resolver for ASP_ClientLevel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_ASP_ClientLevelQuery extends POQuery<X_ASP_ClientLevel> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_ASP_ClientLevel.Table_Name;
	}

	public Connection<X_ASP_ClientLevel> ASP_ClientLevelGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
