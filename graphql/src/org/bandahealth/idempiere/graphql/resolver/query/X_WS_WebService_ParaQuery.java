package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_WS_WebService_Para;

/**
 * Generated Query Resolver for WS_WebService_Para - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_WS_WebService_ParaQuery extends POQuery<X_WS_WebService_Para> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_WS_WebService_Para.Table_Name;
	}

	public Connection<X_WS_WebService_Para> WS_WebService_ParaGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
