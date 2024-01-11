package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_B_Bid;

/**
 * Generated Query Resolver for B_Bid - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_B_BidQuery extends POQuery<X_B_Bid> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_B_Bid.Table_Name;
	}

	public Connection<X_B_Bid> B_BidGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
