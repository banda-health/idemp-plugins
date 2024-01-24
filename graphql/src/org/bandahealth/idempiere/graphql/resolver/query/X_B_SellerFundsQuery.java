package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_B_SellerFunds;

/**
 * Generated Query Resolver for B_SellerFunds - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_B_SellerFundsQuery extends POQuery<X_B_SellerFunds> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_B_SellerFunds.Table_Name;
	}

	public Connection<X_B_SellerFunds> B_SellerFundsGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
