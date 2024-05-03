package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MShippingTransaction;

/**
 * Generated Query Resolver for M_ShippingTransaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_ShippingTransactionQuery extends POQuery<MShippingTransaction> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MShippingTransaction.Table_Name;
	}

	public Connection<MShippingTransaction> M_ShippingTransactionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
