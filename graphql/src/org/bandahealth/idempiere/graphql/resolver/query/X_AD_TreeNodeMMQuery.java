package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TreeNodeMMDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTree_NodeMM;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_TreeNodeMM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_TreeNodeMMQuery extends POQuery<MTree_NodeMM> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTree_NodeMM.Table_Name;
	}

	public CompletableFuture<MTree_NodeMM> AD_TreeNodeMM(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MTree_NodeMM> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_TreeNodeMMDataLoader.DATALOADER_AD_TreeNodeMM_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MTree_NodeMM> AD_TreeNodeMMGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
