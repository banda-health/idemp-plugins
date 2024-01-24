package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MIssueProject;

/**
 * Generated Query Resolver for R_IssueProject - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_IssueProjectQuery extends POQuery<MIssueProject> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MIssueProject.Table_Name;
	}

	public Connection<MIssueProject> R_IssueProjectGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
