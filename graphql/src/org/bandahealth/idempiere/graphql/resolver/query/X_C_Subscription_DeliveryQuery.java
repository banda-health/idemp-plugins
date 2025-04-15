package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_Subscription_DeliveryDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_Subscription_Delivery;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_Subscription_Delivery - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_Subscription_DeliveryQuery extends POQuery<X_C_Subscription_Delivery> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_Subscription_Delivery.Table_Name;
	}

	public CompletableFuture<X_C_Subscription_Delivery> C_Subscription_Delivery(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_C_Subscription_Delivery> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_Subscription_DeliveryDataLoader.DATALOADER_C_Subscription_Delivery_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_C_Subscription_Delivery> C_Subscription_DeliveryGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
