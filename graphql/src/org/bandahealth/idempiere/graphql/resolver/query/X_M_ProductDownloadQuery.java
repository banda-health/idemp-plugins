package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDownloadDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MProductDownload;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_ProductDownload - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_ProductDownloadQuery extends POQuery<MProductDownload> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MProductDownload.Table_Name;
	}

	public CompletableFuture<MProductDownload> M_ProductDownload(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MProductDownload> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_ProductDownloadDataLoader.DATALOADER_M_ProductDownload_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MProductDownload> M_ProductDownloadGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
