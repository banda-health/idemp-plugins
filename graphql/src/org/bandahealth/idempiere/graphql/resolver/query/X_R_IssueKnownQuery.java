package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_R_IssueKnown;

/**
 * Generated Query Resolver for R_IssueKnown - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_IssueKnownQuery extends POQuery<X_R_IssueKnown> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_R_IssueKnown.Table_Name;
	}

	public Connection<X_R_IssueKnown> R_IssueKnownGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
