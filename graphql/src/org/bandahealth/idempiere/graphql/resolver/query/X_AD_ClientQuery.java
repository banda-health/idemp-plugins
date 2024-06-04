package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MClient_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ClientDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Client - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_ClientQuery extends POQuery<MClient_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MClient_BH.Table_Name;
	}

	public CompletableFuture<MClient_BH> AD_Client(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MClient_BH> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_ClientDataLoader.DATALOADER_AD_Client_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MClient_BH> AD_ClientGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
