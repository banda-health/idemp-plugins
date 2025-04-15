package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TreeNodePRDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTree_NodePR;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_TreeNodePR - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_TreeNodePRQuery extends POQuery<MTree_NodePR> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTree_NodePR.Table_Name;
	}

	public CompletableFuture<MTree_NodePR> AD_TreeNodePR(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MTree_NodePR> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_TreeNodePRDataLoader.DATALOADER_AD_TreeNodePR_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MTree_NodePR> AD_TreeNodePRGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
