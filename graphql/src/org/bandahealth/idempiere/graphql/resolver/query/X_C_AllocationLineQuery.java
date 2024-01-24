package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAllocationLine;

/**
 * Generated Query Resolver for C_AllocationLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_AllocationLineQuery extends POQuery<MAllocationLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAllocationLine.Table_Name;
	}

	public Connection<MAllocationLine> C_AllocationLineGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
