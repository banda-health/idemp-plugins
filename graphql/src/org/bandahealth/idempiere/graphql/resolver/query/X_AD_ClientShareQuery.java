package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ClientShareDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MClientShare;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_ClientShare - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_ClientShareQuery extends POQuery<MClientShare> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MClientShare.Table_Name;
	}

	public CompletableFuture<MClientShare> AD_ClientShare(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MClientShare> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_ClientShareDataLoader.DATALOADER_AD_ClientShare_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MClientShare> AD_ClientShareGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
