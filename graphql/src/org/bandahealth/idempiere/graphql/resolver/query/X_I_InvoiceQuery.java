package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_I_Invoice;

/**
 * Generated Query Resolver for I_Invoice - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_I_InvoiceQuery extends POQuery<X_I_Invoice> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_I_Invoice.Table_Name;
	}

	public Connection<X_I_Invoice> I_InvoiceGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
