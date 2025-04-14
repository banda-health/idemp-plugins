package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TreeNodeDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTree_Node;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_TreeNode - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_TreeNodeQuery extends POQuery<MTree_Node> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTree_Node.Table_Name;
	}

	public CompletableFuture<MTree_Node> AD_TreeNode(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MTree_Node> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_TreeNodeDataLoader.DATALOADER_AD_TreeNode_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MTree_Node> AD_TreeNodeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
