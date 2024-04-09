package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MShippingTransactionLine;

/**
 * Generated Query Resolver for M_ShippingTransactionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_ShippingTransactionLineQuery extends POQuery<MShippingTransactionLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MShippingTransactionLine.Table_Name;
	}

	public Connection<MShippingTransactionLine> M_ShippingTransactionLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
