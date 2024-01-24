package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_T_InvoiceGL;

/**
 * Generated Query Resolver for T_InvoiceGL - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_T_InvoiceGLQuery extends POQuery<X_T_InvoiceGL> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_T_InvoiceGL.Table_Name;
	}

	public Connection<X_T_InvoiceGL> T_InvoiceGLGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
