package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WF_BlockDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_WF_Block;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_WF_Block - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_WF_BlockQuery extends POQuery<X_AD_WF_Block> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_WF_Block.Table_Name;
	}

	public CompletableFuture<X_AD_WF_Block> AD_WF_Block(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_AD_WF_Block> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_WF_BlockDataLoader.DATALOADER_AD_WF_Block_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_AD_WF_Block> AD_WF_BlockGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
