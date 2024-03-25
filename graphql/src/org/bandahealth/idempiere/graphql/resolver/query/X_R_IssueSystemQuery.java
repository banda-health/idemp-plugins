package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MIssueSystem;

/**
 * Generated Query Resolver for R_IssueSystem - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_IssueSystemQuery extends POQuery<MIssueSystem> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MIssueSystem.Table_Name;
	}

	public Connection<MIssueSystem> R_IssueSystemGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
