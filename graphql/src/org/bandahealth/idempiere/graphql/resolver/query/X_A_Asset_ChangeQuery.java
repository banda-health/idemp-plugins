package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Asset_ChangeDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAssetChange;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for A_Asset_Change - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_A_Asset_ChangeQuery extends POQuery<MAssetChange> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAssetChange.Table_Name;
	}

	public CompletableFuture<MAssetChange> A_Asset_Change(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAssetChange> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_A_Asset_ChangeDataLoader.DATALOADER_A_Asset_Change_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAssetChange> A_Asset_ChangeGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
