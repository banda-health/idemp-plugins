package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TreeNodeCMCDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTree_NodeCMC;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_TreeNodeCMC - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_TreeNodeCMCQuery extends POQuery<MTree_NodeCMC> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTree_NodeCMC.Table_Name;
	}

	public CompletableFuture<MTree_NodeCMC> AD_TreeNodeCMC(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MTree_NodeCMC> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_TreeNodeCMCDataLoader.DATALOADER_AD_TreeNodeCMC_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MTree_NodeCMC> AD_TreeNodeCMCGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
