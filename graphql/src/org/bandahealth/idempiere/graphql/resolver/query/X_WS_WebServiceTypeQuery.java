package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_WS_WebServiceType;

/**
 * Generated Query Resolver for WS_WebServiceType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_WS_WebServiceTypeQuery extends POQuery<X_WS_WebServiceType> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_WS_WebServiceType.Table_Name;
	}

	public Connection<X_WS_WebServiceType> WS_WebServiceTypeGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
