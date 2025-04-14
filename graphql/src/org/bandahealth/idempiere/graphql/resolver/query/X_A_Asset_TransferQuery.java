package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Asset_TransferDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAssetTransfer;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for A_Asset_Transfer - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_A_Asset_TransferQuery extends POQuery<MAssetTransfer> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAssetTransfer.Table_Name;
	}

	public CompletableFuture<MAssetTransfer> A_Asset_Transfer(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAssetTransfer> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_A_Asset_TransferDataLoader.DATALOADER_A_Asset_Transfer_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAssetTransfer> A_Asset_TransferGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
