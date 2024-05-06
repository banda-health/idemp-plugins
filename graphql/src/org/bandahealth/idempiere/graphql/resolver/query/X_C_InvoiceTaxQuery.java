package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MInvoiceTax;

/**
 * Generated Query Resolver for C_InvoiceTax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_InvoiceTaxQuery extends POQuery<MInvoiceTax> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MInvoiceTax.Table_Name;
	}

	public Connection<MInvoiceTax> C_InvoiceTaxGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
