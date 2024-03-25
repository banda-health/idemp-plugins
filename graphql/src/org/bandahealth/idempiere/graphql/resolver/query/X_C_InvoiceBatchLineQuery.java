package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MInvoiceBatchLine;

/**
 * Generated Query Resolver for C_InvoiceBatchLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_InvoiceBatchLineQuery extends POQuery<MInvoiceBatchLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MInvoiceBatchLine.Table_Name;
	}

	public Connection<MInvoiceBatchLine> C_InvoiceBatchLineGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
