package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_Subscription_Delivery;

/**
 * Generated Query Resolver for C_Subscription_Delivery - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_Subscription_DeliveryQuery extends POQuery<X_C_Subscription_Delivery> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_Subscription_Delivery.Table_Name;
	}

	public Connection<X_C_Subscription_Delivery> C_Subscription_DeliveryGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
