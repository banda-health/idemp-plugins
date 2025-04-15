package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_SubscriptionDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_Subscription;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_Subscription - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_SubscriptionQuery extends POQuery<X_C_Subscription> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_Subscription.Table_Name;
	}

	public CompletableFuture<X_C_Subscription> C_Subscription(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_C_Subscription> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_SubscriptionDataLoader.DATALOADER_C_Subscription_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_C_Subscription> C_SubscriptionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
