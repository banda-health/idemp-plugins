package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableIndexDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTableIndex;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_TableIndex - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_TableIndexQuery extends POQuery<MTableIndex> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTableIndex.Table_Name;
	}

	public CompletableFuture<MTableIndex> AD_TableIndex(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MTableIndex> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_TableIndexDataLoader.DATALOADER_AD_TableIndex_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MTableIndex> AD_TableIndexGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
