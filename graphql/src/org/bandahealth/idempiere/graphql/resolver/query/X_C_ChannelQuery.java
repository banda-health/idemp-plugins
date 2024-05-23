package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ChannelDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_Channel;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_Channel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_ChannelQuery extends POQuery<X_C_Channel> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_Channel.Table_Name;
	}

	public CompletableFuture<X_C_Channel> C_Channel(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_C_Channel> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_ChannelDataLoader.DATALOADER_C_Channel_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_C_Channel> C_ChannelGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
