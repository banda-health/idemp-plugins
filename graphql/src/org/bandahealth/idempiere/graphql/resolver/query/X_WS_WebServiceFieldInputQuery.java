package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_WS_WebServiceFieldInput;

/**
 * Generated Query Resolver for WS_WebServiceFieldInput - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_WS_WebServiceFieldInputQuery extends POQuery<X_WS_WebServiceFieldInput> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_WS_WebServiceFieldInput.Table_Name;
	}

	public Connection<X_WS_WebServiceFieldInput> WS_WebServiceFieldInputGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
