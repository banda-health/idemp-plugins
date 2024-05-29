package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TreeNodeCMMDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_TreeNodeCMM;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_TreeNodeCMM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_TreeNodeCMMQuery extends POQuery<X_AD_TreeNodeCMM> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_TreeNodeCMM.Table_Name;
	}

	public CompletableFuture<X_AD_TreeNodeCMM> AD_TreeNodeCMM(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_AD_TreeNodeCMM> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_TreeNodeCMMDataLoader.DATALOADER_AD_TreeNodeCMM_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_AD_TreeNodeCMM> AD_TreeNodeCMMGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
