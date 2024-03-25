package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_B_BuyerFunds;

/**
 * Generated Query Resolver for B_BuyerFunds - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_B_BuyerFundsQuery extends POQuery<X_B_BuyerFunds> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_B_BuyerFunds.Table_Name;
	}

	public Connection<X_B_BuyerFunds> B_BuyerFundsGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
