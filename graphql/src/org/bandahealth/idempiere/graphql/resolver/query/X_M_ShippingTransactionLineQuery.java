package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MShippingTransactionLine;

/**
 * Generated Query Resolver for M_ShippingTransactionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_ShippingTransactionLineQuery extends POQuery<MShippingTransactionLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MShippingTransactionLine.Table_Name;
	}

	public Connection<MShippingTransactionLine> M_ShippingTransactionLineGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
