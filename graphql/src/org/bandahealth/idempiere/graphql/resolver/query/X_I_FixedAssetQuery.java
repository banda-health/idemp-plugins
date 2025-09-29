package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_I_FixedAssetDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MIFixedAsset;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for I_FixedAsset - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_I_FixedAssetQuery extends POQuery<MIFixedAsset> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MIFixedAsset.Table_Name;
	}

	public CompletableFuture<MIFixedAsset> I_FixedAsset(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MIFixedAsset> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_I_FixedAssetDataLoader.DATALOADER_I_FixedAsset_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MIFixedAsset> I_FixedAssetGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
