package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_WS_WebService;

/**
 * Generated Query Resolver for WS_WebService - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_WS_WebServiceQuery extends POQuery<X_WS_WebService> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_WS_WebService.Table_Name;
	}

	public Connection<X_WS_WebService> WS_WebServiceGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
