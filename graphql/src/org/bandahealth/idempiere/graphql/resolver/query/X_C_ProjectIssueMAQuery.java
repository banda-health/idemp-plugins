package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_ProjectIssueMA;

/**
 * Generated Query Resolver for C_ProjectIssueMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_ProjectIssueMAQuery extends POQuery<X_C_ProjectIssueMA> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_ProjectIssueMA.Table_Name;
	}

	public Connection<X_C_ProjectIssueMA> C_ProjectIssueMAGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
