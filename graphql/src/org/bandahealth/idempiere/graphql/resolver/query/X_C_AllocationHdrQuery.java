package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAllocationHdr;

/**
 * Generated Query Resolver for C_AllocationHdr - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_AllocationHdrQuery extends POQuery<MAllocationHdr> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAllocationHdr.Table_Name;
	}

	public Connection<MAllocationHdr> C_AllocationHdrGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
