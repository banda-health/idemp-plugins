package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Asset_RevalDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAssetReval;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for A_Asset_Reval - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_A_Asset_RevalQuery extends POQuery<MAssetReval> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAssetReval.Table_Name;
	}

	public CompletableFuture<MAssetReval> A_Asset_Reval(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAssetReval> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_A_Asset_RevalDataLoader.DATALOADER_A_Asset_Reval_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAssetReval> A_Asset_RevalGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
