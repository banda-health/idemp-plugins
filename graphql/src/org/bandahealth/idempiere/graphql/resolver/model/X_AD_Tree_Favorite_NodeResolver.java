package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MMenu_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_MenuDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Tree_FavoriteDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Tree_Favorite_NodeDataLoader;
import org.compiere.model.MTreeFavorite;
import org.compiere.model.MTreeFavoriteNode;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Tree_Favorite_Node - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_Tree_Favorite_NodeResolver extends POResolver<MTreeFavoriteNode> implements GraphQLResolver<MTreeFavoriteNode> {



	/**
	 * Get Menu.
	 *
	 * @return Identifies a Menu
	 */
	public CompletableFuture<MMenu_BH> AD_Menu(MTreeFavoriteNode entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Menu_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MMenu_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_MenuDataLoader.DATALOADER_AD_Menu_BY_ID);
		return dataLoader.load(entity.getAD_Menu_ID());
	}


	/**
	 * Get Favorite Tree.
	 *
	 * @return Favorite Tree
	 */
	public CompletableFuture<MTreeFavorite> AD_Tree_Favorite(MTreeFavoriteNode entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Tree_Favorite_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MTreeFavorite> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Tree_FavoriteDataLoader.DATALOADER_AD_Tree_Favorite_BY_ID);
		return dataLoader.load(entity.getAD_Tree_Favorite_ID());
	}

	public Boolean IsCollapsible(MTreeFavoriteNode entity, DataFetchingEnvironment environment) {
		return entity.isCollapsible();
	}

	public Boolean IsFavourite(MTreeFavoriteNode entity, DataFetchingEnvironment environment) {
		return entity.isFavourite();
	}

	public Boolean IsSummary(MTreeFavoriteNode entity, DataFetchingEnvironment environment) {
		return entity.isSummary();
	}


	/**
	 * Get Parent.
	 *
	 * @return Parent of Entity
	 */
	public CompletableFuture<MTreeFavoriteNode> Parent(MTreeFavoriteNode entity, DataFetchingEnvironment environment) {
		if (entity.getParent_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MTreeFavoriteNode> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Tree_Favorite_NodeDataLoader.DATALOADER_AD_Tree_Favorite_Node_BY_ID);
		return dataLoader.load(entity.getParent_ID());
	}

}
