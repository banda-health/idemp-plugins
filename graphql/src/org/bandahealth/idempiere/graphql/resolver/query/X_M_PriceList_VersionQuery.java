package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PriceList_VersionDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPriceListVersion;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_PriceList_Version - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_PriceList_VersionQuery extends POQuery<MPriceListVersion> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPriceListVersion.Table_Name;
	}

	public CompletableFuture<MPriceListVersion> M_PriceList_Version(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MPriceListVersion> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_PriceList_VersionDataLoader.DATALOADER_M_PriceList_Version_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MPriceListVersion> M_PriceList_VersionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
