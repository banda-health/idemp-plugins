package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_SubscriptionDataLoader;
import org.compiere.model.X_C_Subscription;
import org.compiere.model.X_C_Subscription_Delivery;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_Subscription_Delivery - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_Subscription_DeliveryResolver extends POResolver<X_C_Subscription_Delivery> implements GraphQLResolver<X_C_Subscription_Delivery> {



	/**
	 * Get Subscription.
	 *
	 * @return Subscription of a Business Partner of a Product to renew
	 */
	public CompletableFuture<X_C_Subscription> C_Subscription(X_C_Subscription_Delivery entity, DataFetchingEnvironment environment) {
		if (entity.getC_Subscription_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_C_Subscription> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_SubscriptionDataLoader.DATALOADER_C_Subscription_BY_ID);
		return dataLoader.load(entity.getC_Subscription_ID());
	}

}
