package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_R_IssueStatus;

/**
 * Generated Query Resolver for R_IssueStatus - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_IssueStatusQuery extends POQuery<X_R_IssueStatus> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_R_IssueStatus.Table_Name;
	}

	public Connection<X_R_IssueStatus> R_IssueStatusGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
