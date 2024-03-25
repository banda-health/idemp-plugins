package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.eevolution.model.X_PP_MRP;

/**
 * Generated Query Resolver for PP_MRP - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PP_MRPQuery extends POQuery<X_PP_MRP> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_PP_MRP.Table_Name;
	}

	public Connection<X_PP_MRP> PP_MRPGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
