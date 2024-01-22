package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MResourceAssignment;

/**
 * Generated Query Resolver for S_ResourceAssignment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_S_ResourceAssignmentQuery extends POQuery<MResourceAssignment> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MResourceAssignment.Table_Name;
	}

	public Connection<MResourceAssignment> S_ResourceAssignmentGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
