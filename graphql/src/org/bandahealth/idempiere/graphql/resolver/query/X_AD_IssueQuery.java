package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MIssue;

/**
 * Generated Query Resolver for AD_Issue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_IssueQuery extends POQuery<MIssue> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MIssue.Table_Name;
	}

	public Connection<MIssue> AD_IssueGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
