package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Tree_Favorite_NodeDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTreeFavoriteNode;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Tree_Favorite_Node - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_Tree_Favorite_NodeQuery extends POQuery<MTreeFavoriteNode> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTreeFavoriteNode.Table_Name;
	}

	public CompletableFuture<MTreeFavoriteNode> AD_Tree_Favorite_Node(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MTreeFavoriteNode> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Tree_Favorite_NodeDataLoader.DATALOADER_AD_Tree_Favorite_Node_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MTreeFavoriteNode> AD_Tree_Favorite_NodeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
