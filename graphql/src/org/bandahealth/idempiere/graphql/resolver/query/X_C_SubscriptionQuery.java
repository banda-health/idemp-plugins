package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_Subscription;

/**
 * Generated Query Resolver for C_Subscription - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_SubscriptionQuery extends POQuery<X_C_Subscription> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_Subscription.Table_Name;
	}

	public Connection<X_C_Subscription> C_SubscriptionGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
