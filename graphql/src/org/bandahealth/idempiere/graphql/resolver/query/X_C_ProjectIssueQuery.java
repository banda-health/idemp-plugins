package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MProjectIssue;

/**
 * Generated Query Resolver for C_ProjectIssue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_ProjectIssueQuery extends POQuery<MProjectIssue> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MProjectIssue.Table_Name;
	}

	public Connection<MProjectIssue> C_ProjectIssueGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
