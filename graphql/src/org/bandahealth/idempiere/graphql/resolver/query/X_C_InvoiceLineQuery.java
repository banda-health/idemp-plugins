package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MInvoiceLine;

/**
 * Generated Query Resolver for C_InvoiceLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_InvoiceLineQuery extends POQuery<MInvoiceLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MInvoiceLine.Table_Name;
	}

	public Connection<MInvoiceLine> C_InvoiceLineGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
