package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MInvoiceBatch;

/**
 * Generated Query Resolver for C_InvoiceBatch - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_InvoiceBatchQuery extends POQuery<MInvoiceBatch> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MInvoiceBatch.Table_Name;
	}

	public Connection<MInvoiceBatch> C_InvoiceBatchGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
