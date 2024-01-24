package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_WS_WebServiceMethod;

/**
 * Generated Query Resolver for WS_WebServiceMethod - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_WS_WebServiceMethodQuery extends POQuery<X_WS_WebServiceMethod> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_WS_WebServiceMethod.Table_Name;
	}

	public Connection<X_WS_WebServiceMethod> WS_WebServiceMethodGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
