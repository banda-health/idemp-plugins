package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_T_InvoiceGL;

/**
 * Generated Query Resolver for T_InvoiceGL - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_T_InvoiceGLQuery extends POQuery<X_T_InvoiceGL> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_T_InvoiceGL.Table_Name;
	}

	public Connection<X_T_InvoiceGL> T_InvoiceGLGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
