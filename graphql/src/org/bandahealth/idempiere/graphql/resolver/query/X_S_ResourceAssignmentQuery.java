package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MResourceAssignment;

/**
 * Generated Query Resolver for S_ResourceAssignment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_S_ResourceAssignmentQuery extends POQuery<MResourceAssignment> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MResourceAssignment.Table_Name;
	}

	public Connection<MResourceAssignment> S_ResourceAssignmentGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
