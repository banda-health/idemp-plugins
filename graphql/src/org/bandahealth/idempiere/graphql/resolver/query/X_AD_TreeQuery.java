package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MTree_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TreeDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Tree - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_TreeQuery extends POQuery<MTree_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTree_BH.Table_Name;
	}

	public CompletableFuture<MTree_BH> AD_Tree(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MTree_BH> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_TreeDataLoader.DATALOADER_AD_Tree_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MTree_BH> AD_TreeGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
