package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_BroadcastMessageDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_BroadcastMessage;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_BroadcastMessage - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_BroadcastMessageQuery extends POQuery<X_AD_BroadcastMessage> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_BroadcastMessage.Table_Name;
	}

	public CompletableFuture<X_AD_BroadcastMessage> AD_BroadcastMessage(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_AD_BroadcastMessage> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_BroadcastMessageDataLoader.DATALOADER_AD_BroadcastMessage_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_AD_BroadcastMessage> AD_BroadcastMessageGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
