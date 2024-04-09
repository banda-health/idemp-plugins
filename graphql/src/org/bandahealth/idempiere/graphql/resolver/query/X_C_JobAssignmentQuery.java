package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_JobAssignment;

/**
 * Generated Query Resolver for C_JobAssignment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_JobAssignmentQuery extends POQuery<X_C_JobAssignment> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_JobAssignment.Table_Name;
	}

	public Connection<X_C_JobAssignment> C_JobAssignmentGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
